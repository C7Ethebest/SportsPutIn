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
        <el-table-column
            fixed="right"
            label="操作">
          <template slot-scope="scope">
            <el-popover
                placement="top"
                width="160"
                v-model="visible">
              <p>确认购买吗？</p>
              <div style="text-align: right; margin: 0">
                <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                <el-button type="primary" size="mini" @click="visible = false; BuyPEPlan">确定</el-button>
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
    BuyPEPlan(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8888/MyPEPlan/AddMyPEPlan',this.ruleForm).then(function (resp){
            if(resp.data == 'success'){
              _this.$alert('购买成功！','OK',{
                confirmButtonText:'确定',
                callback: action =>{
                  type: 'info',
                      _this.$router.push('/MyPEPlan');
                }
              })
            }else {
              _this.$message.error('购买失败，请重新输入！');
            }
          })
        } else {
          _this.$message.error('购买失败，请重新输入！');
          return false;
        }
      });
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



<style scoped>


</style>