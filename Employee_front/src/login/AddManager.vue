<template>
    <table width="50%" border="3" align="center">
     <tr align="center">
         <h3>管理者註冊</h3>
     </tr>
     <tr>
         <td>使用者:<input type="text" v-model="username"></td><br>
     </tr>
     <tr>
        <td> 密碼:<input type="password" v-model="password"></td><br>
     </tr>
     <tr>
         <td align="center">
             <button @click="addM()">註冊</button>
         </td>
     </tr>
 </table>

 <hr>
<h1> {{message}}</h1>
 <hr>    
</template>

<script>
import axios from 'axios'

export default{
 name:"/addManager",
 data:function(){
     return{
         username:'',
         password:'',
         message:'',
  
     }
 },
 methods:{
     addM() {
 const url = `http://localhost:8080/manager/addManager?username=${this.username}&password=${this.password}`;
 console.log("Sending data:", { username: this.username, password: this.password });

 axios
     .post(url)
     .then(response => {
         this.message = response.data;
     })
     .catch(error => {
         console.error(error.response.data); // 查看具體錯誤信息
         this.message =error.response.data;
     });
    }
    
 }
}


</script>
<style></style>