import React from "react";
import { Switch, Route } from "react-router-dom";
import { Layout, Icon,Divider } from "antd";
import Message from "../Message";
import Avatar from "../Avatar";
import Menu from "./Menu";

import { RouteWithSubRoutes } from "@/routes/helper.js";
import './index.less'
const { Header, Content, Sider } = Layout;

class PageLayout extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      collapsed: false,
      height: 0,
      histtory: this.props.histtory
    };
  }

  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed
    });
  };
  componentDidMount() {
    let h =
      window.innerHeight ||
      document.documentElement.clientHeight ||
      document.body.clientHeight - 54;
    this.setState({ height: h });
  }
  render() {
    let height = this.state.height;
    const routes = this.props.routes || [];
    return (
      <Layout className="admin-app">
        <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
          <Menu></Menu>
        </Sider>
        <Layout>
          <Header style={{ background: "#fff", padding: 0 }}>
            <span style={{ float: "right", marginRight: 16 }}>
              <span style={{ marginRight: 16 }}>
                <Message></Message>
              </span>
              <span>
                <Avatar></Avatar>
              </span>
            </span>
            <Divider></Divider>
          </Header>

          <Content
            style={{
              margin: "24px 0",
              padding: 0,
              background: "#fff",
              minHeight: height
            }}
          >
            <div className="main">
              <Switch>
                {routes.map((route, index) => (
                  <RouteWithSubRoutes key={index} {...route} />
                ))}
              </Switch>
            </div>
          </Content>
        </Layout>
      </Layout>
    );
  }
}

export default PageLayout;
