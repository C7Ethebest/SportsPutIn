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

        <div>
        <el-table-column
            fixed="right"
            label="操作">

<!--          &lt;!&ndash;根本不需要的编辑&ndash;&gt;-->
            <template slot-scope="scope">
<!--              <el-button @click="JumpUpdatePEPlan(scope.row)" type="primary" plain-->
<!--                         size="small" >编辑</el-button>-->


                <div style="display:inline-block">
                  <el-popover
                      placement="top"
                      width="160"
                      v-model="visible">
                    <p>确认删除吗？</p>
                    <div style="text-align: right; margin: 0">
                      <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                      <el-button type="primary" size="mini" style="margin-left: 20px" @click="visible = false; deletePEPlan(scope.row)">确定</el-button>
                    </div>
                    <el-button slot="reference" type="danger" size="small" >删除</el-button>
                  </el-popover>
                </div>
<!--              </div>-->



            </template>

          </el-table-column>
        </div>

      </el-table>



    </el-container>

    <el-container>
      <el-pagination
          background
          layout="prev, pager, next"
          :page-size="4"
          :total="30"
          style="margin-top: 10px;margin-left: 200px"
          @current-chang="page">
      </el-pagination>

      <el-button @click="JumpAddPEPlan" type="primary" plain class="Addbtn">发布新计划</el-button>

    </el-container>

    <el-container>

    </el-container>


  </div>
</template>

<script >
export default {
  name: "CoachPEPlan",

  methods: {

    deletePEPlan(row){
      const _this = this
      axios.delete('http://localhost:8888/Sport/deletePEPlan/'+row.peid).then(function (){
            _this.$alert('删除计划成功！','消息',{
              confirmButtonText:'确定',
              callback: action => {
                type: 'info',
                    window.location.reload()
              }
      })
    })
    },
    //弃用的更新操作
    // JumpUpdatePEPlan(){
    //   this.$router.push({
    //     path: 'UpdatePEPlan'
    //   })
    // },

    JumpAddPEPlan(){
      this.$router.push({
        path:'/AddPEPlan'
      })
    }
  },
  data() {
    return{

      rules: {
        pename: [
          { required: true, message: '请输入训练计划名称', trigger: 'change' },
          { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'change' }
        ],
        times: [
          { required: true, message: '请输入训练计划时长', trigger: 'change' }
        ],
        coach: [
          { required: true, message: '请输入教练名称', trigger: 'change' }
        ],
        price: [
          { required: true, message: '请输入训练计划价格', trigger: 'change' }
        ],
      },

      dialogFormVisible: false,
      ruleForm: {
        pename: '11',
        times: '',
        coach: '',
        price: '',
      },
      formLabelWidth: '120px',

      PEPlan: [
        {
          peid: '1',
          pename:'跑步',
          times:'三周',
          coach:'李老师',
          price:'30.00'
        },
      ],
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

.Addbtn{
  margin-top: 7px;
  margin-left: 20px;
  width: 200px;
  height: 35px;
  text-align: center;

}

</style>