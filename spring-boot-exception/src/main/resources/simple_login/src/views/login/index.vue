<script setup>
import {reactive, ref} from 'vue'
import {request} from "@/utils/request.js";

const userForm = reactive({
  "username": "yadira",
  "password": "123456",
  "age": 10,
  "phone": "15162721321",
  "idCard": "111111111111111111"
})

function validateForm(formData) {
  const usernamePattern = /^[a-z0-9_-]{3,16}$/; // 用户名以字母、数字、_-组成，3-16个字符
  const passwordPattern = /^[a-z0-9_-]{6,18}$/; // 密码与用户名规则相同，长度为6-18位
  const phonePattern = /^1[34578]\d{9}$/; // 手机号码验证
  const idPattern = /^\d{15}|\d{18}$/; // 验证身份证

  if (!usernamePattern.test(formData.username)) {
    alert('用户名无效！');
    return false;
  }

  if (!passwordPattern.test(formData.password)) {
    alert('密码无效！');
    return false;
  }

  if (!(formData.age >= 0 && formData.age <= 100)) {
    alert('年龄无效！应为0-100');
    return false;
  }

  if (!phonePattern.test(formData.phone)) {
    alert('手机号码无效！');
    return false;
  }

  if (!idPattern.test(formData.idCard)) {
    alert('身份证号码无效！');
    return false;
  }

  return true;
}


const handleSubmit = async () => {

  if (validateForm(userForm) === false)
    return

  console.log("用户信息", userForm)
  try {
    const res = await request.post("/user/add", userForm)
    console.log('返回结果', res)
    alert(res.data.msg)
  } catch (e) {

  }


}

</script>

<template>

  <div class="login">
    <h2>登录</h2>
    <form @submit.prevent="handleSubmit">
      <div>
        <label>用户名</label>
        <input type="text" v-model="userForm.username" required>
      </div>
      <div>
        <label>密码</label>
        <input type="password" v-model="userForm.password" required>
      </div>
      <div>
        <label>年龄</label>
        <input type="text" v-model="userForm.age" required>
      </div>
      <div>
        <label>手机号</label>
        <input type="text" v-model="userForm.phone" required>
      </div>
      <div>
        <label>身份证号</label>
        <input type="text" v-model="userForm.idCard" required>
      </div>
      <button type="submit">登录</button>
    </form>
  </div>

</template>