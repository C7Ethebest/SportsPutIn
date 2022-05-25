<template>


  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="110px" class="demo-ruleForm">
    <el-form-item label="训练计划名称" prop="pename">
      <el-input v-model="ruleForm.pename"></el-input>
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
      <el-button type="primary" @click="submitForm ('ruleForm')">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>

</template>


<script>
export default {
  name: "AddPEPlan",

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
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // console.log(_this.ruleForm);
          // alert("添加成功！");
          axios.post('http://localhost:8888/Sport/AddPEPlan',this.ruleForm).then(function (resp){
            // console.log(resp)
            if(resp.data == 'success'){
              _this.$alert('添加计划成功！','OK',{
                confirmButtonText:'确定',
                    callback: action =>{
                  type: 'info',
                  _this.$router.push('/CoachPEPlan');
                }
              })
            }else {
              _this.$message.error('添加计划失败，请重新输入！');
            }
          })
        } else {
          _this.$message.error('添加计划失败，请重新输入！');
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },


  }
}
</script>