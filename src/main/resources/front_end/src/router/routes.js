import Login from '@/layout/dashboard/Login.vue'
import Register from '@/layout/dashboard/Register.vue'
import DashboardLayout from "@/layout/dashboard/DashboardLayout.vue";
import NotFound from "@/pages/NotFoundPage.vue";
import Dashboard from "@/pages/Dashboard.vue";
import UserProfile from "@/pages/UserProfile.vue";
import Notifications from "@/pages/Notifications.vue";
import Icons from "@/pages/Icons.vue";
import Maps from "@/pages/Maps.vue";
import Typography from "@/pages/Typography.vue";
import TableList from "@/pages/TableList.vue";

const routes = [

  {
    path: "/",
    name: "Login",
    component: Login,
  },

  {
    path: '/Register',
    name: 'Register',
    component: Register

  },

  {
    path: "/",
    component: DashboardLayout,
    redirect: "/dashboard",
    children: [

      {
        path: "dashboard",
        name: "dashboard",
        component: Dashboard,
      },
      {
        path: "stats",
        name: "stats",
        component: UserProfile,
      },
      {
        path: "notifications",
        name: "notifications",
        component: Notifications,
      },
      {
        path: "icons",
        name: "icons",
        component: Icons,
      },
      {
        path: "maps",
        name: "maps",
        component: Maps,
      },
      {
        path: "typography",
        name: "typography",
        component: Typography,
      },
      {
        path: "table-list",
        name: "table-list",
        component: TableList,
      },
    ],
  },
  { path: "*", component: NotFound },
];



export default routes;
