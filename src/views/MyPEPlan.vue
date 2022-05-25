<template>
  <div>

    <el-container>

      <el-table id="table"
                :data="MyPEPlan"
                border
                style="width: 100%">
        <el-table-column
            fixed
            prop="mypeid"
            label="编号"
            width="60">
        </el-table-column>
        <el-table-column
            prop="mypename"
            label="锻炼名称"
            width="150">
        </el-table-column>
        <el-table-column
            prop="mytimes"
            label="计划时长"
            width="120">
        </el-table-column>
        <el-table-column
            prop="mycoach"
            label="教练"
            width="120">
        </el-table-column>
        <el-table-column
            prop="price"
            label="价格"
            width="120">
        </el-table-column>
        <el-table-column
            prop="price"
            label="我的评价"
            width="200">
        </el-table-column>
        <el-table-column
            fixed="right"
            label="操作">
          <template slot-scope="scope">
            <el-button @click="JumpPunchIn" type="primary"  size="small">打卡</el-button>
            <el-button type="primary" size="small" >评价</el-button>
            <template>
              <el-popconfirm
                  title="确认退出计划吗？费用概不退还"
              >
                <el-button slot="reference" type="danger" plain size="small" style="margin-left: 15px">退出计划</el-button>
              </el-popconfirm>
            </template>

          </template>
        </el-table-column>
      </el-table>

<!--        &lt;!&ndash;失败的卡片布局&ndash;&gt;-->
<!--          <el-card  shadow="hover" :body-style="{ padding: '0px'}" class="el-card">-->
<!--            <img v-for="item in imgList" :key="item.id"-->
<!--                 :src="item.idView" class="image">-->
<!--            <div style="padding: 14px;">-->
<!--              <td class="sprottext">{{}}}</td>-->
<!--              <div class="bottom clearfix">-->
<!--                <el-button type="text" class="button" onclick="">查看</el-button>-->
<!--              </div>-->
<!--            </div>-->
<!--          </el-card>-->

<!--      <el-carousel indicator-position="outside" class="zoumadeng">-->
<!--        <el-carousel-item v-for="item in imgList" :key="item.id">-->
<!--          <img :src="item.idView" class="el-carousel__item h3" style="width: 100%">-->
<!--        </el-carousel-item>-->
<!--      </el-carousel>-->

    </el-container>

    <!--  分页  -->
    <el-pagination
        background
        layout="prev, pager, next"
        :page-size="4"
        :total="30"
        style="margin-top: 10px;"
        @current-chang="page">
    </el-pagination>
  </div>
</template>

<script >
export default {
  name: "MyPEPlan",

  methods: {
    // 跳转到传递参数页
    JumpPunchIn(){
      this.$router.push({
        path:'/PunchIn'
      })
    }
  },

  data() {
    return{
      MyPEPlan: [
        {
          mypeid: '1',
          mypename:'跑步',
          mytimes:'三周',
          mycoach:'李老师',
        },
      ],
    }
  },

  created() {
    const _this = this
    axios.get('http://localhost:8888/MyPEPlan/findmyAll').then(function (resp){
      _this.MyPEPlan = resp.data
    })
  },

}

</script>



<style scoped>


</style>