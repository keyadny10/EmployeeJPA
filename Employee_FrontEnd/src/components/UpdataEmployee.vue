<template>
    <div class="update">
    <table  class=table  border="1" >
    <tr>
        <td align="center" colspan="2"> <h3>更正名單</h3></td>
    </tr>
        <tr>
        <td>id  :</td>
           <td><input type="text" v-model="id" size="5"></td>  
        </tr>
    <tr>
        <td>員工編號:</td>
        <td><input type="text" v-model="number"></td>
    </tr>
    <tr>
        <td> 名字:</td>
        <td><input type="text" v-model="name"></td>
    </tr>
        
          
        <tr>
            <td>電話:</td>
            <td><input type="text" v-model="phone"></td>
        </tr>
        <tr>
            <td>地址:</td>
            <td><input type="text" v-model="address"></td>
        </tr>
        <tr><td align="center" colspan="2"><button @click="add()">送出</button></td></tr>
      </table>
    </div>
    <hr>
    {{ message }}
    
</template>
<script>
import axios from 'axios'


export default{
    name:'UpdataEmployee',
    data:function(){
        return {
            id:'',
           number:'',
            name:'',
            phone:'',
            address:'',
            message:'',
            
        }
    },
    methods:{
        add(){
            if (!this.number) {
            this.message = "員工編號不能為空！";
            return;
        }
        if (!this.name) {
            this.message = "名字不能為空！";
            return;
        }
        if (!this.phone) {
            this.message = "電話不能為空！";
            return;
        }
        if (!this.address) {
            this.message = "地址不能為空！";
            return;
        }
        
            var url=`http://Localhost:8080/employee_person/updateEmployee`;
            var data={
               id:this.id,
              no1:this.number,
                name:this.name,
                phone:this.phone,
                address:this.address,

            };

            axios
            .put(url,data)
            .then(response=>this.message=response.data)
            .catch(function(error){console.log(error);
                this.message="更新失敗";
            });
        }
    }
};


</script>
<style>

.update {
    width: 100%; /* 讓父容器寬度為 100% */
    display: flex; /* 啟用 flexbox */
    justify-content: center; /* 水平居中 */
}


.table{
    width: 300px; /* 設置表格的寬度 */
}

</style>