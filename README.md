# spring-boot-base-start

### 项目简介
基于Spring Boot & Jpa的种子项目,通过代码生成完成基础api的实现。

### 使用简介
1. 将项目克隆至本地.
2. 对配置文件```application-dev.properties```进行配置.
  - 项目名称 application
  - 数据库配置 datasource
  - 端口号 server
  - 是否允许访问api文档 swagger2
2. 根据业务在```model```包中创建```model```文件，测试可用自带```User```类进行.
3. 修改```core```包中```ProjectConstant```文件，```PROJECT_NAME```和```BASE_PACKAGE```的值.
4. 修改```text```包中```CodeGenerator```文件,```idType```(id类型)和```genCode("User");```(model类名)的值.
5. 并运行主函数生成代码.
6. 启动项目,查看[api文档](http://127.0.0.1:8080/swagger-ui.html).

### 使用技术列表
- spring-boot
- jpa
- gson
- swagger2
- lombok