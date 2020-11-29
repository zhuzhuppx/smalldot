import React from "react";

class MyFooter extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
     <div>
      <span style={{marginRight:'16px'}}>©7921007</span>  <a target="_blank" href="http://www.beian.miit.gov.cn/">京ICP备20008534号</a>
     </div>
    );
  }
}
export default MyFooter;
