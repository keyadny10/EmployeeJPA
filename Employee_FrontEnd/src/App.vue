<template>
<div id="app">
  <div class="header" >
     <div class="text"><h1>芯愿旅行社</h1>
    </div>
  </div>
  <div class="navigater">

    <table width=80%  align="center">
      <tr align="center" valign="middle">
      
        <!--<td><router-link to="/">首頁</router-link></td>-->
        <td><router-link to="/About">資訊</router-link></td>
        <td><router-link to="/add">新增</router-link></td>
        <td><router-link to="/query">查詢</router-link></td>
        <td><router-link to="/updata">修改</router-link></td>
        <td><router-link to="/delete">刪除</router-link></td>
        <td><router-link to="/addManager">註冊</router-link></td>
        <br><hr>
        
        <td v-if="isLoggedIn">歡迎，{{username}}!</td><!--<button @click="logout">登出</button>-->
        <td v-if="isLoggedIn"><el-button type="info" round @click="logout">登出</el-button></td>
          <td v-if="!isLoggedIn"><router-link to="/login">管理員登入</router-link></td>
         
      </tr>
    </table>
  </div>
  <div class="content">

    <div class="con"><router-view></router-view></div>
  </div>
  <div class="footer">芯美區芯願街1段6號8樓之9</div>

</div>

</template>

<script>
import { ref , onMounted} from 'vue';
import LoginManager from './login/LoginManager.vue';


export default {
  components: {
    LoginManager
  },
  setup() {
    const isLoggedIn = ref(false); // 初始為 false
    const username = ref('');
    

    // 監聽 localStorage 的變化
    const checkLoginStatus = () => {
      isLoggedIn.value = localStorage.getItem('isLoggedIn') ===  'true'
      if(isLoggedIn.vale){
        username.value=localStorage.getItem('username');
      }

    };
    
    // 在組件創建時檢查登入狀態
    checkLoginStatus();

    /*const handleLoginSuccess = () => {
      isLoggedIn.value = true;
      //localStorage.setItem('isLoggedIn', 'true'); // 登入後設置狀態
      username.value=localStorage.getItem('username');
    };*/
    onMounted(()=>{
      username.value=localStorage.getItem('username')||'';
    })

  

    const logout = () => {
      isLoggedIn.value = false; // 清除登入狀態
      localStorage.removeItem('isLoggedIn'); // 清除 localStorage 中的登入狀態
      localStorage.removeItem('username');
      username.value='';
    };
    
    return {
      isLoggedIn,
      username,//返回使用者名稱


      logout
    };
  }
}
</script>
<style>
.header{
  margin-left:25%;
  width:50%;
  height:100px;
  background-color:#009ff5;
}
.text {
    display: flex;               /* 啟用 flexbox */
    justify-content: center;     /* 水平居中 */
    align-items: center;         /* 垂直居中 */
    height:100px;               /* 設定容器高度，根據需要調整 */
    
}
.navigater{
 margin-left: 25%;
 width:50%;
 height: 50px;
 background-color: #47BFFF;


}
.content{
  /*margin-left: 25%;
  width: 50%;
  height: 480px;
  background-color: #C2EAFF;*/

  margin-left: 25%;
  width: 50%;
  height: 480px;

  background-color: rgba(194, 234, 255, 0.5); /* 使背景色稍微透明 */
  background-image: url('./assets/travel.jpg'); /* 添加背景图 */
  background-size:900px 500px; /* 使背景图覆盖整个区域 也可以在 自定義長 寬*/

  background-repeat: no-repeat; /* 不重复背景图 */
  background-position: center; /* 背景图居中 */
  opacity: 0.7; /* 使内容略微透明，增加浮水印效果 1為實 ~~數字越小 圖片越虛*/
  display: flex; /* 启用 Flexbox */
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  
}
.con{
  /*padding-left: 2%;
  padding-top: 1%;*/
  width: 100%; /* 使内容宽度自适应 */
  height: 100%; /* 使内容高度自适应 */
  overflow: auto; /* 内容溢出时可滚动 */
 
}
.footer{
  margin-left: 25%;
  width:50%;
  height: 50px;
  background-color: #009ff5;
  color: aliceblue;
  text-align: center;
  font-size:25pt;
  
}


</style>