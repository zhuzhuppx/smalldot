#!/bin/bash
echo "start build  code... "
root=" /opt/app/source/small-dot"
codefolder=" $root/smalldot/small-dot-front/front-end"

ngpath=" /usr/local/nginx/html/small-dot"
gitpath="https://github.com/zhuzhuppx/smalldot.git"
cd  $root
if [ ! -d  $codefolder  ];then
    git clone $gitpath
else
    cd  $root/smalldot
    git pull
fi

cd  $codefolder
echo "cd  $codefolder"
yarn config set registry https://registry.npm.taobao.org/
yarn && yarn build
if [ ! -d  $ngpath  ];then
    echo "will done ,pleash wait"
else
    rm -rf $ngpath
fi
cp -r  $codefolder/build $ngpath
echo "build success... "
codefolder=" $root/smalldot/small-dot-backend"
cd  $codefolder
echo "cd  $codefolder"
mvn clean package  -DskipTests -P prod
echo "build backend code end... "
echo "start projects... "
port=8000
# 根据端口号去查询对应的PID
pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{print $1}');

# 杀掉对应的进程 如果PID不存在,即该端口没有开启,则不执行
if [ -n  "$pid" ]; then
    kill  -9  $pid;
fi
port=8001
# 根据端口号去查询对应的PID
pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{print $1}');

# 杀掉对应的进程 如果PID不存在,即该端口没有开启,则不执行
if [ -n  "$pid" ]; then
    kill  -9  $pid;
fi

cd /usr/local/smalldot/
cp -r $codefolder/smalldot-web/target/web.jar  /usr/local/smalldot/web.jar
rm -rf logs
mkdir /usr/local/smalldot/logs
sh start8000.sh &&sh start8001.sh

echo "projects started... "

echo "build success... "






