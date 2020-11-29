import axios from "axios";
import queryString from "query-string";
import FileSaver from "file-saver";
import {
    formatJSON,
    getHeaders,
    requestInterceptorHandler,
    responseInterceptorHandler,
    responseErrorHadler,
    requestErrorHandler
} from "./helper.js";
var baseUrl = "/api";

if (process.env.NODE_ENV === "production") {
    baseUrl = "/api";
}
axios.defaults.timeout = 1200000;
axios.interceptors.request.use(requestInterceptorHandler, requestErrorHandler);
axios.interceptors.response.use(
    responseInterceptorHandler,
    responseErrorHadler
);
export const fetch = (method, type, url, data) => {
    let obj = {
        url: baseUrl + url,
        method: method || "post",
        headers: getHeaders(type)
    };
    if (obj.method === "get") {
        obj.params = data;
    } else {
        if (type === "json") {
            obj.data = formatJSON(data);
        } else if (type === "upload") {
            obj.data = data;
        } else {
            obj.data = queryString.stringify(data);
        }
    }
    return axios.request(obj);
};
/**
 * @param {*} url
 * @param {*} data
 */
export const downloadMe = (url, data, callback, filename) => {
    let obj = {
        url: baseUrl + url,
        method: "post",
        data: queryString.stringify(data),
        headers: getHeaders("download"),
        responseType: "blob"
    };
    axios.request(obj).then(
        res => {
            let fileName = filename || decodeURI(res.headers["filename"]);
            try {
                FileSaver.saveAs(
                    new Blob([res.data], {
                        type: "application/octet-stream"
                    }),
                    fileName
                );
            } catch (e) {
                if (typeof console != "undefined") console.log(e);
            }
            if (callback) {
                callback();
            }
        },
        error => {
            console.log(error);
            callback();
        }
    );
};
