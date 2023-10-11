<template>
  <div>
    <h1 class="card-title">Transaction Records</h1>
    <div>
      <input v-model="searchText" placeholder="Search by Name" class="search-input-id"></input>
      <button @click="searchByTransactionId">Search</button>
      <input v-model="searchStartTime" placeholder="YYYY-MM-DD" class="search-input-starttime" ></input>
      <button @click="searchByStartTime">Search</button>
    </div>
    <table class="transaction-table">
      <thead>
      <tr>
        <th>Transaction Name</th>
        <th>Start Time</th>
        <th>Amount($)</th>
        <th>Operating Company</th>
        <th>Payment Method</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="transaction in filteredTransactions" :key="transaction.id">
        <td>{{ transaction.name }}</td>
        <td>{{ transaction.startTime }}</td>
        <td>{{ transaction.amount }}</td>
        <td>{{ transaction.company }}</td>
        <td>{{ transaction.paymentMethod }}</td>
        <td><button @click="deleteTransaction(transaction.id)">Delete</button></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      transactions: [],
      searchText: '',
      filteredTransactions: [],
      searchStartTime:'',
      searchName:'',
    };
  },
  methods: {
    searchByTransactionId() {
      const searchText = this.searchText.toLowerCase().trim();
      if (searchText === '') {
        this.filteredTransactions = this.transactions;
        return;
      }
      this.filteredTransactions = this.transactions.filter((transaction) => {
        return transaction.id.toLowerCase().includes(searchText);
      });
    },
    searchByName(){
      const searchText = this.searchText.toLowerCase().trim();
      if (searchText === '') {
        this.filteredTransactions = this.transactions;
        return;
      }
      this.filteredTransactions = this.transactions.filter((transaction) => {
        return transaction.name.toLowerCase().includes(searchText);
      });
    },
    searchByStartTime() {
      const selectedStartTime = this.searchStartTime;
      if (selectedStartTime === '') {
        this.filteredTransactions = this.transactions;
        return;
      }
      this.filteredTransactions = this.transactions.filter((transaction) => {
        return transaction.startTime === selectedStartTime;
      });
    },

    deleteTransaction(transaction) {
      const index = this.transactions.findIndex((t) => t.id === transaction.id);
      if (index !== -1) {
        this.transactions.splice(index, 1);
      }
    },
  },
  mounted() {
    this.transactions = [
      {
        id:'1',
        name: 'Transaction 1',
        startTime: '2023-01-01',
        amount: 100.0,
        company: 'Company A',
        paymentMethod: 'Credit Card',
      },
      {
        id:'2',
        name: 'Transaction 2',
        startTime: '2023-02-15',
        amount: 75.5,
        company: 'Company B',
        paymentMethod: 'PayPal',
      },
      {
        id:'3',
        name: 'Transaction 3',
        startTime: '2023-03-20',
        amount: 50.0,
        company: 'Company C',
        paymentMethod: 'Bank Transfer',
      },
      {
        id:'4',
        name: 'Transaction 4',
        startTime: '2023-10-04',
        amount: 50.0,
        company: 'Company C',
        paymentMethod: 'Bank Transfer',
      },
      {
        id:'5',
        name: 'Transaction 5',
        startTime: '2023-10-02',
        amount: 500.0,
        company: 'Company E',
        paymentMethod: 'Comm',
      },
      {
        id:'6',
        name: 'Transaction 6',
        startTime: '2023-10-04',
        amount: 333.0,
        company: 'Company vvv',
        paymentMethod: 'Comm',
      },
    ];
    this.filteredTransactions = this.transactions;
  },
};
</script>
<style lang="scss">
@import "src/assets/sass/paper/_tablelist.scss";
</style>
