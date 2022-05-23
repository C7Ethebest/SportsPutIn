<template>
  <div>
    <el-carousel indicator-position="outside" class="zoumadeng">
      <el-carousel-item v-for="item in imgList" :key="item.id">
        <img :src="item.idView" class="el-carousel__item h3" style="width: 100%">
      </el-carousel-item>
    </el-carousel>

    <el-header style="text-align: right; font-size: 50px">
      <h1 style="text-align: center;margin-top: auto; font-style: italic">欢迎进入运动打卡系统！</h1>
    </el-header>
  </div>


</template>

<script>
export default {
  name: "Market",
  data() {
    return{
      imgList: [
        {id:1,idView:require("@/assets/imgs/run.png")},
        {id:2,idView:require("@/assets/imgs/bike.png")},
        {id:3,idView:require("@/assets/imgs/ywqz.png")},
      ]
    }
  },
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.zoumadeng{
  margin-left: 100px;
  margin-right: 100px;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}


</style>