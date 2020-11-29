import main from "./main";
import admin from "./admin";
export default {
  indexPage: {
    path: "/"
  },
  adminPage: {
    path: "/admin",
    routes: admin
  },
  mainIndexPage:{
    path:'/main/index'
  },
  mainPage: {
    path: "/main",
    routes: main
  }
};
