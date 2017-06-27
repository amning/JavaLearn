package spring.maven.demo.helloword;

/**
 * Created by 王宁 on 2017/6/2.
 */
public class HelloWorld {
    public String name;
    public void setName(String n){
        this.name=n;
    }
    public void sop(){
        System.out.println("The first Spring 3:hello"+name);
    }
}
