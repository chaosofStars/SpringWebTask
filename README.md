# Java Web Task
## 部署地址

蜂巢：http://59.111.101.172:8080/

Github：https://github.com/chaosofStars/SpringWebTask.git

## 更新
settleAccount页面中，因为id=Account（account），导致无法购买


## 说明
### 数据库
数据库是直接连接到容器上的。
数据库名为：**task**，其中在`trx`表中，我增加了一个`num`字段，用来记录购买的数量，剩下为课程指定，没有变动。

### 代码
包名为com.netease.course,下面具体分为

- dao
包含三个接口，对应数据库中三个表，用于处理数据。
- meta
包含数据库中对应的三个表
    - product
根据`controller`的需要，具体产生的product类。本来只有一个product，因为`Edit`页面的返回对象，freemarker无法识别，增加了一个`EditProduct`。
- service
根据实际需求，编写出各个页面的service，最后抽象出的UserService和WebService，重复代码封装到webService类中。
    - impl
webService的具体实现类    
- utils
只有一个转换Byte-->String的工具类。原本写了时间转换工具类，后来发现可以直接getTime转换成long类型数据，就给取消了。
- web
  - controller
MVC，返回ModelView
    -api
对应/api/*中的页面  
  - filter
禁止买家访问发布和编辑页面

