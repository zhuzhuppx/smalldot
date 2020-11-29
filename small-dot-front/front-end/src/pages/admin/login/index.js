import React from "react";
import "./index.less";
import { Form, Icon, Input, Button, Checkbox } from "antd";
import bgImg from "@/assets/timg.jpeg";
import {setUser} from '@/util/userUtil'
class LoginPage extends React.Component {
  componentDidMount() {
    document.body.style.overflow = "hidden";
  }
  componentWillUnmount() {
    document.body.style.overflow = "auto";
  }
  handleSubmit = e => {
    const history = this.props.history;
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {          
        setUser(values)
        history.push("/main/index");
      }
    });
  };
  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <div className="login-page">
        <div className="bg-img">
          <img src={bgImg}></img>
        </div>
        <Form onSubmit={this.handleSubmit} className="login-form">
          <Form.Item>
            {getFieldDecorator("userName", {
              rules: [
                {
                  required: true,
                  message: "请输入用户名"
                }
              ]
            })(
              <Input
                prefix={
                  <Icon type="user" style={{ color: "rgba(0,0,0,.25)" }} />
                }
                placeholder="用户名"
              />
            )}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator("password", {
              rules: [
                {
                  required: true,
                  message: "请输入密码"
                }
              ]
            })(
              <Input
                prefix={
                  <Icon type="lock" style={{ color: "rgba(0,0,0,.25)" }} />
                }
                type="password"
                placeholder="密码"
              />
            )}
          </Form.Item>
          <Form.Item>
            <Button
              type="primary"
              htmlType="submit"
              className="login-form-button"
            >
              登录
            </Button>
          </Form.Item>
        </Form>
      </div>
    );
  }
}
export default Form.create({ name: "form_login" })(LoginPage);
