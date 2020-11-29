const {
  override,
  fixBabelImports,
  addLessLoader,
  addWebpackAlias,
  addWebpackPlugin,
  setWebpackPublicPath
} = require("customize-cra");
const ProgressBarPlugin = require("progress-bar-webpack-plugin");
const chalk = require("chalk");
const path = require("path");
const { appBuild, publicPath } = require("./config/index");

function resolve(dir) {
  return path.join(__dirname, ".", dir);
}

module.exports = {
  webpack: override(
    fixBabelImports("import", {
      libraryName: "antd",
      libraryDirectory: "es",
      style: "css" // change importing css to less
    }),
    addLessLoader({
      javascriptEnabled: true,
      modifyVars: { "@primary-color": "#1DA57A" }
    }),
    addWebpackAlias({
      "@": resolve("src")
    }),
    addWebpackPlugin(
      new ProgressBarPlugin({
        complete: "█",
        format: `${chalk.green("Building")} [ ${chalk.green(
          ":bar"
        )} ] ':msg:' ${chalk.bold("(:percent)")}`,
        clear: true
      })
    ),
    setWebpackPublicPath(publicPath)
  ),
  paths: paths => {
   // paths.appBuild = appBuild;
    return paths;
  }
};
