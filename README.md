SSH-demo

项目前言总结:
该项目是个人信息管理系统的demo，应用的框架是SSH框架Spring+SpringMVC+Hibernate,采用基于 TransactionProxyFactoryBean的声明式事务管理对事务进行管理，开发平台则是Eclipse EE 企业版+Tomcat 9.0服务器+MYSQL数据库的组合,工具则在src目录下引入了com.image包，通过编写算法来实现验证码图片的获取，项目核心主要功能为登录验证，注册，对学生个人信息进行管理，比如删除，修改，项目实现分为Controller、pojo、dao、service层，pojo主要负责编写实体类和相应的*.hbm.xml(Hibernate数据映射文件)，dao层则负责对MYSQL数据的封装，增删改查等操作，service层则是负责业务，对dao层操作的数据进行业务封装,controller层则是控制器层，用于处理url请求，执行相应的Handler方法，根据相应的url请求，执行service层相应的业务，进而返回ModelAndView对象，跳转到相应的界面。
对于本次项目，我也遇到了不少问题，首先就是在写pojo类的Hibernate映射文件时，测试运行的时候Tomcat频繁出错，报错说是在主键字段那里出错了，我不止一次地去对照pojo类的属性名和数据库表里的属性名，均未发现错误，后来几经周转地在网上查到原来是大小写的问题，把string写成了String,导致初始化失败，而在对数据库操作的层面上，我开始的时候也是不知道HibernateTemplate的用法，网上查到的用法看起来都比较杂，后来在某帖子里找到了比较通俗易懂的用法，进而实现对数据库的一些操作，项目运行的时候我也出过400报错，是说只读模式下(FlushMode.NEVER/MANUAL)写操作不被允许，我一开始不知道是事务属性没配置好的原因，走了不少弯路，听网上的说在web.xml里配置个什么过滤器的，可仍然会报错，后来翻了一下书，发现事务要配置传播属性，而我的声明式事务bean里显然没配置，于是配置好就没报错了。
这次的项目，虽然做的过程很多问题接踵而至，但是好在我在问题面前没放弃，才能把项目做成，希望这次能成为我项目生涯的一份经验。

项目环境
Eclipse版本
Eclipse Java EE IDE for Web Developers.
Version: Oxygen.3a Release (4.7.3a)

Tomcat版本
Apache Tomcat/9.0.27

MYSQL版本
5.7.15

Jdk环境
java version "1.8.0_241"
Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)

项目实现:
1.创建项目，配置项目的文本字符集为utf-8，导入相应的Spring，SpringMVC，Hibernate的包

2.编写POJO层，写student数据库表的pojo类，然后编写student的Hibernate映射文件

3.编写DAO层，先写IStudentDAO接口，然后写StudentDAO实现IStudentDAO接口，导入HibernateTemplate属性，后面用来setter注入

4.编写Service层，先写StudentService接口，然后写StudentService接口的实现类StudentServiceImpl，导入StudentDAO属性，后面用来setter注入。

5.在WEB-INF编写ApplicationContext.xml,配置好相应的数据源DataSource，Hibernate的SessionFactory、事务管理器transactionManager，HibernateTemplate，并配置好相应的bean和property注入，以及相应的声明式事务，同时在另一个springmvc-servlet.xml中配置好相应的注解扫描和视图解析器ResourceviewResolver

6.编写Controller控制器层，引入@Controller，@RequestMapping等注解，供bean初始化时的扫描，编写好相应的业务。

7.Tomcat部署项目，启动Tomcat，在浏览器输入相关链接，进入主页面，执行相关登录，注册，增删改查等操作。
