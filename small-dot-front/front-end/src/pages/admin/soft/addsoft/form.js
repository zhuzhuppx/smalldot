import React from "react";

import { Form, Input, Button, Upload, Icon, message, Select } from "antd";
import UploadFile from "@/components/upload";
import { saveSoft } from "@/api/api";
const { Option } = Select;

const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 16 }
};
const tailLayout = {
  wrapperCol: { offset: 8, span: 16 }
};
const urlReg = /(https?|ftp|file):\/\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]/;
const categoryList = [
  {
    label: "JAVA",
    value: "1"
  },
  {
    label: "前端",
    value: "2"
  }
];
const validatorUrl = (rule, value, callback) => {
  if (urlReg.test(value)) {
    callback();
  } else {
    callback("请输入一个网址");
  }
};
class FormAdmin extends React.Component {
  normFile = e => {
    if (Array.isArray(e)) {
      return e;
    }
    return e && e.fileList;
  };
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log("Received values of form: ", values);
        saveSoft({...values,id:this.props.item.id})
          .then(res => {
            message.success(`保存成功！`);
            this.props.form.resetFields();
            if(this.props.callback&&this.props.callback instanceof Function){
              this.props.callback();
            }
          })
          .catch(error => {
            console.log(error);
          });
      }
    });
  };
  render() {
    const { getFieldDecorator } = this.props.form;
    const {
      softName,
      softDesc,
      website,
      url,
      category,
      imgs,
      icon
    } = this.props.item;
    let ct = categoryList.find(i => i.label == category);
    let categoryId = ct && ct.value;
    return (
      <Form {...layout} name="basic" onSubmit={this.handleSubmit}>
        <Form.Item label="软件类别" name="categoryId">
          {getFieldDecorator("categoryId", {
            initialValue: categoryId,
            rules: [{ required: true, message: "请输入下载地址!" }]
          })(
            <Select
              showSearch
              style={{ width: 200 }}
              placeholder="选择一个分类"
            >
              {categoryList.map(ct => {
                return (
                  <Option key={ct.value} value={ct.value}>
                    {ct.label}
                  </Option>
                );
              })}
            </Select>
          )}
        </Form.Item>
        <Form.Item label="软件名称" name="softName">
          {getFieldDecorator("softName", {
            initialValue: softName,
            rules: [
              {
                required: true,
                message: "请输入软件名称!"
              }
            ]
          })(<Input />)}
        </Form.Item>
        <Form.Item label="软件描述" name="softDesc">
          {getFieldDecorator("softDesc", {
            initialValue: softDesc,
            rules: [{ required: true, message: "请输入软件描述!" }]
          })(<Input.TextArea rows={3} />)}
        </Form.Item>
        <Form.Item label="官网地址" name="website">
          {getFieldDecorator("website", {
            initialValue: website,
            rules: [
              {
                required: true,
                message: "请输入官网地址!"
              },
              {
                validator: validatorUrl
              }
            ]
          })(<Input />)}
        </Form.Item>
        <Form.Item label="下载地址" name="url">
          {getFieldDecorator("url", {
            initialValue: url,
            rules: [
              {
                required: true,
                message: "请输入下载地址!"
              },
              {
                validator: validatorUrl
              }
            ]
          })(<Input />)}
        </Form.Item>

        <Form.Item label="图标" name="icon">
          {getFieldDecorator("icon", {
            initialValue: icon,
            rules: [
              {
                required: true,
                message: "请输入图标!"
              },
              {
                validator: validatorUrl
              }
            ]
          })(<Input />)}
        </Form.Item>
        {/* <Form.Item label="图片">
          {getFieldDecorator("imgs", {
            initialValue: imgs,
            getValueFromEvent: this.normFile,
            rules: [
              {
                validator: (rule, value, callback) => {
                  if (!value || value.length === 0) {
                    callback("请上传图片");
                  }
                  callback();
                }
              }
            ]
          })(<UploadFile></UploadFile>)}
        </Form.Item> */}
        <Form.Item {...tailLayout}>
          <Button type="primary" htmlType="submit">
            提交
          </Button>
        </Form.Item>
      </Form>
    );
  }
}

export default Form.create({ name: "formAdmin" })(FormAdmin);
