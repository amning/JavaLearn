package bean;

import service.UserService;

import java.util.List;
import java.util.Properties;

/**
 * Created by 王宁 on 2017/6/4.
 */
public class User {

    //给普通字符类型赋值。
    private String username;
    public User() {
    }
    public void add(){
        System.out.println("User...add");
    }
    public String getUsername(){
        System.out.println("username:"+username);
        return username;

    }
    public void setUsername(String username){
        this.username=username;//提供属性的set方法，
        // 然后去属性文件中去配置好让框架能够找到applicationContext.xml文件的bean标签
    }

    //给对象赋值
    private UserService userService;
    public UserService getUserService(){
        return userService;
    }
    public void setUserService(UserService userService){
        this.userService=userService;
    }

    //给list集合赋值
    private List<String> userNames;
    public List<String> getUserNames(){
        return userNames;
    }
    public void setUserNames(List<String> userNames){
        this.userNames=userNames;
    }

    //给属性文件中的字段赋值
    private Properties props;
    public Properties getProps(){
        return props;
    }
    public void setProps(Properties props){
        this.props = props;
    }


   /*
   //构造方法注入--一个参数
    private String userCode;
   public User(String userCode){
        this.userCode=userCode;
    }  */
    //构造方法注入--两个参数
   private String userCode;
   private int id;
   public User(String userCode,int id){
        this.userCode=userCode;
        this.id=id;
    }


    public String login() throws Exception{
       if("admin".equals(username)){
           return "success";
       }else {
           return "error";
       }
    }


}
