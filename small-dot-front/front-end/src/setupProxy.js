const proxy = require("http-proxy-middleware");
// proxy 中间件的选择项

let {proxyUrl} = require('../config/index');
var options = {
	target: proxyUrl,
	changeOrigin: true,
	pathRewrite: {
		"^/api": "/"
	}
};
// 创建代理
var myProxy = proxy(options);
module.exports = function(app) {
	app.use("/api",myProxy);
};
