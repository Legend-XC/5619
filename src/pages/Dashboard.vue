<template>
  <div>
    <!--Stats cards-->
    <div class="row">
      <div
        class="col-md-6 col-xl-3"
        v-for="stats in statsCards"
        :key="stats.title"
      >
        <stats-card>
          <div
            class="icon-big text-center"
            :class="`icon-${stats.type}`"
            slot="header"
          >
            <i :class="stats.icon"></i>
          </div>
          <div class="numbers" slot="content">
            <p>{{ stats.title }}</p>
            {{ stats.value }}
          </div>
        </stats-card>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 col-12">
        <card title="This Month Overview" sub-title="for this month">
          <div class="text-center">
            <div class="row justify-content-center">
              <card
                v-for="(info, index) in monthCards"
                :class="col-md-10"
              >
                <h5>
                  {{ info.title }}
                  <br />
                  <small>{{ info.value }}</small>
                </h5>
              </card>
            </div>
          </div>
        </card>
      </div>
      <div class="col-md-6 col-12">
        <card title="Upcoming Bill's Reminder" sub-title="for all bills">
          <div class="text-center">
            <div class="row justify-content-center">
              <card
                v-for="(info, index) in billsCards"
                :class="col-md-10"
              >
                <h5>
                  {{ info.title }}
                  <br />
                  <router-link v-if="shouldShowLink(info.title)" to="/bills">
                    <small class="clickable-value">{{ info.value }}</small></router-link>
                  <small v-if="!shouldShowLink(info.title)">{{ info.value }}</small>
                </h5>
              </card>
            </div>
          </div>
        </card>
      </div>
    </div>

    <!--Charts-->
    <div class="row">
      <div class="col-12">
        <chart-card
          title="Monthly Cash Flow"
          sub-title="The cash flow in each month"
          :chart-data="usersChart.data"
          :chart-options="usersChart.options"
        >
          <span slot="footer">
            <i class="ti-reload"></i> For this year
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> Income
            <i class="fa fa-circle text-danger"></i> Spending
            <i class="fa fa-circle text-warning"></i> Investment
          </div>
        </chart-card>
      </div>

      <div class="col-12">
        <card
          title="Bill versus daily expenses">
          <table class="table">
            <thead>
            <tr>
              <th>Month</th>
              <th>Bill</th>
              <th>Daily expenses</th>
              <!-- Add more column headers as needed -->
            </tr>
            </thead>
            <tbody>
            <tr v-for="(item, index) in databaseData" :key="index">
              <td>{{ item.column1 }}</td>
              <td>{{ item.column2 }}</td>
              <td>{{ item.column3 }}</td>
              <!-- Display more columns as needed -->
            </tr>
            </tbody>
          </table>
          <div >
          <input v-model="emailData" placeholder="Enter email content">
            <button @click="sendEmail">Send Email</button>
          </div>
        </card>
      </div>
    </div>


    <div class="col-md-6 col-12">
      <chart-card
        title="Cash Flow Statistics"
        sub-title="Cash flow in this month"
        :chart-data="cashFlowPieChart.data"
        chart-type="Pie"
      >
          <span slot="footer">
            <i class="ti-timer"></i> This month</span
          >
        <div slot="legend">
          <i class="fa fa-circle text-info"></i> Income
          <i class="fa fa-circle text-danger"></i> Spending
          <i class="fa fa-circle text-warning"></i> Investment
        </div>
      </chart-card>
    </div>

    <div class="col-md-6 col-12">
      <chart-card
        title="Bills Statistics"
        sub-title="Total Bills"
        :chart-data="billsPieChart.data"
        chart-type="Pie"
      >
          <span slot="footer">
            <i class="ti-timer"></i> Total </span
          >
        <div slot="legend">
          <i class="fa fa-circle text-info"></i> Paid
          <i class="fa fa-circle text-danger"></i> Overdue
          <i class="fa fa-circle text-warning"></i> Unpaid
        </div>
      </chart-card>
    </div>
  </div>
</template>

