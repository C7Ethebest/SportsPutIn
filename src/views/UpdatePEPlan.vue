<template>

  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="110px" class="demo-ruleForm">
    <el-form-item label="训练计划名称" prop="pename">
      <el-input v-model="ruleForm.pename" ></el-input>
    </el-form-item>

    <el-form-item label="计划时长" prop="times">
      <el-input v-model="ruleForm.times"></el-input>
    </el-form-item>

    <el-form-item label="教练" prop="coach">
      <el-input v-model="ruleForm.coach"></el-input>
    </el-form-item>

    <el-form-item label="价格" prop="price">
      <el-input v-model="ruleForm.price"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm ('ruleForm')">确定</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>



</template>

<script>
export default {
  name: "UpdatePEPlan",
  methods:{
    editPEPlan(row){
      this.$router.push({
        path:'/updatepeplan',
        query:{
          id:row.peid
        }
      })
    },
  },

  data() {
    return {
      ruleForm: {
        pename: '',
        times: '',
        coach: '',
        price: '',
      },
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
    };
  },
  created() {
    const _this = this
    axios.get('http://localhost:8888/updateByPeid/'+this.$route.query.peid).then(function(){
      _this.ruleForm = resp.data
    })
  },
}
</script>

<style scoped>

</style>