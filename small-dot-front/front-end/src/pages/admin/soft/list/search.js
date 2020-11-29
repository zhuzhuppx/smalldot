import React from "react";

import { Form, Icon, Input, Button } from "antd";

function hasErrors(fieldsError) {
  return Object.keys(fieldsError).some(field => fieldsError[field]);
}

class HorizontalLoginForm extends React.Component {
  componentDidMount() {}

  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.doSearch(values['softName']);
      }
    });
  };
  addSoft = () => {
    this.props.addSoft();
  };
  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <Form layout="inline" onSubmit={this.handleSubmit}>
        <Form.Item>
          {getFieldDecorator("softName")(<Input placeholder="软件名称" />)}
        </Form.Item>
        <Form.Item>
          <Button type="primary" htmlType="submit">
            搜索
          </Button>
        </Form.Item>
        <Form.Item>
          <Button type="button" htmlType="button" onClick={this.addSoft}>
            添加
          </Button>
        </Form.Item>
      </Form>
    );
  }
}

const WrappedHorizontalLoginForm = Form.create({ name: "horizontal_login" })(
  HorizontalLoginForm
);
export default WrappedHorizontalLoginForm;
