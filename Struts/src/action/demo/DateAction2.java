package action.demo;

import bean.Book;
import com.opensymphony.xwork2.ActionSupport;
import entity.User;

/**
 * Created by 王宁 on 2017/6/29.
 */
public class DateAction2 extends ActionSupport{
    //声明实体类
    private User user;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String execute() throws Exception {
        System.out.println(user);
        System.out.println(book.getBookname());
        return NONE;
    }
}
