import Vue from 'vue'
import VueRouter from 'vue-router'
import Sport from "../views/Sport";
import BallSport from "../views/BallSport";
import MyPEPlan from "@/views/MyPEPlan";
import MyAccount from "@/views/MyAccount";
import Index from  "@/views/Index";
import AddPEPlan from "@/views/AddPEPlan";
import PunchIn from "@/views/PunchIn";
import Market from "@/views/Market";
import CoachPEPlan from "@/views/CoachPEPlan";
import UpdatePEPlan from "@/views/UpdatePEPlan";
import CoachAccount from "@/views/CoachAccount";



Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component:() => import('../views/login.vue')
  },

  {
    path: "/",
    name: "主界面",
    component: Index,
    redirect: "/Market",
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
      },
      {
        path: "/UpdatePEPlan",
        name: "编辑计划",
        component: UpdatePEPlan
      }
      ],
  },
  {
    path: '/CoachIndex',
    name: '教练主界面',
    component: ()=>import('../views/CoachIndex.vue'),
    children:[
      {
        path: "/CoachPEPlan",
        name: "教练的计划",
        component: CoachPEPlan
      },
      {
        path: "/CoachAccount",
        name: "教练账号",
        component: CoachAccount,
      },
    ]
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
