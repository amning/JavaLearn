# ssh整合思想

## 三大框架应用javaee三层结构
* web层：struts2框架  
* service层：spring框架
* dao层：hibernate框架

## 整合方式
* 两个框架之间进行整合

### struts2框架与spring框架
* 把struts2的action对象创建交给spring进行管理
    <bean id="" class="" scope="prototype">

web.xml
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
             version="3.1">
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:bean1.xml</param-value>
        </context-param>
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
        <filter>
            <filter-name>struts2</filter-name>
            <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>struts2</filter-name>
            <url-pattern>*</url-pattern>
        </filter-mapping>
    
    </web-app>
```
bean1.xml(spring核心配置文件)
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
            <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
            <property name="jdbcUrl" value="jdbc:mysql:///demo"></property>
            <property name="user" value="root"></property>
            <property name="password" value="wangning"></property>
        </bean>
    
        <bean id="user" class="com.aciton.UserAction" scope="prototype">
        </bean>
    </beans>
```

struts.xml
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    
    <!DOCTYPE struts PUBLIC
            "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
            "http://struts.apache.org/dtds/struts-2.3.dtd">
    
    <struts>
        <package name="demo" extends="struts-default" namespace="/">
            <action name="userAction" class="user"></action>
        </package>
    </struts>
```

    
### spring框架与hibernate框架
1. 把hibernate核心配置文件里面的数据库配置，直接写在spring配置文件中

```xml
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
        <property name="jdbcUrl" value="jdbc:mysql:///demo"></property>
        <property name="user" value="root"></property>
        <property name="password" value="123"></property>
    </bean>
```
2. 把sessionFactory的创建交给spring进行管理
    1. 使用spring封装的sessionFactory类：localSessionFactoryBean
    
        ```xml
            <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
                <!--注入DataSource属性-->
                <property name="dataSource" ref="dataSource"></property>
                <!--指定hibernate核心配置文件-->
                <property name="configLocation" value="classpath:hibernate.cfg.xml"></property>
            </bean>
        ```
    2. 创建hibernateTemplate类 并注入sessionFactory
    
        ```xml
            <bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
                <property name="sessionFactory" ref="sessionFactory"></property>
            </bean>
        ```
    3. 在实现类中注入hibernateTemplate
    
        ```xml
           <bean id="userDaoImp" class="com.dao.UserDaoImp">
             <property name="hibernateTemplate" ref="hibernateTemplate"></property>
           </bean>
        ```
    4. 在service中注入dao层对象 

        ```xml
               <bean id="userService" class="com.service.UserService">
                   <property name="userDao" ref="userDaoImp"></property>
               </bean>
               
        ```
    5. 开启spring事务管理器，否则会出现异常：
        org.springframework.dao.InvalidDataAccessApiUsageException
       
        ```xml
               <!--配置事务管理器-->
           <bean id="TransactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager" >
               <!--注入sessionFactory-->
               <property name="sessionFactory" ref="sessionFactory"></property>
           </bean>
           <!--开启事务注解-->
           <tx:annotation-driven transaction-manager="TransactionManager"></tx:annotation-driven>

        ```
        并在service类加注解：@Transactional