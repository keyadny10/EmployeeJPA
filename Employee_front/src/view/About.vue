<template>
    <div class="nav">
        <h3>放鬆之旅-高美遊</h3>
        <img src="../assets/logo.jpg" > <br>&nbsp
<div class="nav-text">
    高美地區位居於清水區的最西北之區域，緊鄰大甲溪與台灣海峽，高美古早叫做「高密」，因為這一地區的海灘深度能將撐船的竹竿整支吞沒下去，而在台語發音上，高與竹竿的竿發音同，密則有淹沒的意思，故稱高密。
</div>

    </div>
    

   

</template>

<script>

export default{
    name:'/About',
}

</script>
<style>
.nav {
    text-align: center;  /* 文字水平置中 */
    padding: 2px;      /* 容器內部填充 */
}

.nav-text {
    border: 2px solid #010101;   /* 邊框樣式 */
    padding: 10px;            /* 邊框內部填充 */
    margin-top: 10px;         /* 上方邊距 */
    display: inline-block;     /* 使 div 自適應內容寬度 */
    max-width: 500px;         /* 設置最大寬度，根據需要調整 */
    text-align: left;         /* 內部文字左對齊 */
    margin-right: 150px;          /* 右邊距離增大 */
    
}
.nav-text img {
    max-width: 100%; /* 圖片最大寬度為100% */
    height: auto;    /* 高度自動調整以保持比例 */
}
</style>