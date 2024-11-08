<template>
    <h3>刪除參加員工</h3>
     id:<input tpye="text" v-model="id" size="5"><br>
     <button @click="del()">送出</button>
     <hr>
     {{ message }}
</template>
<script>
import axios from 'axios';
export default{
    name:"DeleteEmployee",
    data:function(){
        return{
            id:'',
            message:''
        }
    },
    methods:{
        del()
        {
            axios
            .delete(`http://Localhost:8080/employee_person/deleteEmployee/${this.id}`)
            .then(response=>this.message=response.data)
            .catch(function(error){console.log(error)});
        }
    }
};


</script>