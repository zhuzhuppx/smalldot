import React from "react";
import { Link } from "react-router-dom";
import "./index.less";
import { upload } from "@/api/api";
import FomAdmin from "./form";
import ExcelUtil from "@/util/excelUtil";
import { Button, Card, Divider } from "antd";
import { v4 as uuidv4 } from "uuid";
class AdminPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [{ category: "JAVA" }]
        };
    }
    parseFile = e => {
        ExcelUtil.processJsonArray(e.target.files[0], data => {
            if (data) {
                data = data.Sheet1;
                data.map(item => {
                    // 软件名称	软件描述	官网	下载地址	图片	分类

                    let softName = item["软件名称"];
                    let softDesc = item["软件描述"];
                    let website = item["官网"];
                    let url = item["下载地址"];
                    let imgUrl = item["图标"];
                    let category = item["分类"];
                    let list = [...this.state.list];
                    list.push({
                        softName,
                        softDesc,
                        website,
                        url,
                        category,
                        imgs: [{ id: uuidv4(), imgUrl: imgUrl }]
                    });
                    this.setState({ list });
                });
            }
            this.refs.importFileRef.value = null;
        });
    };
    addSoft = () => {
        const list = [...this.state.list];
        list.push({
            softName: "",
            softDesc: "",
            website: "",
            url: "",
            category: "JAVA",
            imgs: [{ id: uuidv4(), imgUrl: "" }]
        });
        this.setState({ list });
    };
    downloadTpl = () => {
        window.open("tpl.xlsx", "_blank");
    };
    render() {
        const { list } = this.state;
        return (
            <div className="admin-page">
                <div
                    style={{
                        textAlign: "right",
                        paddingTop: 16,
                        paddingRight: 8
                    }}
                >
                    <input
                        ref="importFileRef"
                        type="file"
                        style={{ display: "none" }}
                        onChange={this.parseFile}
                    ></input>
                    <Button onClick={this.downloadTpl}>下载模板</Button>
                    <span style={{ marginRight: 16 }}></span>
                    <Button
                        onClick={() => {
                            this.refs.importFileRef.click();
                        }}
                    >
                        导入
                    </Button>
                    <span style={{ marginRight: 16 }}></span>
                    <Button onClick={this.addSoft}>添加</Button>
                </div>
                <Divider />

                <ul className="form-list">
                    {list.map(item => {
                        return (
                            <li className="form-item" key={uuidv4()}>
                                <Card>
                                    <FomAdmin item={item}></FomAdmin>
                                </Card>
                            </li>
                        );
                    })}
                </ul>
            </div>
        );
    }
}
export default AdminPage;
