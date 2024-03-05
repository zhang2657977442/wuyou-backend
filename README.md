# 招聘小程序无忧直聘(后端)

:star:此项目采用Java+SpringBoot2+MybatisPlus+Mysql等技术开发，集成swagger接口文档，建议使用IntelliJ IDEA打开，适合学习\二次开发等用途。

## 项目列表

+ [无忧直聘前端(Uni-app+Vue2)](https://github.com/zhang2657977442/wuyou-frontend)
+ [无忧直聘后端(Java+SpringBoot2+MybatisPlus+Mysql)](https://github.com/zhang2657977442/wuyou-backend)
+ [无忧直聘管理端(React+Ant Design+Ant Design Pro)](https://github.com/zhang2657977442/wuyou-admin)

## 运行步骤
+ 在mysql中创建名为wuyou_recruit的库
+ 执行项目中的run.sql文件进行表的创建和数据导入
+ 修改constant/WXConfigConstant文件中的APP_ID和密钥

![](https://raw.githubusercontent.com/zhang2657977442/MyPicGo/master/wuyou-backend/%E4%BF%AE%E5%A4%8Dwx%E9%85%8D%E7%BD%AE.png)
+ 修改application.yaml文件中的数据库配置

![](https://raw.githubusercontent.com/zhang2657977442/MyPicGo/master/wuyou-backend/%E4%BF%AE%E6%94%B9%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE.png)
+ 执行MainApplication启动类
+ 访问http://localhost:8080/api/swagger-ui.html    出现swagger接口文档表示启动成功

![](https://raw.githubusercontent.com/zhang2657977442/MyPicGo/master/wuyou-backend/%E5%90%AF%E5%8A%A8%E6%88%90%E5%8A%9F.png)

## 数据模型

![](https://github.com/zhang2657977442/MyPicGo/blob/master/wuyou-backend/%E6%95%B0%E6%8D%AE%E6%A8%A1%E5%9E%8B.png?raw=true)

## 注意事项

+ 使用后台管理添加岗位时，要确保有招聘者和该岗位的公司进行绑定，否则getJobList接口查询不到新增的岗位

## 开源不易 谢谢支持

![](https://raw.githubusercontent.com/zhang2657977442/MyPicGo/master/other/%E8%B5%9E%E8%B5%8F%E7%A0%81.jpg)

如有问题请联系
+ QQ：2657977449 
+ 微信：zhang2657977449

