import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import VueRouter from "vue-router";
import $ from 'jquery'
import '/js/file.js'


// //引入elementUI的css
// import 'element-plus/dist/index.css'
// //引入中文
// import zhCn from 'element-plus/es/locale/lang/zh-cn'


Vue.config.productionTip = false
Vue.use(VueRouter)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })
//
// export default router


// createApp(App).use(store).use(router).use(ElementPlus, {
//   router,
//   store,
//   locale: zhCn ,size: "small"
// }).mount('#app')


