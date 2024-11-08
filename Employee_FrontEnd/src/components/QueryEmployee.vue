<!--<template>
    <div>
        <table width="100%" border="1">
            <tr>
                <td>id</td>
                <td>編號</td>
                <td>名字</td>
                <td>電話</td>
                <td>地址</td>
            </tr>
            <tr v-for="item in paginatedData" :key="item.id">
                               
                <td>{{ item.id }}</td>
                <td>{{ item.no1}}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.phone }}</td>
                <td>{{ item.address}}</td>


            </tr>
        </table>
        <div>
            <button @click="gotoPage(currentPage-1)" :disableed="currentPage==1">上一頁</button>
            <button
                v-for="page in totalPages"
                :key ="page"
                @click="gotoPage(page)"
                :class="{active:currentPage==page}">{{page }}</button>
                <button @click="gotoPage(currentPage+1)" :disableed="currentPage==totalPage">下一頁</button>
        </div>
    </div>
    
</template>
<script>
import axios from 'axios'

export default{
    name:'QueryEmployee',
    data:function(){
        return{
            info:[],
            currentPage:1,
            pageSize:3,
        }
    },
    mounted(){
        var url="http://Localhost:8080/employee_person/queryEmployee";
        axios
        .get(url)
        .then(response=>this.info=response.data);
    },
    computed:{
        totalPages(){
            return Math.ceil(this.info.length/this.pageSize);
        },
        paginatedData(){
            const start=(this.currentPage-1)*this.pageSize;
            const end=start+this.pageSize;
            return this.info.slice(start,end);
        },
    },
    methods:{
        gotoPage(page){
if(page>=1 && page<=this.totalPages){
    this.currentPage=page;
}
        }
    }
}


</script>
<style></style>-->
<template>
    <div>
        <table width="100%" border="1">
            <tr>
                <td>id</td>
                <td>編號</td>
                <td>名字</td>
                <td>電話</td>
                <td>地址</td>
            </tr>
            <tr v-for="item in info" :key="item.id">
                <td>{{ item.id }}</td>
                <td>{{ item.no1 }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.phone }}</td>
                <td>{{ item.address }}</td>
            </tr>
        </table>
        <div>
            <button @click="gotoPage(currentPage - 1)" :disabled="currentPage === 1">上一頁</button>
            <button
                v-for="page in totalPages"
                :key="page"
                @click="gotoPage(page)"
                :class="{ active: currentPage === page }">{{ page }}</button>
            <button @click="gotoPage(currentPage + 1)" :disabled="currentPage === totalPages">下一頁</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'QueryEmployee',
    data() {
        return {
            info: [],
            currentPage: 1,//到查詢畫面從第幾頁開始
            pageSize: 5,//每頁需要幾筆資料
            totalPages: 0,
        }
    },
    mounted() {
        this.fetchEmployees(this.currentPage);
    },
    methods: {
        fetchEmployees(page) {
    const url = `http://localhost:8080/employee_person/queryEmployee?page=${page - 1}&size=${this.pageSize}`; // 注意頁碼從 0 開始進行分頁
    axios
        .get(url)
        .then(response => {
            this.info = response.data.content; // 獲取當前頁的內容
            this.totalPages = response.data.totalPages; // 總頁數
        })
        .catch(error => {
            console.error("Error fetching employees:", error);
        });
},
        gotoPage(page) {
            if (page >= 1 && page <= this.totalPages) {
                this.currentPage = page;
                this.fetchEmployees(page); // 請求新的頁面數據
            }
        }
    }
}
</script>

<style>
.active {
    font-weight: bold;
}
</style>
