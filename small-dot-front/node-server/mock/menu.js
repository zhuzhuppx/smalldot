module.exports = [
  { name: `首页`, path: `/main`, icon: "dashboard", hasChildren: false },
  { name: `活动日历`, path: `/main`, icon: "dashboard", hasChildren: false },
  {
    name: `BD资源`,
    icon: "dashboard",
    hasChildren: true,
    children: [
      { name: `院校查询`, path: `/main/projectFuncs?projectId=1`, icon: "dashboard", hasChildren: false },      
      { name: `场地查询`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `面试官查询`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `生源查询`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `专业排名`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `宣传资源`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `仓库管理员`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `客户行业`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `案例资料`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false },      
      { name: `产品资料`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false }
    ]
  },
  {
    name: `项目`,
    icon: "dashboard",
    hasChildren: true,
    children: [
      { name: `中国电信2020校园招聘`, path: `/main/projectFuncs?projectId=1`, icon: "dashboard", hasChildren: false },      
      { name: `中国联通2020校园招聘`, path: `/main/projectFuncs?projectId=2`, icon: "dashboard", hasChildren: false }
    ]
  }
];
