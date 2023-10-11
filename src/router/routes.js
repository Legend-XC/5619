import Login from '@/layout/dashboard/Login.vue'
import Register from '@/layout/dashboard/Register.vue'
import DashboardLayout from "@/layout/dashboard/DashboardLayout.vue";
import NotFound from "@/pages/NotFoundPage.vue";
import Dashboard from "@/pages/Dashboard.vue";
import UserProfile from "@/pages/UserProfile.vue";
import Notifications from "@/pages/Notifications.vue";
import Icons from "@/pages/Icons.vue";
import Bills from "@/pages/Bills";
import Diversification from "@/pages/Diversification.vue";
import Addition from "@/pages/Addition.vue";
import TransactionRecord from "@/pages/TransactionRecord.vue";
import BillAddition from "@/pages/BillAddition.vue";

const routes = [

  {
    path: "/",
    name: "Login",
    component: Login,
  },

  {
    path: "/Register",
    name: "Register",
    component: Register,
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
        path: "Bills",
        name: "Bills",
        component: Bills,
      },
      {
        path: "diversification",
        name: "diversification",
        component: Diversification,
      },
      {
        path: "addition",
        name: "addition",
        component: Addition,
      },
      {
        path: "billAddition",
        name: "billAddition",
        component: BillAddition,
      },
      {
        path: "transactionRecord",
        name: "transactionRecord",
        component: TransactionRecord,
      },
    ],

  },

  { path: "*", component: NotFound },
];



export default routes;