<script>
import { StatsCard, ChartCard } from "@/components/index";
import Chartist from "chartist";
import Bills from "@/pages/Bills"
import axios from "axios";
export default {

  components: {
    StatsCard,
    ChartCard,
  },
  /**
   * Chart data used to render stats, charts. Should be replaced with server data
   */
  data() {
    return {
      databaseData: [],

      emailData: '',
      statsCards: [
        {
          type: "warning",
          icon: "ti-server",
          title: "Total Spending($)",
          value: "loading...",
        },
        {
          type: "success",
          icon: "ti-wallet",
          title: "Cost Today($)",
          value: "loading...",

        },
        {
          type: "danger",
          icon: "ti-receipt",
          title: "Unpaid Bills($)",
          value: "loading...",
        },
        {
          type: "info",
          icon: "ti-face-smile",
          title: "Paid Bills($)",
          value: "loading...",
        },
      ],
      monthCards: [
        {
          title: "This month spending on bills",
          value: "$300",
        },
        {
          title: "This month's spending",
          value: "$4,000",
        },
      ],
      billsCards: [
        {
          title: "The bill's name",
          value: "Dakota Rice",
        },
        {
          title: "The bill's due date",
          value: "2023-10-10",
        },
      ],
      usersChart: {
        data: {
          emailData:'',

          labels: [
            "9:00AM",
            "12:00AM",
            "3:00PM",
            "6:00PM",
            "9:00PM",
            "12:00PM",
            "3:00AM",
            "6:00AM",
          ],
          series: [
            [287, 385, 490, 562, 594, 626, 698, 895, 952],
            [67, 152, 193, 240, 387, 435, 535, 642, 744],
            [23, 113, 67, 108, 190, 239, 307, 410, 410],
          ],
        },
        mounted() {
          this.fetchStatsData();
        },
        methods: {
          async fetchStatsData() {
            try {
              const response = await axios.get('/api/dashboard-stats');
              const data = response.data;
              this.statsCards[0].value = data.totalSpending;
              this.statsCards[1].value = data.costToday;
              this.statsCards[2].value = data.unpaidBills;
              this.statsCards[3].value = data.paidBills;

            } catch (error) {
              console.error('Error fetching data:', error);
            }
          },
        },
        options: {
          low: 0,
          high: 1000,
          showArea: true,
          height: "245px",
          axisX: {
            showGrid: false,
          },
          lineSmooth: Chartist.Interpolation.simple({
            divisor: 3,
          }),
          showLine: true,
          showPoint: false,
        },
      },
      activityChart: {
        data: {
          labels: [
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "Mai",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec",
          ],
          series: [
            [542, 543, 520, 680, 653, 753, 326, 434, 568, 610, 756, 895],
            [230, 293, 380, 480, 503, 553, 600, 664, 698, 710, 736, 795],
          ],
        },
        options: {
          seriesBarDistance: 10,
          axisX: {
            showGrid: false,
          },
          height: "245px",
        },
      },
      preferencesChart: {
        data: {
          labels: ["62%", "32%", "6%"],
          series: [62, 32, 6],
        },
        options: {},
      },
      cashFlowPieChart: {
        data: {
          labels: ["62%", "32%", "6%"],
          series: [62, 32, 6],
        },
        options: {},
      },
      billsPieChart: {
        data: {
          labels: ["52%", "32%", "16%"],
          series: [52, 32, 16],
        },
        options: {},
      },

    };
  },
  methods: {
    shouldShowLink(title) {
      if(title.includes("name"))
        return true;
      else
        return false;
    },
    fetchData() {
      axios.get('/api/getData')
        .then(response => {
          this.databaseData = response.data; // 将数据存储在databaseData中
        })
        .catch(error => {
          console.error(error);
        });
    },
    sendEmail() {
      const emailRequest = {
        to: this.emailData,
        subject: 'Email Subject',
        body: 'Email Body',
      };

      axios.post('/api/sendEmail', emailRequest)
        .then(() => {
          console.log('Email sent successfully');
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};
</script>
<style>
.clickable-value {
  color: indianred; /* Change to your desired text color for clickable text */
  text-decoration: underline; /* Add underline to indicate it's a link */
  cursor: pointer; /* Change cursor style to pointer to indicate it's clickable */
}
</style>
