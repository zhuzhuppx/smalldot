import React from "react";
import "./index.less";
import ListPage from "./list";
class IndexPage extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="index-page">
        <ListPage></ListPage>
      </div>
    );
  }
}
export default IndexPage;
