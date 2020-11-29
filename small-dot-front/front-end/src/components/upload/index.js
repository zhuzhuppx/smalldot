import React from "react";
import { Button, message } from "antd";
import { upload } from "@/api/api";
import { listSofts } from "../../api/api";
class Upload extends React.Component {
  constructor(props) {
    super(props);
    this.state = { fileList: [] };
  }
  componentDidMount(){
      let value = this.props.value;
      if(value){
          this.setState({fileList:value})
      }
  }
  uploadClick = () => {
    this.refs.inputFIleRef.click();
  };
  uploadFIle = e => {
    let file = e.target.files[0];
    let form = new FormData();
    form.append("file", file);
    upload(form)
      .then(res => {
        let data = res.data;
        data = data.data;
        let fileList = [...this.state.fileList];
        fileList.push({ imgUrl: data, id: new Date().getTime() });
        this.setState({
          fileList: fileList
        });
        this.refs.inputFIleRef.value = null;
        const onChange = this.props.onChange;
        if (onChange) {
          onChange(fileList);
        }
      })
      .catch(error => {
        console.log(error);
        this.refs.inputFIleRef.value = null;
      });
  };
  render() {
    const fileList = this.state.fileList;

    return (
      <div>
        <div>
          <input
            ref="inputFIleRef"
            type="file"
            onChange={this.uploadFIle}
            style={{ display: "none" }}
          ></input>
          <Button onClick={this.uploadClick}>上传</Button>
        </div>
        <ul>
          {fileList.map(img => {
            return (
              <li key={img.id} style={{ float: "left", marginRight: 16 }}>
                <img src={img.imgUrl} style={{ width: 100, height: 100 }}></img>
              </li>
            );
          })}
        </ul>
      </div>
    );
  }
}
export default Upload;
