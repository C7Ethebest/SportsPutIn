<template>
  <!--  构建整个页面框架  -->
  <el-container style="border: 1px solid #eee;text-align: center" >
    <el-header class="el-header">
        <h1 class="title">体育打卡系统</h1>
        <el-button class="el-icon-s-tools" type="text" @click="exit" >退出登陆</el-button>
    </el-header>


    <el-container>
      <!--构建左侧菜单el-aside-->
      <el-aside  style="width: 15%; background-color: rgb(238, 241, 246)" class="el-aside">
        <!--左侧菜单内容-->
        <el-menu :default-openeds="['1']" :default-active="'1'">
          <el-menu-item index="1" @click="JumpCoachPEPlan"><i class="el-icon-menu"></i><span slot="title">锻炼计划管理</span></el-menu-item>
          <el-menu-item index="2" @click="JumpCoachAccount"><i class="el-icon-setting"></i><span slot="title">账号管理</span></el-menu-item>
        </el-menu>
      </el-aside>



      <el-main >
        <body>
        <router-view></router-view>
        </body>
      </el-main>

    </el-container>
  </el-container>


</template>

<style scoped>
.el-header {
  height: 60px;
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.title{
  text-align: center;
  margin-top: auto;
  margin-left: 50px;
  display:inline-block;
}

.el-icon-s-tools{
  display:inline-block;
  float: right;
  margin-top: 10px;
  margin-right: 10px;
}


@media screen and (max-width: 991px) {


}


</style>

<script>
export default {

  data() {

  },
  methods:{
    exit(){
      this.$confirm('确定要退出吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$router.push({
          name:'login',
        })
      }).catch(() => {
      });
    },
    JumpCoachPEPlan(){
      this.$router.push({
        name:'教练的计划',
      })
    },

    JumpCoachAccount(){
      this.$router.push({
        name:'教练账号',
      })
    },

    JumpLogin(){

    },
  }
}
</script>