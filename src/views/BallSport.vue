<!--弃用仅作展示-->
<template>
  <el-container>
      <el-card shadow="hover" :body-style="{ padding: '0px'}" class="el-card">
        <img src="@/assets/imgs/basketball.png" class="image">
        <div style="padding: 14px;">
          <span>篮球</span>
          <div class="bottom clearfix">
            <el-button type="text" class="button" onclick="">查看</el-button>
          </div>
        </div>
      </el-card>

    <div style="margin-left: 50px">
      <el-card shadow="hover" :body-style="{ padding: '0px'} " class="el-card">
        <img src="@/assets/imgs/baseball.png" class="image">
        <div style="padding: 14px;">
          <span>棒球</span>
          <div class="bottom clearfix">
            <el-button type="text" class="button" onclick="">查看</el-button>
          </div>
        </div>
      </el-card>
    </div>

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