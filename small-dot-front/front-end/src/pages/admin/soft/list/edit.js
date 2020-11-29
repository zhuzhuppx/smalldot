import React from "react";
import { Modal, Button } from "antd";
import EditForm from '../addsoft/form'
class EditPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = { visible: false };
  }

  render() {
    const {  visible, handleCancel ,currentRecord,handleOk} = this.props;
    return (
      <div>
        <Modal
          title="编辑"
          visible={visible}
          footer={null}
          onCancel={handleCancel}
        >
         <EditForm item={currentRecord} callback={handleOk}></EditForm>
        </Modal>
      </div>
    );
  }
}
export  default EditPage