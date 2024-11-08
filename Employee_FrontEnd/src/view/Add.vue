<template>
<AddEmployee></AddEmployee>
<QueryEmployee></QueryEmployee>


</template>

<script>
import AddEmployee from '../components/AddEmployee.vue';
import QueryEmployee from '../components/QueryEmployee.vue';


export default {
    name:"/Add",
    components:{
        "AddEmployee":AddEmployee,
        "QueryEmployee":QueryEmployee,
    }
}

</script>
<style></style>

