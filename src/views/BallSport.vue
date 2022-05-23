<template>
  <el-container>
    <el-col v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0">
      <el-card shadow="hover" :body-style="{ padding: '0px'}" class="el-card">
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
        <div style="padding: 14px;">
          <span>好吃的汉堡</span>
          <div class="bottom clearfix">
            <el-button type="text" class="button" onclick="">查看</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-container>
</template>

<script>
export default {
  name: "BallSport"
}
</script>

<style scoped>
.el-card{
  margin-left: 10px;
  margin-top: 10px;
  /*background-color: #E6E6E6;*/
  display: inline-block;
}
.image {
  width: 100%;
  display: block;
}

.button {
  padding: 0;
  float: right;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}
</style>