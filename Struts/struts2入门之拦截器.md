# struts2入门之拦截器

struts2中封装了许多的功能在拦截器里面，拦截器是struts2非常重要的一个概念
<!--more-->

## 拦截器概述

### 理解Struts2拦截器
1. 概述
    * 拦截器是指在访问某个Action或Action的某个方法，字段之前或之后实施拦截，并且Struts2拦截器是可插拔的，拦截器是ＡＯＰ的一种实现。
    * struts2封装了许多功能，这些功能都是在拦截器里面。
    * struts2有很多拦截器，不是每次这些拦截器都执行，每次执行默认的拦截器。
2. 拦截器栈（Interceptor Stack）。
    * Struts2拦截器栈就是将拦截器按一定的顺序联结成一条链。在访问被拦截的方法或字段时，Struts2拦截器链中的拦截器就会按其之前定义的顺序被调用。
3. 默认拦截器位置 
    * struts2-core-2.3.24.jar --> struts-default.xml-->标签：<interceptor-stack>
4. 实现Struts2拦截器原理
    * 当请求struts2的action时，Struts2会查找配置文件，并最后一个一个地调用列表中的拦截器。 根据其配置实例化相对应的拦截器对象，然后串成一个列表，最后一个一个地调用列表中的拦截器。
5. 拦截器执行位置
    * 执行时间：在action对象创建之后，action方法执行之前。

### 拦截器底层思想
1. AOP思想
    * 面向切面（方面）编程，即有基本功能，进行扩展时，不通过修改源代码方式扩展
2. 责任链模式
    * 过滤链：一个请求可以有多个过滤器进行过滤，每个过滤器只有做放行才能到下一个过滤器
    * 责任链：要执行多个操作，有添加、修改、删除三个操作。
        首先执行添加操作，添加操作执行之后，类似于放行之后，再执行下一步修改操作，类似于放行之后，最后再执行删除

### 拦截器与过滤器的区别        
1. 过滤器：理论上可以过滤任意内容
2. 拦截器：只可以拦截action

## 自定义拦截器
* 使用自定义功能，需要自己写拦截器实现功能

### 拦截器结构
1. 继承类 `AbstractInterceptor`  
    实现接口 `Interceptor`
2. 接口方法：

方法名|描述
---|---
init()| 初始化
destroy()|销毁
String intercept(ActionInvocation invocation)|拦截逻辑操作

### 实际开发方式
* 继承以上说的类或者实现以上说的接口都可以实现，但是不是最常用的，最常用方法如下：

1. 创建实体类继承 `MethodFilterInterceptor`，此方式可以让action里面的某个方法不进行拦截
2. 通过配置文件方式建立拦截器与action的关系
### 案例：自动登录拦截器
1. 需求分析：
    * 在项目中，有很多action的超链接，实现只有是登录的状态，才可以点击action的超链接实现功能，如果不是登录状态，点击aciton超链接返回登录页面
2. 登录状态
    * 实现：使用session域对象实现
    * 判断：判断session是否有值
3. 实现登录的基本功能（略）
4. 添加登录拦截器功能    
    1. 判断是否登录：判断session里面是否有名称是username的值
    2. 使用拦截器实现过程（重点）
        * 创建实体类，集成`MethodFilterInterceptor`
        * 重写方法 `doIntercept` 写拦截器逻辑
            ```java
            public class LoginInterceptor extends MethodFilterInterceptor {
                @Override
                protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
                    //得到session
                    HttpServletRequest request = ServletActionContext.getRequest();
                    Object obj = request.getSession().getAttribute("username");
                    if (obj!=null){
                        //登录状态
                        //放行之后执行action
                        return actionInvocation.invoke();            
                    }else {
                        //未登录状态，不执行aciton方法，返回登录界面
                        return "error";
                    }
                }
            }
            ```
        * 配置action和拦截器的关系--注册拦截器
            1. 在要拦截action标签所在package标签声明拦截器
            
                ```
                     <interceptors>
                         <interceptor name="loginInteceptor" class="interceptor.LoginInterceptor"></interceptor>
                     </interceptors>
                ```
                 
            2. 在具体action标签里面使用声明的拦截器
            
                ```
                     <package name="form1" extends="struts-default" namespace="/">
                           <!--声明拦截器-->
                            <interceptors>
                                <interceptor name="loginInteceptor" class="interceptor.LoginInterceptor"></interceptor>
                            </interceptors>
                            <action name="register" class="action.demo.form.RegisterAction">
                    
                            </action>
                    
                            <action name="login" class="action.LoginAction" method="login">
                                <interceptor-ref name="loginInteceptor"></interceptor-ref>
                                <result name="success">/hello.jsp</result>
                                <result name="error">/login.jsp</result>
                            </action>
                        </package>
                ```
                
            3. 默认拦截器手动使用
            
                `  <interceptor-ref name="defaultStack"></interceptor-ref>`
5. 配置不拦截方法 
    * 问题：完成以上拦截器配置之后，对action里面所有的方法都进行拦截，此时login()方法也被拦截，用户无法完成登录操作
    * 解决：通过配置方式让action中的login方法不进行拦截
        在struts.xml中配置的拦截器使用标签里面，添加<param>标签
    
        ```
           <interceptor-ref name="loginInteceptor">
              <param name="excludeMethods">login</param>
           </interceptor-ref>
        ```