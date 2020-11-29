import React from "react";
import { Badge, Icon } from "antd";

class MyAvatar extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <Badge count={6} dot>
        <Icon type="notification" />
      </Badge>
    );
  }
}
export default MyAvatar;
