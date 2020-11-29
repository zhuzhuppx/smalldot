import { tipError, loadingShow, loadingHide } from "./tipTool";
const backGates = ["/login/"];
const toLogin = () => {
  // window.location.href = "/"
};
const getToken = () => {
  return localStorage.getItem("token") || "123";
};
export const formatJSON = data => {
  let cache = [];
  return JSON.stringify(data, function(key, value) {
    if (typeof value === "object" && value !== null) {
      if (cache.indexOf(value) !== -1) {
        return;
      }
      cache.push(value);
    }
    return value;
  });
};
export const getHeaders = type => {
  switch (type) {
    case "json":
      return {
        "Content-Type": "application/json",
        token: getToken()
      };
    case "upload":
      return {
        "Content-Type": "multiple/form-data",
        token: getToken()
      };
    case "download":
      return {
        "Content-Type": "application/x-www-form-urlencoded",
        token: getToken()
      };
    case "text":
      return {
        token: getToken()
      };
    default:
      return {
        "Content-Type": "application/x-www-form-urlencoded",
        token: getToken()
      };
  }
};
export const requestInterceptorHandler = config => {
  let { url } = config;
  /**判断是否拦击 */
  if (!(backGates && backGates.some(i => url.indexOf(i) > -1))) {
    let token = getToken("token");
    if (!token) {
      toLogin();
      return tipError("未登录");
    }
  }
  loadingShow();
  return config;
};
export const requestErrorHandler = error => {
  loadingHide();
  return Promise.reject(error);
};
export const responseInterceptorHandler = response => {
  loadingHide();
  let data = response.data;
  let errorCode = data.errorCode;
  //未登录
  if (!!errorCode && errorCode === "3000") {
    toLogin();
    return tipError("未登录!");
  }
  let apiErrorMessage = data.apiErrorMessage;
  if (data.code && data.code === 1001) {
    //后台默认的错误编码
    loadingHide(); //loading移除
    tipError(apiErrorMessage || "系统错误！请稍后重试！");
  }
  return response;
};
export const responseErrorHadler = err => {
  loadingHide();
  if (err && err.response) {
    if (err.response.status === 401) {
      let apiErrorMessage = err.response.data.apiErrorMessage;
      toLogin();
      return tipError(apiErrorMessage || "系统错误！请稍后重试！");
    } else {
      return tipError(err.message);
    }
  }
  return Promise.reject(err);
};
