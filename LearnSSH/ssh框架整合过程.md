# SSH框架整合过程

## 导入jar包

## 搭建struts2环境
1. 创建action，创建sturts.xml配置文件，配置action
2. 配置struts2过滤器

## 搭建hibernate环境
1. 创建实体类
2. 配置实体类和数据库表映射关系
3. 创建hibernate核心配置文件
    * 引入映射配置文件
    
##  搭建spring环境
  1. 创建spring核心配置文件
  2. 让spring配置文件在服务器加载时启动
      * 配置监听器
        ```xml
            <listener>
               <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
            </listener>
        ```
      * 制定spring配置文件位置  
        ```xml
            <context-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:bean1.xml</param-value>
            </context-param>
        ```
        
## struts2和spring整合
1. 把action在spring中配置
    action为多实例:配置：`scope="prototype"`
    ```xml
        <bean id="userAction" class="com.aciton.UserAction" scope="prototype">
           <property name="userService" ref="userService"></property>
        </bean>
    ```
2. struts.xml中action标签class属性里面写bean的id值
    ```xml
       <struts>
           <package name="demo" extends="struts-default" namespace="/">
               <action name="userAction" class="userAction"></action>
           </package>
       </struts>
    ```

## spring和hibernate整合
1. 把hibernate核心配置文件里面的数据库配置，直接写在spring配置文件中

    ```xml
        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
            <property name="driverClass" value="com.mysql.jdbc.Driver"></property>
            <property name="jdbcUrl" value="jdbc:mysql:///demo"></property>
            <property name="user" value="root"></property>
            <property name="password" value="123"></property>
        </bean>
    ```
2. 把hibernate的sessionFactory在spring配置
    ```xml
        <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
                    <!--注入DataSource属性-->
           <property name="dataSource" ref="dataSource"></property>
                    <!--指定hibernate核心配置文件-->
           <property name="configLocation" value="classpath:hibernate.cfg.xml"></property>
        </bean>
     ```   

## 在dao里面使用hibernateTemplate
1. 在dao注入hibernateTemplate对象
   ```xml
       <!--  实现类对象  -->
       <bean id="userDaoImp" class="com.dao.UserDaoImp">
          <property name="hibernateTemplate" ref="hibernateTemplate"></property>
       </bean>
   ```
2. 创建hibernateTemplate对象并在 hibernateTemplate对象中注入sessionFactory
   ```xml
       <bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
          <property name="sessionFactory" ref="sessionFactory"></property>
       </bean>
   ```
## 配置事务管理（此处使用注解方式）  
1. 配置事务管理器
    ```xml
       <bean id="TransactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager" >
           <!--注入sessionFactory-->
           <property name="sessionFactory" ref="sessionFactory"></property>
       </bean>
    ```
2. 开启事务注解
    ```xml
       <tx:annotation-driven transaction-manager="TransactionManager">
       </tx:annotation-driven>
   ```
3. 并在service类加注解：`@Transactional`