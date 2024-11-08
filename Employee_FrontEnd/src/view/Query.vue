<template>
    <h3>查詢</h3>
    <button @click="ReportFile()">匯出PDF檔</button>
    <QueryEmployee></QueryEmployee>
</template>
<script>
import axios from 'axios'
import QueryEmployee from '../components/QueryEmployee.vue';

export default {
    name: "/Query",
    components: {
        "QueryEmployee":QueryEmployee,
        
    },
    methods: {
        ReportFile() {
            const url = "http://localhost:8080/download";

            axios
                .get(url, { responseType: 'blob' })// 設定為 blob 以獲取檔案
                .then(response => {
                    // 創建一個 URL 對象
                     const url = window.URL.createObjectURL(new Blob([response.data]));//方法用於創建一個 URL，該 URL 對應於指定的 Blob 

                    // 創建一個連結元素並觸發下載
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', 'Employee.pdf'); // 設定下載的檔名
                    document.body.appendChild(link)
                    //document.body.appendChild(link);
                    link.click();

                    // 釋放 URL 對象，避免佔用容量\
                    window.URL.revokeObjectURL(url)})
                .catch(error => {console.error("Error downloading the PDF:", error)})
        },
    }
}
</script>

<style></style>