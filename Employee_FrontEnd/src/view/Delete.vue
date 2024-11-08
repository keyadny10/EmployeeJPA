<template>

<DeleteEmployee></DeleteEmployee>
<hr>
<QueryEmployee></QueryEmployee>
</template>
<script>
import DeleteEmployee from '../components/DeleteEmployee.vue';
import QueryEmployee from '../components/QueryEmployee.vue';


export default{
    name:"/Delete",
    components:{
        "DeleteEmployee":DeleteEmployee,
        "QueryEmployee":QueryEmployee,
    }
}
</script>