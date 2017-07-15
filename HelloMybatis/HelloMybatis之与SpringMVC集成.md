# HelloMybatis之与Spring MVC 的集成
第一步：配置数据库连接，采用c3p0连接池（hibernate相同）
1. web.xml 配置 spring dispatchservlet
    
2. mvc-dispatcher-servlet.xml 文件配置
3. spring applicationContext.XML文件配置(与数据库相关，与mybatis sqlSessionFaction 整合，扫描所有mybatis mapper 文件等.)
4. 编写controller 类
5. 编写页面代码.
