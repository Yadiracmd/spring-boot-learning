<script setup>
import {reactive, ref} from 'vue'
import {request} from "@/utils/request.js";
import axios from "axios";

const userForm = reactive({
  "username": "yadira",
  "password": "123456",
  "age": 10,
  "phone": "15162721321",
  "idCard": "111111111111111111"
})



const handleSubmit = () => {
  axios.post("http://127.0.0.1:8080/user/add", userForm).then(res=>{
    console.log('返回结果', res)
    alert(res.data.msg)
  })




}

</script>

<template>
  <div class="login">
    <h2>登录</h2>
    <form @submit.prevent="handleSubmit">
      <div class="input-group">
        <label>用户名</label>
        <input type="text" v-model="userForm.username" required>
      </div>
      <div class="input-group">
        <label>密码</label>
        <input type="password" v-model="userForm.password" required>
      </div>
      <div class="input-group">
        <label>年龄</label>
        <input type="text" v-model="userForm.age" required>
      </div>
      <div class="input-group">
        <label>手机号</label>
        <input type="text" v-model="userForm.phone" required>
      </div>
      <div class="input-group">
        <label>身份证号</label>
        <input type="text" v-model="userForm.idCard" required>
      </div>
      <button type="submit" class="submit-btn">登录</button>
    </form>
  </div>
</template>

<style scoped>
.login {
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
  text-align: center;
  padding: 15px;
}

.input-group {
  margin-bottom: 15px;
}

.input-group label {
  display: block;
  margin-bottom: 5px;
}

.input-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.submit-btn {
  background-color: #007BFF;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 10px;
  width: 100%;
  margin-top: 10px;
  cursor: pointer;
}

.submit-btn:hover {
  background-color: #0056b3;
}
</style>