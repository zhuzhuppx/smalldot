#!/bin/bash

echo "start copy front code... "
cd /opt/app/source/front
rm -rf /opt/app/source/front/small-dot-front
git clone https://github.com/zhuzhuppx/small-dot-front.git
cd /opt/app/source/front/small-dot-front/front-end
yarn config set registry https://registry.npm.taobao.org/
yarn && yarn build


cd /opt/app/source/back
rm -rf /opt/app/source/back/small-dot-backend
git clone https://github.com/zhuzhuppx/small-dot-backend.git
cd /opt/app/source/back/small-dot-backend
cp -r /opt/app/source/front/small-dot-front/front-end/build /opt/app/source/back/small-dot-backend/smalldot-web/src/main/resources/static

mvn clean package  -DskipTests -P prod
 

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
cp -r /opt/app/source/back/small-dot-backend/smalldot-web/target/web.jar  /usr/local/smalldot/web.jar
rm -rf logs
mkdir /usr/local/smalldot/logs
sh start8000.sh &&sh start8001.sh

ps -ef |grep java

echo "success"







