import React from "react";
import "./index.less";
import { Table, Button, Popconfirm, message ,Divider} from "antd";
import { listSofts, deleteSoft } from "@/api/api";
import SearchForm from "./search";
import EditForm from "./edit";
class AdminSoftListPage extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      keyword: "",
      dataSource: [],
      pagination: { current: 1, pageSize: 10, total: 0 },
      loading: false,
      editing: false,
      currentRecord: {}
    };
  }
  columns = [
    {
      title: "名称",
      dataIndex: "softName",
      width: 150,
      key: "softName",
      ellipsis: true
    },
    {
      title: "详情",
      dataIndex: "softDesc",
      width: 150,
      key: "softDesc",
      ellipsis: true
    },
    {
      title: "官网",
      dataIndex: "website",
      width: 150,
      key: "website",
      ellipsis: true
    },
    {
      title: "下载地址",
      dataIndex: "url",
      width: 150,
      key: "url",
      ellipsis: true
    },
    {
      title: "图标",
      dataIndex: "icon",
      width: 100,
      key: "icon",
      render: icon => {
        return <img src={icon} className="table-img"></img>;
      }
    },
    {
      title: "操作",
      dataIndex: "opt",
      width: 200,
      key: "imgs",
      render: (data, record) => {
        return (
          <div>
            <Popconfirm
              title="确定删除？"
              onConfirm={() => {
                this.deleteRecord(record);
              }}
              okText="确定"
              cancelText="取消"
            >
              <Button >删除</Button>
            </Popconfirm>
            <Divider type="vertical" />
            <Button
              onClick={() => {
                this.editRecord(record);
              }}
            >
              编辑
            </Button>
          </div>
        );
      }
    }
  ];
  componentDidMount() {
    this.fetch();
  }
  handleTableChange = (pagination, filters, sorter) => {
    const pager = { ...this.state.pagination };
    pager.current = pagination.current;
    this.setState({
      pagination: pager
    },()=>{
      this.fetch();
    });

  };
  doSearch = keyword => {
    this.setState({ keyword: keyword }, () => {
      this.handleTableChange({current:1});
    });
  };
  fetch = () => {
    const { current, pageSize } = this.state.pagination;
    let params = {
      pageNumber: current,
      pageSize,
      keyword: this.state.keyword
    };
    this.setState({ loading: true });
    listSofts(params)
      .then(data => {
        data = data.data.data;
        const pagination = { ...this.state.pagination };
        pagination.total = data.total;
        this.setState({
          dataSource: data.records,
          pagination,
          loading: false
        });
      })
      .catch(e => {
        console.log(e);
      });
  };
  addSoft = () => {
    let history = this.props.history;
    history.push("/admin/soft/addSoft");
  };
  deleteRecord = record => {
    deleteSoft({ id: record.id })
      .then(res => {
        message.success("删除成功！");
        this.handleTableChange({ current: 1 });
      })
      .catch(e => console.log(e));
  };
  editRecord = record => {
    this.setState({
      editing: true,
      currentRecord: {
        ...record,
        category: record.category && record.category.categoryName
      }
    });
  };
  handleOk = () => {
    this.handleCancel();
    this.doSearch(this.state.keyword);
  };
  handleCancel = () => {
    this.setState({ editing: false, currentRecord: {} });
  };
  render() {
    return (
      <div className="admin-list-page">
        <SearchForm
          doSearch={this.doSearch}
          addSoft={this.addSoft}
        ></SearchForm>
        <Table
          columns={this.columns}
          rowKey={record => record.id}
          dataSource={this.state.dataSource}
          pagination={this.state.pagination}
          loading={this.state.loading}
          onChange={this.handleTableChange}
        />
        <EditForm
          handleOk={this.handleOk}
          visible={this.state.editing}
          currentRecord={this.state.currentRecord}
          handleCancel={this.handleCancel}
        ></EditForm>
      </div>
    );
  }
}
export default AdminSoftListPage;
