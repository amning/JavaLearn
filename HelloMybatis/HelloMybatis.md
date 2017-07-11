# Hello Mybatis之快速入门

## Mybatis框架概述
1. Mybatis是什么？
    1. Mybatis是一个优秀的持久层框架，封装了jdbc的操作数据的过程；
    2. 通过xml或者注解的方式，将执行的各种statement进行配置，并通过java对象和statement中的sql进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射成java对象并返回。
2. ORM思想   
    1. 从配置文件(通常是XML配置文件中)得到 sessionfactory.
    2. 由sessionfactory  产生 session
    3. 在session 中完成对数据的增删改查和事务提交等.
    4. 在用完之后关闭session 。
    5. 在Java 对象和 数据库之间有做mapping 的配置文件，也通常是xml 文件。
3. Mybatis与hibernate比较
    * Mybatis的优势：
        1. Mybatis框架相对简单很容易上手;
        2. MyBatis可以进行更为细致的SQL优化，可以减少查询字段
    * hibernate优势
        1. Hibernate的DAO层开发比MyBatis简单，Mybatis需要维护SQL和结果映射。
        2. Hibernate对对象的维护和缓存要比MyBatis好，对增删改查的对象的维护要方便。
        3. Hibernate数据库移植性很好，MyBatis的数据库移植性不好，不同的数据库需要写不同SQL。
        4. Hibernate有更好的二级缓存机制，可以使用第三方缓存。MyBatis本身提供的缓存机制不佳。
    * 综上所述..Mybatis简单，，，所以我选择Mybatis
## Mybatis创建步骤
1. 新建web工程，导入Mybatis与MySQL的相关jar包
2. 创建Mybatis核心配置文件
    1. 在src目录下创建Mybatis配置文件conf.xml
    2. conf.xml中引入dtd约束
    * 注：如安装有Mybatis的相关辅助插件（Mybatis-plugin与Mybatis-tool）可以直接在src下鼠标右键new-->mybatis-config
        将会自动引入约束，
    3. 使用<environments>标签配置数据库连接(代码基本固定)
    4. 使用<mappers>标签引入实体类对应的配置文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
        <environments default="development">
            <environment id="development">
            <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/mybatis" />
                <property name="username" value="root"/>
                <property name="password" value="123"/>
                </dataSource>
            </environment>
        </environments>   
        <mappers>
            <mapper resource="com/mybatis/model/User.xml"/>
        </mappers>
    </configuration>
```
3. 建立与数据库对象的java class以及映射文件
    1. 在src下建立com.model包，并在包下建立User类；
    2. 在User类中创建相关属性以及get与set方法
    3. 建立这个User的映射文件 UserMapper.xml
    <
```xml
<?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!--mapper标签
        namespace命名空间,作用就是对sql进行分类化的管理,理解为sql隔离
        为维护方便，可以使用包.类映射文件名命名
     -->
    <mapper namespace="com.mybatis.models.UserMapper">
        <!--select标签中：
        id:标识映射文件中的sql，称为statement的id，此id将代表所封装的sql语句的功能
        parameterType:指定输入参数的类型,这里指定int型
        resultType:指定sql输出结果所映射的java对象类型
        -->
        <select id="selectUserByID" parameterType="int" resultType="User">
        <!-- #{}:表示一个占位符;
             #{id}:其中Id表示接收输入的参数，参数名称就是id,如果输入参数是简单类型，#{}中的参数名可以任意，可以是value或者其它名称;-->
            select * from `user` where id = #{id}
        </select>
    </mapper>
```
 4. 调用
    1. 创建会话工厂，传入Mybatis配置文件信息
    2. 通过工厂得到sqlsession
    3. 通过sqlSession操作数据库
```java
public class UserDao{
   public void findUserByIdTest() {
        // mybatis的配置文件
        String resource = "conf.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 1.创建会话工场,传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
           // 2.通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
           // 3.通过sqlSession操作数据库
            // 第一个参数：映射文件中的statement的Id,等于namespace + "." + statement的id;
            // 第二个参数:指定和映射文件中所匹配的parameterType类型的参数;
            // sqlSession.selectOne结果是与映射文件所匹配的resultType类型的对象;
            // selectOne：查询一条结果
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```    

* 现在运行这个程序，是不是得到查询结果了。恭喜你，环境搭建配置成功!

