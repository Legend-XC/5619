<template>
  <div class="row">
    <div class="col-md-12">
      <card>
        <template slot="header">
          <h4 class="card-title">Add Bill</h4>
        </template>
        <div class="content">
          <div class="typo-line">
            <h4>
              Bill name: <input type="text" class="inputbox" id="billName" v-model="billName">
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Bill amount:<input type="text" class="inputbox" id="billAmount" v-model="billAmount">
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Name of operating company:<input type="text" class="inputbox" id="NameOfCompany" v-model="NameOfCompany">
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Payment address:<input type="text" class="inputbox" id="paymentAddress" v-model="paymentAddress">
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Due time: <datepicker id="dueTime" v-model="selectedDueTime" class="inputtime" format="YYYY-MM-DD" :disabled-dates="disabledDates"></datepicker>
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              . <p-button @click="clearFields" type="info" class="cancelbutton">Cancel</p-button>
              <p-button @click="submitData" type="info" class="confirmbutton">Add</p-button>
            </h4>
          </div>
        </div>
      </card>
    </div>
  </div>
</template>

<script>
import Datepicker from 'vue2-datepicker'
import 'vue2-datepicker/index.css'
export default {
  components: {
    Datepicker
  },
  data() {
    return {
      billName: '',
      billAmount: '',
      NameOfCompany: '',
      paymentAddress: '',
      selectedDueTime: '',
      disabledDates: { to: new Date() }
    }
  },
  methods: {
    clearFields() {
      this.billName = '';
      this.billAmount = '';
      this.NameOfCompany = '';
      this.paymentAddress = '';
      this.selectedDueTime = '';
    },
    submitData() {
      console.log('Bill Name: ' + this.billName);
      console.log('Bill Amount: ' + this.billAmount);
      console.log('Name Of Company: ' + this.NameOfCompany);
      console.log('Payment Address: ' + this.paymentAddress);
      console.log('Due Time: ' + this.selectedDueTime);
    }
  }
}
</script>

