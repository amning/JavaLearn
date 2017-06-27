/**
 * Created by 王宁 on 2017/4/10.
 */
import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // 绝对路径
        File f1 = new File("C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review");
        System.out.println("f1的绝对路径：" + f1.getAbsolutePath());
        // 相对路径,相对于工作目录，如果在eclipse中，就是项目目录
        File f2 = new File("readme.txt");
        System.out.println("f2的绝对路径：" + f2.getAbsolutePath());

        // 把f1作为父目录创建文件对象
        File f3 = new File(f1, "readme.txt");

        System.out.println("f3的绝对路径：" + f3.getAbsolutePath());

    }
}
