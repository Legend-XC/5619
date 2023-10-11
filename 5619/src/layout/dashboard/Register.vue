<template>
  <div class="container">
    <div class="main">
      <div class="loginbox">
        <div class="loginbox-in">
          <div class="userbox">
            <span class="iconfont">&#xe725;</span>
            <input  class="user" id="user"  v-model="name" placeholder="Account">
          </div>
          <br>
          <div class="pwdbox">
            <span class="iconfont">&#xe72f;</span>
            <input  class="pwd"  id="password" v-model="pwd" type="password"  placeholder="Password">
          </div>
          <br>
          <div class="pwdbox">
            <span class="iconfont">&#xe72f;</span>
            <input  class="pwd"  id="re_password"  v-model="repwd" type="password"  placeholder="Confirm password">
          </div>
          <button type="primary"  class="register_btn" @click="ButtonClick">Login</button>
          <button type="button"  class="register_btn2" @click="RegisterButtonClick">Register</button>
        </div>
        <div class="background">
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    ButtonClick() {

      this.$router.push("/");

    },

    RegisterButtonClick() {
      var flag=1;
      //如果用户名已存在，则需要换一个用户名
      this.user_list.forEach((item) => {
        if(item.username==this.name){
          alert('用户已存在,请换一个用户名');
          flag=0;}
      })
      //如果用户名不存在，则继续判断
      if(flag) {
        //判断两次输入的密码是否一致，如果密码不一致，则需要重新输入
        if (this.pwd != this.repwd) {
          alert('两次输入的密码不一致,请重新输入');
        } else {
          var item = {};
          //获取到用户名
          item.username = this.name;
          //获取到密码
          item.password = this.pwd;
          //存储到用户列表
          this.user_list.push(item);
          alert('注册成功');
          //    this.user_list.forEach((item) => {
          //       console.log( item.username);
          // })

          this.$router.push({
            path: '/',
            query: {
              list: this.user_list,
            }
          })
        }
      }



      },
  }
}

</script>
