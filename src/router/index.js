import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Sport from "../views/Sport";
import BallSport from "../views/BallSport";
import MyPEPlan from "@/views/MyPEPlan";
import MyAccount from "@/views/MyAccount";
import Index from  "@/views/Index";
import AddPEPlan from "@/views/AddPEPlan";
import PunchIn from "@/views/PunchIn";
import Market from "@/views/Market";


Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: "商城",
    component: Index,
    // redirect: "/Sport",
    children:[
      {
        path: "/Sport",
        name: "运动",
        component: Sport
      },
      {
        path: "/BallSport",
        name: "球类运动",
        component: BallSport
      },
      {
        path: "/MyPEPlan",
        name: "我的锻炼计划",
        component: MyPEPlan,
      },
      {
        path: "/MyAccount",
        name: "我的账号",
        component: MyAccount,
      },
      {
        path: "/AddPEPlan",
        name:"添加锻炼计划",
        component: AddPEPlan
      },
      {
        path: "/PunchIn",
        name: "训练计划打卡",
        component: PunchIn
      },
      {
        path: "/Market",
        name: "商城",
        component: Market
      }
      ],
  },




]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
