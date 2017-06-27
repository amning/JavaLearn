package bean;

/**
 * Created by 王宁 on 2017/6/6.
 */
public class Book {
    private String bookName;
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
    public void demobook(){
        System.out.print("this book is "+bookName);
    }

}
