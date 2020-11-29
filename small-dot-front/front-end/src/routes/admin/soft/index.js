import loadable from "@loadable/component";
export default [
  {
    path: "/admin/soft/addSoft",
    exact: true,
    component: loadable(() => import(`@/pages/admin/soft/addsoft/index.js`))
  },
  {
    path: "/admin/soft/list",
    exact: true,
    component: loadable(() => import(`@/pages/admin/soft/list/index.js`))
  }
];
