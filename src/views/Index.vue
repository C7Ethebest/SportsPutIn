<template>
  <!--  构建整个页面框架  -->
  <el-container style="height: 550px; border: 1px solid #eee;text-align: center;" >
      <el-header style="text-align: right; font-size: 12px">
        <h1 style="text-align: center;margin-top: auto">体育打卡系统</h1>
      </el-header>


    <el-container>
      <!--构建左侧菜单el-aside width="200px-->
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
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
<!--      <el-menu router :default-openeds="['0']">-->
<!--        <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''">-->
<!--          <template slot="title">{{item.name}}</template>-->
<!--          <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"-->
<!--                        :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>-->
<!--        </el-submenu>-->
<!--      </el-menu>-->

    </el-aside>
      <el-main>
        <router-view></router-view>
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

.el-aside {
  color: #333;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
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