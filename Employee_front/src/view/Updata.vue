<template>
<UpdatdEmployee></UpdatdEmployee>
<hr>
   <QueryEmployee></QueryEmployee>
</template>
<script>
import UpdatdEmployee from '@/components/UpdataEmployee.vue';
import QueryEmployee from '@/components/QueryEmployee.vue';

export default{
    name:"/Updata",
    components:{
        "UpdatdEmployee":UpdatdEmployee,
        "QueryEmployee":QueryEmployee,
    }
}
</script>
<style></style>