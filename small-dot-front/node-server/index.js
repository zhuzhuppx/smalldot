const Koa = require("koa");
const app = new Koa();
const router = require("./router");
const path = require('path')
const middleware = require("./middleware");
middleware(app);
router(app);
const static_ = require('koa-static')

app.use(static_(
    path.join(__dirname, './static')
))
const PORT = 9870;

app.listen(PORT, () => {
  console.log(`server is running at http://localhost:${PORT}`);
});
