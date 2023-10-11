<template>
  <table class="table" :class="tableClass">
  <thead>
  <slot name="columns">
    <th v-for="column in columns" :key="column">{{ column }}
    </th>
    <th>
      Action
    </th>
  </slot>
  </thead>
  <tbody>
  <tr v-for="(item, index) in data" :key="index">
    <slot :row="item">
      <td
        v-for="(column, index) in columns"
        :key="index"
        v-if="hasValue(item, column)"
        :class=getStatusColor(item[column.toLowerCase()])
        v-html="getStatusLink(item[column.toLowerCase()])"
      >
      {{ itemValue(item, column) }}
      </td>
      <p-button type="info" round @click.native.prevent="deleteBill">
        Delete
      </p-button>
    </slot>
  </tr>
  </tbody>
  </table>
</template>

<script>
import Button from "@/components/Button";
import DOMPurify from 'dompurify';

export default {
  name: "bill-table",
  props: {
    columns: Array,
    data: Array,
    type: {
      type: String, // striped | hover
      default: "striped",
    },
    title: {
      type: String,
      default: "",
    },
    subTitle: {
      type: String,
      default: "",
    },
  },
  computed: {
    tableClass() {
      return `table-${this.type}`;
    },
  },
  methods: {
    hasValue(item, column) {
      return item[column.toLowerCase()] !== "undefined";
    },
    itemValue(item, column) {
      return item[column.toLowerCase()];
    },
    handleButtonClick() {
      // Handle button click for the specific row index
      console.log(`Delete!`);
    },
    colorValue(item,column){
      return item[column.getStatusColor()];
    },
    getStatusColor(status) {
      if (status === "paid") {
        return "paid-color";
      } else if (status === "unpaid") {
        return "unpaid-color";
      } else if (status === "overdue") {
        return "overdue-color";
      }
      // Default color if none of the above conditions match
      return status;
    },
    getStatusLink(status){
      if (status.includes("www")) {
        const absoluteURL = `http://${status}`;
        const sanitizedLink = DOMPurify.sanitize(`<a href="${absoluteURL}" target="_blank">${absoluteURL}</a>`);
        return sanitizedLink;
      } else if (status.includes("http://") || status.includes("https://")) {
        // Handle other absolute URLs with http:// or https://
        const sanitizedLink = DOMPurify.sanitize(`<a href="${status}" target="_blank">${status}</a>`);
        return sanitizedLink;
        return sanitizedLink;
      }
      // Default color if none of the above conditions match
      return status;
    }

  },
};
</script>

<style scoped>
.paid-color{
  color: #55a532;
}
.unpaid-color {
  color: #BB992F; /* Change to the desired color for "unpaid" status */
}

.overdue-color {
  color: #DD4A68; /* Change to the desired color for "overdue" status */
}
.default-color{

}
</style>
