<template>
       <table width="50%" border="3" align="center">
        <tr align="center">
            <h3>後台管理</h3>
        </tr>
        <tr>
            <td>使用者:<input type="text" v-model="username"></td><br>
        </tr>
        <tr>
           <td> 密碼:<input type="password" v-model="password"></td><br>
        </tr>
        <tr>
            <td align="center">
                <button @click="login()">登入</button>
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
    name:"loginManager",
    data:function(){
        return{
            username:'',
            password:'',
            message:'',
     
        }
    },
    methods:{
        login() {
    const url = `http://localhost:8080/manager/login?username=${this.username}&password=${this.password}`;
    console.log("Sending data:", { username: this.username, password: this.password });

    axios
        .post(url)
        .then(response => {
            this.message = "登入成功";
            localStorage.setItem('isLoggedIn', 'true'); // 登入成功後設置登入狀態
            localStorage.setItem('username' , response.data);//儲存使用者名稱
           this.$router.push('/about'); // 登入成功後重定向到受保護頁面（例如 /about）
           
              
            // 1秒後重新整理頁面
              /* setTimeout(() => {
                location.reload();
            },200);*/
            window.location.href = '/about'; // 這會導致頁面重新整理
        
       
        })

        .catch(error => {
            console.error(error.response.data); // 查看具體錯誤信息
            this.message = error.response.data;
           
        });
}
        /* add() {
            const url = "http://localhost:8080/manager/login";
            const data = { username: this.username, password: this.password };
            console.log("Sending data:", data);

            axios.post(url, data)
                .then(response => {
                    this.message = response.data;
                })
                .catch(error => {
                    console.log(error);
                    this.message = "登入失敗";
                });*/
    }
    }


</script>
<style></style>