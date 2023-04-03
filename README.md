# 在线考试系统（Online examination system, Created by SpringBoot framework）

## 项目介绍

在线考试系统后端使用SpringBoot+Mybatis+Redis，前端使用Vue+ElementUI+DataV，数据库使用MySQL。


## 环境介绍

| 名称     | 描述                                       |
| ------ | ---------------------------------------- |
| Java版本 | JDK 11                                |
| IDE工具  | IntelliJ IDEA 2020.1(Ultimate Edition) |
| 构建工具   | Maven 3.3.6                              |
| Web服务器 | SpringBoot内嵌的Tomcat                      |
| 数据库    | MySQL 5.7                                |

## 运行步骤

1. 数据库导入，新建数据库exam，将`exam.sql`文件导入并运行。
2. 打开项目，打开`src/main/resources/application.yaml`，修改配置文件。
   1. 配置 MySQL 数据库
   2. 配置 Redis
3. 运行后端工程。
   1. SpringBoot 工程运行
4. 运行前端工程。
   1. `npm install`
   2. `npm run dev`

## 项目截图

登录界面

![输入图片说明](imgs/login.png)

题目管理

![输入图片说明](imgs/%E9%A2%98%E7%9B%AE%E7%AE%A1%E7%90%86.png)

考试管理

![输入图片说明](imgs/%E8%80%83%E8%AF%95%E7%AE%A1%E7%90%86.png)

组卷界面

![4]()

考试界面

![5]()

管理端可视化

![输入图片说明](imgs/admin%E5%8F%AF%E8%A7%86%E5%8C%96.png)

学生端可视化
![输入图片说明](imgs/stu%E5%8F%AF%E8%A7%86%E5%8C%96.png)
