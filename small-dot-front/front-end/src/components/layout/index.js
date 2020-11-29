import React from "react";
import { Switch, Route } from "react-router-dom";
import { Layout, Icon } from "antd";
import Message from "./Message";
import Avatar from "./Avatar";
import { RouteWithSubRoutes } from "@/routes/helper.js";
import './index.less'
import MyFooter from './MyFooter';
const { Header, Content,Footer } = Layout;

class PageLayout extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      collapsed: false,
      height: 0
    };
  }

  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed
    });
  };
  componentDidMount() {
    document.getElementById('root').classList.add('main-index-root')
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
      <Layout className="c-app">
        <Layout>
          {/* <Header style={{ background: "#fff", padding: 0 }}>
            <span style={{ float: "right", marginRight: 16 }}>
              <span style={{ marginRight: 16 }}>
                <Message></Message>
              </span>
              <span>
                <Avatar></Avatar>
              </span>
            </span>
          </Header> */}
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
          <Footer>
            <MyFooter></MyFooter>
          </Footer>
        </Layout>
      </Layout>
    );
  }
}

export default PageLayout;
