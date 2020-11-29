import React from "react";
import { Menu, Icon } from "antd";
import { Link } from "react-router-dom";
import menuItems from "./menulist";
const { SubMenu } = Menu;
/**
 * 渲染单个菜单
 * @param {参数：在router中配置的元素} item
 * @param {索引} key
 */
const renderMenuItem = (item, key) => {
  if (item.hasChildren) {
    return (
      <SubMenu
        key={key}
        title={
          <span>
            {item.icon ? <Icon type={item.icon || ""} /> : null}
            <span>{item.name}</span>
          </span>
        }
      >
        {item.children.map((subItem, indexSub) => {
          return renderMenuItem(subItem, key + indexSub);
        })}
      </SubMenu>
    );
  }
  return (
    <Menu.Item key={key}>
      {item.icon ? <Icon type={item.icon || ""} /> : null}
      <span>
        <Link to={item.path}>{item.name}</Link>
      </span>
    </Menu.Item>
  );
};
/**
 * 菜单类
 */
class SideMenu extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      menuItems: []
    };
  }
  componentDidMount() {
    this.setState({ menuItems: menuItems });

  }
  render() {
    let height = this.props.height;
    const style = {
      height: `${height}px`
    };
    const menuItems = this.state.menuItems;
    return (
      <Menu
        defaultSelectedKeys={[`0`]}
        defaultOpenKeys={["0"]}
        mode="inline"
        theme="dark"
        className="app-menu"
        style={style}
      >
        {menuItems.map((item, index) => {
          return renderMenuItem(item, index);
        })}
      </Menu>
    );
  }
}
export default SideMenu;
