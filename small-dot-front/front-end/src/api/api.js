import { fetch } from "./service/services";

export const upload = data => fetch("post", "upload", "/soft/upload", data);

/**
 * 管理端
 * @param {*} data 
 */
export const listSofts = data => fetch("post", "", "/softadmin/list", data);
export const saveSoft= data => fetch("post", "json", "/softadmin/save", data);
export const deleteSoft  = data=>fetch('post','','/softadmin/delete',data)


/**
 * C端
 */

export const querySofts = data => fetch("post", "", "/soft/list", data);
