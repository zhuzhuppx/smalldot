import React from "react";
import { Avatar } from "antd";
import { getUser } from "@/util/userUtil";

class MyAvatar extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    const { userName } = getUser()||{};
    return (
      <Avatar
        style={{ backgroundColor: "#f56a00", verticalAlign: "middle" }}
        size="large"
      >
        {userName}
      </Avatar>
    );
  }
}
export default MyAvatar;
