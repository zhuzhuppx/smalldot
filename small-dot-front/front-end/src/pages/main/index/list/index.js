import React from "react";
import { List, Avatar, Tag, Skeleton, Button, Input, Card, Modal } from "antd";
import MyForm from "@/pages/admin/soft/addsoft/form.js";
import { querySofts } from "@/api/api";
const { Search } = Input;
const { Meta } = Card;

class ListPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isMobile: false,
            data: [],
            list: [],
            pagger: {
                current: 1,
                pageSize: 10,
                total: 0
            },
            initLoading: true,
            loading: false,
            visible: false,
            currentTask:{}
        };
    }
    componentDidMount() {
        this.onLoadMore();
        if (/(iPhone|iPad|iPod|iOS|Android)/i.test(navigator.userAgent)) {
            //移动端
            this.setState({ isMobile: true });
        }
    }
    fetchData = page => {
        this.setState(
            { current: page, initLoading: false, loading: true },
            () => {
                querySofts({
                    pageNumber: page,
                    pageSize: this.state.pagger.pageSize,
                    keyword: this.state.keyword
                })
                    .then(res => {
                        let data = res.data;
                        data = data.data;
                        let pagger = { ...this.state.pagger };
                        pagger.current = pagger.current + 1;
                        const results = this.state.data.concat(data.records);
                        this.setState(
                            {
                                data: results,
                                list: results,
                                loading: false,
                                pagger: pagger
                            },
                            () => {
                                window.dispatchEvent(new Event("resize"));
                            }
                        );
                    })
                    .catch(error => console.log(error));
            }
        );
    };
    onLoadMore = e => {
        this.setState(
            {
                loading: true,
                list: this.state.list.concat(
                    [...new Array(this.state.pagger.pageSize)].map(() => ({
                        loading: true,
                        softName: "",
                        softDesc: ""
                    }))
                )
            },
            () => {
                this.fetchData(this.state.pagger.current);
            }
        );
    };
    doSearch = val => {
        let pagger = this.state.pagger;
        pagger.current = 1;
        this.setState({ keyword: val, pagger, data: [], list: [] }, () => {
            this.onLoadMore();
        });
    };
    keywordChange = e => {
        this.setState({ keyword: e.target.value });
    };
    publishTask = e => {
        console.log(e);
        this.setState({
            visible:true
        })
    };
    hideMe=()=>{
        this.setState({
            visible:false
        })
        this.doSearch('')
    }
    render() {
        const { list, pagger, initLoading, loading, isMobile } = this.state;
        const LoadMore =
            !initLoading && !loading ? (
                <div
                    style={{
                        textAlign: "center",
                        marginTop: 12,
                        height: 32,
                        lineHeight: "32px"
                    }}
                >
                    <Button onClick={this.onLoadMore}>加载更多</Button>
                </div>
            ) : null;

        return (
            <div>
                <div className="search-input">
                    <div className="search-input-left">
                        {" "}
                        <Search
                            placeholder="输入关键词搜索"
                            enterButton="搜索"
                            size="large"
                            onSearch={this.doSearch}
                            onChange={this.keywordChange}
                        />
                    </div>
                    <div className="publish-task">
                        <Button onClick={this.publishTask}>发布软件</Button>
                    </div>
                </div>
                {isMobile ? (
                    <div>
                        <ul>
                            {list.map(item => (
                                <li key={item.id}>
                                    <Card
                                        style={{ width: 300, marginTop: 16 }}
                                        actions={[
                                            <a href={item.website}>官网</a>,
                                            <a href={item.url}>下载</a>
                                        ]}
                                    >
                                        <Skeleton
                                            loading={item.loading}
                                            avatar
                                            active
                                        >
                                            <Meta
                                                avatar={
                                                    <Avatar src={item.icon} />
                                                }
                                                title={item.softName}
                                                description={item.softDesc}
                                            />
                                        </Skeleton>
                                    </Card>
                                </li>
                            ))}
                        </ul>
                        {LoadMore}
                    </div>
                ) : (
                    <List
                        className="demo-loadmore-list"
                        loading={initLoading}
                        itemLayout="horizontal"
                        loadMore={LoadMore}
                        dataSource={list}
                        renderItem={item => (
                            <List.Item
                                key={item.id}
                                actions={[
                                    <a
                                        key="list-loadmore-edit"
                                        href={item.website}
                                        target="_blank"
                                    >
                                        官网
                                    </a>,
                                    <a
                                        key="list-loadmore-more"
                                        href={item.url}
                                        target="_blank"
                                    >
                                        下载
                                    </a>
                                ]}
                            >
                                <Skeleton
                                    avatar
                                    title={false}
                                    loading={item.loading}
                                    active
                                >
                                    <List.Item.Meta
                                        avatar={<Avatar src={item.icon} />}
                                        title={
                                            <a href={item.website}>
                                                {item.softName}
                                            </a>
                                        }
                                        description={item.softDesc}
                                    />
                                    <div>
                                        <Tag color="#87d068">
                                            {item.category &&
                                                item.category.categoryName}
                                        </Tag>
                                    </div>
                                </Skeleton>
                            </List.Item>
                        )}
                    ></List>
                )}
                <Modal title="添加" visible={this.state.visible} footer={null} onCancel={this.hideMe}>
                    <MyForm item={this.state.currentTask} callback={this.hideMe}></MyForm>
                </Modal>
            </div>
        );
    }
}
export default ListPage;
