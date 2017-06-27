#### hibernate查询方式
##### 一、对象查询
* 根据id查询某个客户，再查询这个客户里面所有的联系人

##### 二、OID查询
* 根据id查询某一条记录，返回对象
    *调用session里面的get方法实现
    
     `Customer customer=session.get(Customer.class,1);`
     
##### 三、hql查询
* Query 对象，写hql语句实现查询
1. hql：hibernate query language--hibernate提供的一种查询语言，与sql类似，区别在于sql操作数据库表和字段，hql操作实体类和属性。
2. 常用hql语句
3. 使用hql查询操作的时候，使用Query对象
    1. 创建Query对象，写hql语句；
    2. 调用Query对象里面的方法得到结果。
    
    * 查询所有
        ``` 
          //创建query对象
           Query query= session.createQuery("from Customer");
           //调用list方法
           List<Customer> list=query.list();
        ``` 
    * 条件查询
        
        `frome 实体类名称 where 属性名称=?`
        
    * 排序查询
        根据cid排序 默认为升序（ASC)，如需降序需设置DESC
        
         ` frome 实体类名称 order by cid asc/desc`
        
    * 分页查询
        
        ` frome 实体类名称 order`
        
        ```
        int start = 0;
        int count = 3;
        Query query = session.createQuery("from Customer");
         //设置开始位置
         query.setFirstResult(start);
         //设置每页记录数
         query.setMaxResult(count);
         ```
    * 投影查询
        1. 概念：查询部分字段
        2. hql语句写法：
        
            `select 实体类属性名称1，实体类属性名称2 frome 实习类名称`
                （select后面不能写*）
                
    * 聚集函数使用
        1. 常用聚集函数：count、sum、avg、max、min
        2. hql聚集函数语句写法
            
             `select count(*) from 实体类`
 
        
##### 四、QBC查询
* Criteria对象
    ```java
    public class Get{
        public void getByQBC(){
            try(
                 SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                 Session session =sessionFactory.openSession();
                    ){
                    Transaction transaction=session.beginTransaction();
                    //创建criteria对象
                    Criteria criteria = session.createCriteria(Customer.class);
                   /*
                   此处执行criteria的相关方法
                    */
                    transaction.commit();
               }catch (Exception e){
                e.printStackTrace();
              }
            }
        }
    ```
    * 查询所有
      
         ```
           Criteria c = session.creatCriteria(Customer.class);
          List<Customer> list = c.list();
      
         ```
      
    * 条件查询
        ```
           //使用add方法，设置条件值-->Restrictions对象
            criteria.add(Restrictions.eq("cid",1));
            //精确查询
             criteria.add(Restrictions.eq("custName","lucy"));//属性名称，限定条件
            /*
            模糊查询
             criteria.add(Restrictions.like("custName","lu"));
             */
             list = criteria.list();
         ```   
      
    * 排序查询
       
         ```
                //设置对哪个属性进行排序，设置排序规则
               criteria.addOrder(Order.desc("cid"));
               list = criteria.list();
         
        ```
    * 分页查询
       
        ```
            int start = 0;//(当前页-1）*每页记录数
            int count = 3;
            //设置开始位置
            criteria.setFirstResult(start);
            criteria.setMaxResults(count);
            list = criteria.list();
        ```
    
    * 统计查询
       ```
            criteria.setProjection(Projections.rowCount());//统计
            Object obj = criteria.uniqueResult();
       ```   
       
    * 离线查询
       ```
           DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
           Criteria criteria = detachedCriteria.getExecutableCriteria(session);
           criteria.list();
       ```        
           
##### 五、本地sql查询
* SQLQuery对象，使用普通sql实现查询

#### hibernate 多表查询
1. mysql的多表查询
    * 内连接
    ```sql
      SELECT *FROM t_customer c,t_linkman 1 WHERE c.cid=1.clid
      ```
    ```sql
        SELECT *FROM t_customer c INNER  JOIN  t_linkman 1 on c.cid=1.clid
    ```
    * 左外连接
    ```sql
        SELECT *FROM t_customer c left OUTER JOIN t_linkman on c.cid=1.clid
    ```
    
    * 右外连接
    ```sql
       SELECT *FROM t_customer c RIGHT OUTER JOIN t_linkman on c.cid=1.clid
    ```
2. HQL的多表查询
    * 内连接
    
    以客户和联系人为例：
    ```hql
        from Customer c inner join c.managers
    ```
  
    ``` 
     java代码片段：
        Query query = session.createQuery(" from Customer c inner join c.managers);
        List list = query.list();
    ```    
    返回list,list里面每部分是数组形式
    
     * 迫切内连接
        * 底层一样，但是返回list的每部分是对象形式
        * HQL语句：
            ```hql
               from Customer c inner join fetch c.managers
            ```
    
    * 左外连接
        ```hql
        from Customer c left outer join c.managers
        ```
    * 迫切外连接
        * 同迫切内连接
    * 右外连接 
        *   同左外连接
 
#### hibernate 多检索策略
1. 检索策略概念：
    1. 立即查询：根据id查询，调用get方法，一调用get方法马上发送语句查询数据库；
    
        ` Customer  custome = session.get(Customer.class,1);`
    2. 延迟查询：根据id查询，还有load方法，调用load方法不会马上发送语句查询数据，直邮的饿到对象里面的值时候才会发送语句查询数据库。
    
        ` Customer  custome = session.load(Customer.class,2);`
        1. 类级别延迟：
        
            例如：根据id返回实体类对象，调用load方法就不会马上查询，查询结果为实体类对象；
            
            ```
            //根据cid=1,，查询到客户里面所有联系人
            Customer customer = session.get(Customer.class,1);
            //再查询这个客户里面所有联系人
            //直接得到客户里面联系人的set集合
            //得到set集合，没有发送语句
            Set<LinkMan> linkman = customer.getSetLinkMan();
            //发送语句
            System.out.println(linkman.size());
            ```
        2. 关联级别延迟：
            
            例如：查询某个客户，再查询这个客户中所有的联系人，查询客户的所有联系人的过程是否需要延迟，这个过程称为关联级别的延迟
            1. 在映射文件中进行配置实现
                1. 根据客户得到所有联系人，在客户映射文件中配置
            2. 在set标签上使用属性
                 1. fetch：值select（默认）
                 2. lazy：
                 值|描述
                 --|--
                 true|延迟（默认）
                 false|不延迟
                 extra|及其延迟
                                    