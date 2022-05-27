
<template  id="app">
  <div>
    <el-upload

        class="upload-demo"
        drag
        action="http://localhost:8888/file/upload"
        input type="file" @change="upload"
        multiple>
      <i class="el-icon-upload" ></i>

      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">请上传.jpg/.png/.mp4格式的文件</div>
    </el-upload>

    <!--回显不了。。。-->
<!--    <img v-bind:src="tu" alt="回显">-->
  </div>

</template>



<script>
Vue.config.productionTip= false
import Vue from 'vue/dist/vue.esm.js'

export default {
  methods:{
  },


  name: "PunchIn"
}

</script>






<style >
.image-preview{
  max-width: 100%;
  max-height: 100%;
}
.upload-demo{
  position:absolute;
  left:520px;
  top:130px;
}
</style>