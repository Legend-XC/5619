<template>
  <div class="row">
    <div class="col-md-12">
      <card>
        <template slot="header">
          <h4 class="card-title">Addition</h4>
        </template>
        <div class="content">
          <div class="typo-line">
            <h4>
              Transaction name: <input type="text" class="inputbox" id="transactionName" v-model="transactionName">
            </h4>
          </div>

          <div class="typo-line">
            <h4>
              Transaction type:<input type="text" class="inputbox" id="transactionType" v-model="transactionType">
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Transaction amount:<input type="text" class="inputbox" id="transactionAmount" v-model="transactionAmount">
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
              Start time:<datepicker id="startTime" v-model="selectedStartTime" class="inputtime" format="YYYY-MM-DD" :disabled-dates="disabledDates"></datepicker>
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              Due time: <datepicker id="dueTime" v-model="selectedDueTime" class="inputtime" format="YYYY-MM-DD" :disabled-dates="disabledDates"></datepicker>
            </h4>
          </div>
          <div class="typo-line">
            <h4>
              . <p-button   @click="clearFields" type = "info" class="cancalbutton">Cancal</p-button>
              <p-button  @click="submitData" type = "info" class="confirmbutton">Add</p-button>
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
      transactionName: '',
      transactionType: '',
      transactionAmount: '',
      NameOfCompany: '',
      paymentAddress: '',
      selectedStartTime: '',
      selectedDueTime: '',
      disabledDates: { to: new Date() }
    }
  },
  methods: {
    clearFields() {
      this.transactionName = '';
      this.transactionType = '';
      this.transactionAmount = '';
      this.NameOfCompany = '';
      this.paymentAddress = '';
      this.selectedStartTime = '';
      this.selectedDueTime = '';
    },
    submitData() {
      if (!this.transactionName || !this.transactionType || !this.transactionAmount) {
        alert('Please type necessary information!');
        return;
      }
      console.log('Transaction Name: ' + this.transactionName);
      console.log('Transaction Type: ' + this.transactionType);
      console.log('Transaction Amount: ' + this.transactionAmount);
      console.log('Name Of Company: ' + this.NameOfCompany);
      console.log('Payment Address: ' + this.paymentAddress);
      console.log('Start Time: ' + this.selectedStartTime);
      console.log('Due Time: ' + this.selectedDueTime);
    }
  }
}
</script>


