<template>
  <div class="container">
    <div class="main">
      <div class="loginbox">
        <div class="loginbox-in">
          <div class="userbox">
            <span class="iconfont">&#xe725;</span>
            <input  class="user" id="user"  v-model="user_id" placeholder="Account">
          </div>
          <br>
          <div class="pwdbox">
            <span class="iconfont">&#xe72f;</span>
            <input  class="pwd"  id="password" v-model="password" type="password"  placeholder="Password">
          </div>
          <button type="primary"  class="register_btn" @click="handleButtonClick">Register</button>
          <button type="button" class="login_btn" @click="loginButtonClick">Login</button>
        </div>


        <div class="background">

        </div>



      </div>
    </div>
  </div>
</template>


<script>
import axios from 'axios'
export default {


  methods: {
    handleButtonClick() {

      this.$router.push("Register");

    },

    loginButtonClick(){

      var flag=0;
      //如果是有参数传递
      if(!this.$route.query.list){
        this.user_list.forEach((item) => {
            if(item.username==this.name){
              if(item.password==this.pwd){
                flag=1;//用户存在，并且密码正确
              }
            }
          }
        )
        if(flag==1){
          //可以跳转到主页
          this.$router.push("dashboard");
        }
        else{
          alert("用户名或密码错误，请重新输入");
        }
      }
      else{
        // 取到路由带过来的参数
        var routerParams = this.$route.query.list;
        this.user_list = routerParams;

        this.user_list.forEach((item) => {
            if(item.username==this.name){
              if(item.password==this.pwd){
                flag=1;//用户存在，并且密码正确
              }
            }
          }
        )
        if(flag==1){
          //可以跳转到主页
          // this.$router.push("Homepage");
          this.$router.push({
              path: '"dashboard',
            }
          )
        }
        else{
          alert("用户名或密码错误，请重新输入");}
      }
    },
  }
}

</script>

