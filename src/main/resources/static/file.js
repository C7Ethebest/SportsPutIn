
// $(function (){
//     var data = {tu:''};
//     var vm = new Vue({
//         el: '#app',
//         data: data,
//         methods:{
//             uploadfile:function(e){
//                 //获取文件对象
//                 var file = e.target.filles[0];
//                 //创建表单对象
//                 var formdata = new FormData();
//                 //把文件放入表单中
//                 formdata.append('file', file);
//                 //使用post请求发送文件
//                 axios.post('/file/upload', formdata,
//                     {header:{'Content-Type':'multipart/form-data'}}).then(function (res){
//                     alert(res.data);
//                     vm.tu = "/image/" + file.name;
//                 }).catch(function (err){
//                     alert(err);
//                 })
//             }
//         }
//     })
// })