const fs = require("fs");
const path = require("path");
let dirArray = fs.readdirSync(path.resolve(__dirname, "../../mock"));

module.exports = router => {
  for (let d of dirArray) {
    const data = require(`../../mock/${d}`);
    let api = d.split(".")[0];
    console.log(`mock data is ready ${api}`);
    router
      .get(`/${api}`, async ctx => {
        ctx.send({
          status: "success",
          data: data
        });
      })
      .post(`/${api}`, async ctx => {
        ctx.send({
          status: "success",
          data: data
        });
      });
  }
};
