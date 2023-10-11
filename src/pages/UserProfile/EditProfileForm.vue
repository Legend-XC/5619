<template>
  <card class="card" title="Edit Profile">
    <div>
      <form @submit.prevent>
        <div class="row">
          <div class="col-md-5">
            <fg-input
              type="text"
              label="User ID"
              :disabled="true"
              placeholder="User ID"
              v-model="user.userID"
            >
            </fg-input>
          </div>
          <div class="col-md-3">
            <fg-input
              type="text"
              label="Username"
              placeholder="Username"
              v-model="user.username"
            >
            </fg-input>
          </div>
          <div class="col-md-4">
            <fg-input
              type="email"
              label="Username"
              placeholder="Email"
              v-model="user.email"
            >
            </fg-input>
          </div>
        </div>



        <div class="row">
          <div class="col-md-12">
            <fg-input
              type="text"
              label="Password"
              placeholder="Password"
              v-model="user.password"
            >
            </fg-input>
          </div>
        </div>

        <div class="row">

          <div class="col-md-12">
            <fg-input
              type="text"
              label="Spending Limits"
              placeholder="Spending Limits"
              v-model="user.limits"
            >
            </fg-input>
          </div>
        </div>


        <div class="text-center">
          <p-button type="info" round @click.native.prevent="updateProfile">
            Update Profile
          </p-button>
        </div>
        <div class="clearfix"></div>
      </form>
    </div>
  </card>
</template>
<script>
export default {
  data() {
    return {
      user: {
        userID: "user ID",
        username: "michael23",
        email: "12345@gmail.com",
        password: "password",
        limits: "4000 AUD",
      },
    };
  },
  methods: {
    updateProfile() {
      alert("Your data: " + JSON.stringify(this.user));
    },
  },
};
</script>
<style></style>
