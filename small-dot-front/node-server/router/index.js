const Router = require("koa-router");
const fs = require("fs");
const path = require("path");
let dirArray = fs.readdirSync(path.resolve(__dirname, "modules"));

const router = new Router();
const routerHome = new Router();
routerHome.get("/", async ctx => {
  ctx.body = "欢迎欢迎！";
});
module.exports = app => {
  for (let d of dirArray) {
    let apiRouter = new Router();
    const apiRouterFun = require(`./modules/${d}`);
    apiRouterFun(apiRouter);
    let api = d.split(".")[0];
    console.log(`/${api} is ready `);
    router.use(`/${api}`, apiRouter.routes(), apiRouter.allowedMethods());
  }

  router.use("/", routerHome.routes(), routerHome.allowedMethods());
  app.use(router.routes()).use(router.allowedMethods());
};
