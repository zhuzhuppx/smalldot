
import loadable from "@loadable/component";
export default [
  {
    path: "/main/index",
    exact: true,
    component: loadable(() => import(`@/pages/main/index/index.js`))
  }
];
