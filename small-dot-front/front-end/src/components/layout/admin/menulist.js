module.exports = [
    // { name: `首页`, path: `/main`, icon: "dashboard", hasChildren: false },
    // { name: `活动日历`, path: `/main`, icon: "dashboard", hasChildren: false },
    {
      name: `软件信息管理`,
      icon: "dashboard",
      hasChildren: true,
      children: [
        { name: `软件查询`, path: `/admin/soft/list`, icon: "dashboard", hasChildren: false },
      
      ]
    }
  ];