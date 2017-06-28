package action.method;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 王宁 on 2017/6/28.
 */
public class BookAction extends ActionSupport{
    public String add(){
        System.out.println("add");
        return "add";
    }
    public String update(){
        System.out.println("update");
        return "update";
    }
}
