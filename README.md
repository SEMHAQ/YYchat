**YY聊天室  个人学习记录**
| # | 名称 | 日期 |
| :-: | :-: | :-: |
| 1 | 第一个简单的窗体程序 | 2023.3.3   |
| 2 | 创建登陆窗体程序1| 2023.3.3  |
| 3 | 创建登陆窗体程序2 | 2023.3.3   |
| 4 | 创建好友列表1 -实现卡片布局 | 2023.3.3   |
| 5 | 创建好友列表2 _实现2张卡片中的列 | 2023.3.4  |
| 6 |实现我的好友和陌生人2张卡片之间的切换|2023.3.4  |
| 7 |实现登陆界面到好友列表的切换 |2023.3.4  |
| 8 | 实现好友聊天界面| 2023.3.4  |
| 9 | 好友列表界面跳转到好友聊天界面的实现|2023.3.4  |
| 10 |实现服务器端界面 | 2023.3.5 |
| 11 |启动服务器并监听端口 | 2023.3.5 |
| 12 |客户端连接服务器 | 2023.3.5 |
| 13 |客户端通过Socket对象发送登陆 | 2023.3.5 |
| 14 |服务器端密码验证的实现 | 2023.3.5 |
| 15 |客户端发送聊天信息到服务器端 | 2023.3.5 |
| 16 |服务器转发聊天信息到接收方 | 2023.3.5 |
| 17 |激活在线好友图标 | 2023.3.5 |
| 18 |激活新上线好友图标 | 2023.3.5 |
| 19 |使用数据库实现用户登陆验证 | 2023.3.5 |
| 20 |用户登陆验证的数据库代码封装 | 2023.3.6 |
| 21 |注册新用户到user表中 | 2023.3.6 |
| 22 |使用数据库中好友来更新好友列表 | 2023.3.7 |
| 23 |添加新好友后更新好友列表 | 2023.3.7 |
| 24 |保存聊天消息到message表中 | 2023.3.7 |
| 25 |用户退出后关闭其服务线程 | 2023.3.7 |

**开发环境**  
| Object | Version|
| :-: | :-: |
| MySQL(localhost) | mysql-8.0.32-winx64 |
| Navicat(localhost) | Navicat Premium 15 |
| IDEA(localhost) | IntelliJ IDEA Community Edition 2021.2.2  |
| JDK | 17 |
| JDBC | mysql-connector-java-5.1.49 |

**项目中会用到的MySQL语句**
```
#创建表user
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(20) DEFAULT NULL,
`password` VARCHAR(20) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE = INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
```

```
#数据插入表user
INSERT INTO `user` VALUES (1,'pdh','123456');
INSERT INTO `user` VALUES (2,'大海','abc');
INSERT INTO `user` VALUES (3,'蓝天','你好');
``` 

```
#创建表user_relationship
DROP TABLE IF EXISTS `user_relationship`;
CREATE TABLE `user_relationship`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`masteruser` varchar(20) DEFAULT NULL,
`slaveuser` varchar(20) DEFAULT NULL,
`relation` int(11) NOT NULL,
PRIMARY KEY (`id`),
KEY `masteruser` (`masteruser`),
KEY `slaveuser` (`slaveuser`),
CONSTRAINT `user_relationship_ibfk_1` FOREIGN KEY (`masteruser`) REFERENCES `yychat`.`user` (`username`),
CONSTRAINT `user_relationship_ibfk_2` FOREIGN KEY (`slaveuser`) REFERENCES `yychat`.`user` (`username`)
)ENGINE = INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
```

```
#数据插入表user_relationship
INSERT INTO `user_relationship` VALUES (1,'pdh','大海',1);
INSERT INTO `user_relationship` VALUES (2,'pdh','蓝天',1);
``` 

```
#创建表message
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`sender` VARCHAR(20) DEFAULT NULL,
`receiver` VARCHAR(20) DEFAULT NULL,
`content` VARCHAR(255) DEFAULT NULL,
`sendtime` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
)ENGINE = INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8
``` 