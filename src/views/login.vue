<template>
    <div class="login">
        <div class="login_form">
            <div style="text-align: center;height: 50px;margin-top: 30px">
                <h2>运动打卡系统</h2>
            </div>
            <el-tabs v-model="activeName" @tab-click="handleClick" style="text-align: center">
                <el-tab-pane label="登录" name="first" style="text-align: center">
                    <el-form
                            :model="loginForm"
                            :rules="rules"
                            ref="loginForm"
                    >
                        <el-form-item label="" prop="account" class="elItem">
                            <el-input
                                    type="text"
                                    autocomplete="off"
                                    v-model="loginForm.account"
                                    prefix-icon="el-icon-user-solid"
                                    placeholder="请输入用户名"
                            ></el-input>
                        </el-form-item>
                        <el-form-item label="" prop="password">
                            <el-input
                                    type="password"
                                    autocomplete="off"
                                    v-model="loginForm.password"
                                    prefix-icon="el-icon-lock"
                                    placeholder="请输入密码"
                            ></el-input>
                        </el-form-item>
                        <el-form-item style="text-align:center ">
                            <el-radio-group  v-model="radioVal" @change="getRadioVal()">
                                <el-radio   value="u_1" label="1" >普通用户</el-radio>
                                <el-radio  value="u_2" label="2" >教练</el-radio>
                            </el-radio-group>
                        </el-form-item>

                        <el-form-item class="btns" style="text-align: center">
                            <el-button type="primary" @click="goToLogin">登录</el-button>
                            <el-button @click="resetLoginForm('loginForm')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </el-tab-pane>
                <el-tab-pane label="注册" name="second">
                    <register></register>

                </el-tab-pane>

            </el-tabs>
        </div>

    </div>
</template>

<script>

    import register from "@/views/register";
    import request from "@/utils/request";
    // import register from "/register";
    export default {
        // name: "login",
        // components: {Register}

        data(){

            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('请输入账户'));
                } else {
                    return callback();
                }
            };


            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('请输入密码'));
                } else {
                    return callback();
                }
            };

            return{

                radioVal: "1",

                loginForm:{
                    account:"",
                    password:"",
                },

                activeName: "first",

                rules:{
                    account:[
                        { validator: validatePass,
                            trigger: 'blur' }
                    ],
                    password:[
                        { validator: validatePass2,
                            trigger: 'blur' }
                    ]

                },

                // radioVal: "1",
                // btnstatus:true,

            };
        },

        created() {
            sessionStorage.clear();
        },

        methods:{
            getRadioVal(){
                console.log(this.radioVal);
                //     let that = this
                //     that.btnstatus=(val==='1')?true:false;
            },

            goToLogin(){
                this.$refs["loginForm"].validate((valid) => {
                    if (valid) {
                        request.post("http://localhost:8888/user/login", {
                            username: this.loginForm.account,
                            password: this.loginForm.password,
                        })
                            .then((res) => {
                                console.log(res);


                                if (res.result === 0) {
                                    sessionStorage.setItem("admin", JSON.stringify(res.data));
                                    if (this.radioVal === '1'){
                                      this.$message({message: "登录成功" , type: "success"});
                                      this.$router.push("/Market");
                                    }
                                    else {
                                      this.$message({message: "欢迎教练使用本系统" , type: "success"});
                                      this.$router.push("/CoachPEPlan");
                                    }
                                } else {
                                    this.$message.error("账号密码不正确");
                                    return false;
                                }
                            });
                    } else {
                        this.$message.error("登陆失败");
                        return false;
                    }

                });
            },

            resetLoginForm(loginName){
                this.$refs[loginName].resetFields();
            },
            handleClick(){

            }


        },
        components:{
            register
        }

    }
</script>

<style scoped lang="less">

    .login{
        width: 100%;
        height: 100vh;
        background-image: url('http://www.dnzhuti.com/uploads/allimg/170511/95-1F511162616.jpg');
        overflow: auto;
        position: relative;
        .login_form{
            width: 400px;
            height: 360px;
            position: absolute;
            padding: 20px;
            left: 50%;
            top: 50%;
            margin-left: -220px;
            margin-top: -170px;
            background: #e5e9f2;
            border-radius: 5px;
            box-shadow: #cccccc;
            .btns{
                display: flex;
                justify-content: flex-end;
            }
        }


    }
</style>
<!--<style scoped lang="less">-->
<!--    body{-->
<!--        margin: 0;-->
<!--    }-->
<!--    .login{-->
<!--        width: 400px;-->
<!--        height: 390px;-->
<!--        background: #e5e9f2;-->
<!--        position: absolute;-->
<!--        left: 50%;-->
<!--        top: 50%;-->
<!--        margin-left: -220px;-->
<!--        margin-top: -170px;-->
<!--        border-radius: 5px;-->
<!--        padding-top: 40px;-->
<!--        padding-right: 40px;-->
<!--      -->

<!--    }-->
<!--</style>-->