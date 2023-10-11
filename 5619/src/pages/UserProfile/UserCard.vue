<template>
  <card class="card-user">
    <div slot="image">
      <img src="@/assets/img/background.jpg" alt="..."/>
    </div>
    <div>
      <div class="author">
        <img
          class="avatar border-white"
          src="@/assets/img/faces/face-2.jpg"
          alt="..."
        />
        <h4 class="title">
          User Name
          <br />
          <a href=" ">
            <small>@email</small>
          </a >
        </h4>
      </div>

    </div>
    <hr />
    <div class="text-center">
      <div class="row justify-content-center">
        <div
          v-for="(info, index) in details"
          :class="col-lg-3"
        >
          <h5>
            {{ info.title }}
            <br />
            <small>{{ info.subTitle }}</small>
          </h5>
        </div>
      </div>
    </div>
  </card>
</template>
<script>
export default {
  data() {
    return {
      details: [
        {
          title: "4000 AUD",
          subTitle: "Spending Limits",
        },
      ],
    };
  },
  methods: {

  },
};
</script>
<style></style>
