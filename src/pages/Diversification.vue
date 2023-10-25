<template>
  <card class="card-map" title="Consumption visualization">
    <button  @click="showLineChart">Line chart</button>
    <button  @click="showBarChart">Bar chart</button>
    <div id="chart-container"></div>
    <card class="card-map" title="Exchange rate converter">
    <div class="input-container">
      <label for="amount">Amount（AUD）</label>
      <input type="number" id="amount" v-model="usdAmount" @input="convertCurrency" />
    </div>
    <div class="result">
      <p>Equivalent amount：</p>
      <p v-if="convertedAmount">{{ convertedAmount }} {{ selectedCurrency }}</p>
    </div>
    <div class="currency-selector">
      <label for="currency">Select currency</label>
      <select id="currency" v-model="selectedCurrency" @change="convertCurrency">
        <option v-for="(rate, currency) in exchangeRates" :key="currency" :value="currency">{{ currency }}</option>
      </select>
    </div>
      </card>
  </card>
</template>
<script>
import Highcharts from 'highcharts';
import axios from 'axios';
export default {
  data() {
    return {
      chart: null,
      chartType: 'line', // 默认显示折线图
      usdAmount: 1, // 默认金额为1美元
      selectedCurrency: 'EUR', // 默认选择欧元
      exchangeRates: {}, // 存储汇率数据
      convertedAmount: null, // 存储转换后的金额
    };
  },
  methods: {
    showLineChart() {
      this.chartType = 'line'; // 切换为折线图
      this.renderChart();
    },
    showBarChart() {
      this.chartType = 'column'; // 切换为柱状图
      this.renderChart();
    },
    renderChart() {
      if (this.chart) {
        this.chart.destroy(); // 销毁之前的图表实例
      }

      this.chart = Highcharts.chart('chart-container', {
        chart: {
          type: this.chartType, // 根据chartType属性选择图表类型
        },
        title: {
          text: this.chartType === 'line' ? 'Line chart' : 'Bar chart',
        },
        series: [{
          name: 'Year consumption',
          data: [1, 2, 3, 4, 5], // 你的数据
        }],
      });
    },
    async fetchExchangeRates() {
      const API_KEY = '4eab14c9d1a91715250fdb98'; // 使用提供的API密钥
      const BASE_CURRENCY = 'AUD'; // 基础货币

      try {
        const response = await axios.get(`https://v6.exchangerate-api.com/v6/${API_KEY}/latest/${BASE_CURRENCY}`);
        this.exchangeRates = response.data.conversion_rates;
        this.convertCurrency(); // 初始转换货币
      } catch (error) {
        console.error('获取汇率数据失败：', error);
      }
    },
    convertCurrency() {
      const rate = this.exchangeRates[this.selectedCurrency];
      if (rate) {
        this.convertedAmount = (this.usdAmount * rate).toFixed(2); // 保留两位小数
      } else {
        this.convertedAmount = null;
      }
    },
    },

  mounted() {
    this.renderChart(); // 初始渲染图表
    this.fetchExchangeRates(); // 获取汇率数据
  },
};
</script>
<style scoped>
.exchange-rate-calculator {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.input-container {
  margin-bottom: 10px;
}

.result {
  font-size: 18px;
  font-weight: bold;
  margin-top: 10px;
}

.currency-selector {
  margin-top: 20px;
}
</style>
