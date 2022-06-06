<template>
  <!--  构建整个页面框架  -->
  <el-container style="border: 1px solid #eee;text-align: center" >
      <el-header class="el-header">
        <h1 class="title">体育打卡系统</h1>
        <el-button class="el-icon-s-tools" type="text" @click="exit" style="">退出登陆</el-button>
      </el-header>

    <el-container>
      <!--构建左侧菜单el-aside-->
    <el-aside  style="width: 15%; background-color: rgb(238, 241, 246)" class="el-aside">
        <!--左侧菜单内容-->
              <el-menu :default-openeds="['1']" :default-active="'1-1'">
                <el-submenu index="1">
                  <template slot="title"><i class="el-icon-goods"></i>商城</template>
                  <el-menu-item index="1-1" @click="JumpSport"><i class="el-icon-bicycle"></i>普通运动锻炼计划</el-menu-item>
                    <el-menu-item index="1-2" @click="JumpBallSport"><i class="el-icon-basketball"></i>球类运动锻炼计划</el-menu-item>
                </el-submenu>
                <el-menu-item index="2" @click="JumpMyPEPlan"><i class="el-icon-menu"></i><span slot="title">我的锻炼计划</span></el-menu-item>
                <el-menu-item index="3" @click="JumpMyAccount"><i class="el-icon-setting"></i><span slot="title">我的账号</span></el-menu-item>
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

/*.el-aside {*/
/*  width: 15%;*/
/*  */

/*}*/

@media screen and (max-width: 991px) {


}


</style>

<script>
export default {
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(20).fill(item)
    }

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

    JumpSport(){
      this.$router.push({
        name:'运动',
      })
    },
    JumpBallSport(){
      this.$router.push({
        name:'球类运动',
      })
    },
    JumpMyPEPlan(){
      this.$router.push({
        name:'我的锻炼计划',
      })
    },
    JumpMyAccount(){
      this.$router.push({
        name:'我的账号',
      })
    },
  }
}
</script>