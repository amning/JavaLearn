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
    * 查询所有
  ```
  Criteria c = session.creatCriteria(Customer.class);
  List<Customer> list = c.list();
    ```
    * 条件查询
         ```
         Criteria criteria = session.createCriteria(Customer.class);
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
    
    * 投影查询
    * 聚集函数使用
           
        
##### 五、本地sql查询
* SQLQuery对象，使用普通sql实现查询

