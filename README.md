**远程聊天(已实现)**  
将服务端独立，挂载于服务器，实现远程聊天。

**打包成exe可执行文件(已实现)**  
将文件打成Jar包后通过exe4j打成exe文件。

**开发环境**  
| Object | Version|
| :-: | :-: |
| MySQL(Server) | MySQL 8.0.24 |
| Navicat(localhost) | Navicat Premium 15 |
| 宝塔Linux面板 | 7.9.8 |
| JDK | 1.8 |
| JDBC | mysql-connector-java-5.1.49 |
| phpMyAdmin | phpMyAdmin 4.4|
| exe4j | exe4j_windows_6_0_2|



```
#一些Linux命令
#让命令一直执行
nohup java com.yychat.server.view.StartSever
#定时清除nohup.out文件
1.创建sh文件：
echo ""> /www/wwwroot/YYchat/out/production/YYchat/nohup.out

2.开启定时任务
crontab -e

3.添加定时任务
#添加
*/1 * * * * sh /www/wwwroot/YYchat/out/production/YYchat/task.sh
#保存内容
#敲击esc
#键盘输入 :wq!
```

```
#查看端口情况
netstat -apn | grep 6000
```

```
#一些Windows命令
#查看端口情况
netstat -aon | findstr 3306
```

```
#mysql连接包需要放置的地址
jdk地址/jre/lib/ext/
```

```
报错java.net.SocketException: Connection reset:
方法名上加上同步synchronized
```
