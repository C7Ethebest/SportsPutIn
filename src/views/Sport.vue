<template>
  <div>

    <el-container>

      <el-table id="table"
          :data="PEPlan"
          border
          style="width: 100%">
        <el-table-column
            fixed
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
            label="时间"
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
            fixed="right"
            label="操作">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="primary" plain
                       size="small" style="margin-left: 15px">购买</el-button>
<!--            <el-button type="primary" plain size="small" style="margin-left: 30px">编辑</el-button>-->
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
          :total="30"
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

  created() {
    const _this = this
    axios.get('http://localhost:8888/Sport/findAll').then(function (resp){
      _this.PEPlan = resp.data
    })
  },

}

</script>



<style scoped>


</style>