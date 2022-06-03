<template>
  <div>

    <el-container>

      <el-table id="table"
                :data="MyPEPlan"
                border>
        <el-table-column
            prop="mypeid"
            label="编号"
            width="50px">
        </el-table-column>
        <el-table-column
            prop="mypename"
            label="锻炼名称"
            width="150px">
        </el-table-column>
        <el-table-column
            prop="mytimes"
            label="计划时长"
            width="120px">
        </el-table-column>
        <el-table-column
            prop="mycoach"
            label="教练"
            width="120px">
        </el-table-column>
        <el-table-column
            prop="price"
            label="价格"
            width="110px">
        </el-table-column>

        <el-table-column
            label="操作" style="width: 100px;">
          <template slot-scope="scope" >
            <div class="el-row--flex">
              <el-button @click="JumpPunchIn" type="primary"  size="small">打卡</el-button>
              <el-button type="primary" size="small" @click="open" style="margin-left: 15px">评价</el-button>

              <el-popover
                  placement="top"
                  width="160"
                  v-model="visible">
                <p>确认退出计划吗？费用概不退还？</p>
                <div style="text-align: right">
                  <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                  <el-button type="primary" size="mini" @click="visible = false; deleteMyPEPlan(scope.row)">确定</el-button>
                </div>
                <el-button slot="reference" type="danger" plain size="small" style="margin-left: 15px">退出计划</el-button>
              </el-popover>
            </div>


          </template>
        </el-table-column>
      </el-table>

    </el-container>
    <!--  分页  -->
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
  name: "MyPEPlan",

  methods: {

    deleteMyPEPlan(row){
      const _this = this
      axios.delete('http://localhost:8888/MyPEPlan/deleteMyPEPlan/'+row.mypeid).then(function (){
        _this.$alert('删除计划成功！','消息',{
          confirmButtonText:'确定',
          callback: action => {
            type: 'info',
                window.location.reload()
          }
        })
      })
    },

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
          price:'20',
          comment:''
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