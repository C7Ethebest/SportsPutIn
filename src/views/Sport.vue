<template>
  <div>

    <el-container>

      <el-table id="table"
          :data="PEPlan"
          border
          style="width: 100%">
        <el-table-column
            prop="peid"
            label="编号"
            width="60">
        </el-table-column>
        <el-table-column
            prop="pename"
            label="锻炼名称"
            width="150">
        </el-table-column>
        <el-table-column
            prop="times"
            label="计划时长"
            width="120">
        </el-table-column>
        <el-table-column
            prop="coach"
            label="教练"
            width="120">
        </el-table-column>
        <el-table-column
            prop="price"
            label="价格"
            width="120">
        </el-table-column>
        <el-table-column
            label="操作">
          <template slot-scope="scope">
            <el-popover
                placement="top"
                width="160"
                v-model="visible">
              <p>确认购买吗？</p>
              <div style="text-align: right; margin: 0">
                <el-button size="mini" type="text" >取消</el-button>
                <el-button type="primary" size="mini" @click="BuyPEPlan(scope.row)">确定</el-button>
              </div>
              <el-button slot="reference">购买</el-button>
            </el-popover>
          </template>
        </el-table-column>
      </el-table>

      <!--  &lt;!&ndash;失败的卡片布局&ndash;&gt;-->
      <!--    <el-card  shadow="hover" :body-style="{ padding: '0px'}" class="el-card">-->
      <!--      <img src="../assets/3.png" class="image">-->
      <!--      <div style="padding: 14px;">-->
      <!--        <td class="sprottext">跑步</td>-->
      <!--        <div class="bottom clearfix">-->
      <!--          <el-button type="text" class="button" onclick="">查看</el-button>-->
      <!--        </div>-->
      <!--      </div>-->
      <!--    </el-card>-->

    </el-container>

      <el-pagination
          background
          layout="prev, pager, next"
          :page-size="4"
          :total="10"
          style="margin-top: 10px;"
          @current-chang="page">
      </el-pagination>
  </div>
</template>

<script >
export default {
  name: "Sport",

  data() {
    return{
      PEPlan: [
          {
            peid: '1',
            pename:'跑步',
            times:'三周',
            coach:'李老师',
            price:'30.00'
          },
      ]
    }
  },
  methods:{
    page(m){
      this.p.pageNum = n;
      this.getAll();

    },

    BuyPEPlan(row){
      const _this = this
      axios.post('http://localhost:8888/MyPEPlan/BuyPEPlan/'+row.peid).then(function (){
        _this.$alert('购买成功！','消息',{
          confirmButtonText:'确定',
          callback: action => {
            type: 'info',
                window.location.reload()
          }
        })
      })
    },

  },

  created() {
    const _this = this
    axios.get('http://localhost:8888/Sport/findAll').then(function (resp){
      _this.PEPlan = resp.data
    })
  },

}

</script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<style scoped>


</style>