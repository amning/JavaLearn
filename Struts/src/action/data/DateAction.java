package action.data;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.User;

/**
 * Created by 王宁 on 2017/6/29.
 *
 */
public class DateAction extends ActionSupport implements ModelDriven<User>{

    private User user = new User();
    //使用模型驱动获取表单数据
    @Override
    public User getModel() {

        return user;
    }



    /*使用属性封装获取
    //定义变量
    private String username;
    private String password;
    private String email;
    //set与get方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
*/
    @Override
    public String execute() throws Exception {
        System.out.println(user);
        return NONE;
    }


}
