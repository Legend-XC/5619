<template>


  <div class="row">
    <div class="col-12">
    <card class="card" title="Bills Search" sub-title="You can search bills by name.">


      <div class="col-12">
        <fg-input
          type="text"
          placeholder="bill name"
          v-model="billsearch"
        >
        </fg-input>
        <p-button type="info" round @click.native.prevent="searchBills">
          Search
        </p-button>
      </div>

    </card>
    </div>

    <div class="text-left">
    </div>

    <div class="col-12">
      <card :title="table1.title" :subTitle="table1.subTitle">
        <div slot="raw-content" class="table-responsive">
          <bill-table :data="filteredData" :columns="table1.columns">
          </bill-table>
        </div>
      </card>
    </div>


  </div>
</template>

<script>

import { PaperTable } from "@/components";
import BillTable from "@/components/BillTable";

const tableColumns = [ "Name", "Amount", "Address", "IsPaid", "DueTime"];
const tableData = [
  {
    name: "Dakota Rice",
    amount: "$36.738",
    address: "www.google.com",
    ispaid: "overdue",
    duetime:"2023-10-10",
  },
  {
    name: "Minerva Hooper",
    amount: "$23,789",
    address: "Curaçao",
    ispaid: "unpaid",
    duetime:"2023-10-05",
  },
  {
    name: "Sage Rodriguez",
    amount: "$56,142",
    address: "Netherlands",
    ispaid: "paid",
    duetime:"2023-10-06",
  },
  {
    name: "Philip Chaney",
    amount: "$38,735",
    address: "Korea, South",
    ispaid: "paid",
    duetime:"2023-10-08",
  },
  {
    name: "Doris Greene",
    amount: "$63,542",
    address: "Malawi",
    ispaid: "unpaid",
    duetime:"2023-10-09",
  },
];

export default {
  components: {
    BillTable,
    PaperTable,
  },
  data() {
    return {
      table1: {
        title: "Bills History",
        subTitle: "There are bills that you have recorded.",
        columns: [...tableColumns],
        data: [...tableData],
      },
      filteredData: [...tableData],
      isColorEnabled: false,
      colorClasses: {
        'paid-color': false,
        'unpaid-color': false,
        'overdue-color': false,
      },
    };
  },
  created() {
    this.filteredData = this.table1.data
      .sort((a, b) => {
        const dateA = new Date(a.duetime);
        const dateB = new Date(b.duetime);
        return dateA - dateB;
      });
    this.filteredData = this.table1.data.
    sort((a, b) => {
      const order = { 'overdue': 1, 'unpaid': 2, 'paid': 3 };
      return order[a.ispaid] - order[b.ispaid];
    })
  },
  methods: {
    searchBills() { // Search methods in the Bill table
      const searchTerm = this.billsearch.toLowerCase();
      this.filteredData = this.table1.data
        .filter(item => item.name.toLowerCase().includes(searchTerm))

        .sort((a, b) => {
          // Convert DueTime strings to Date objects for proper comparison
          const dateA = new Date(a.duetime);
          const dateB = new Date(b.duetime);

          // Compare dates
          return dateA - dateB;
        })
        .sort((a, b) => {
          const order = { 'overdue': 1, 'unpaid': 2, 'paid': 3 };
          return order[a.ispaid] - order[b.ispaid];
        });
    },
    // Change colour methods


  },

};
</script>

<style scoped>


</style>
