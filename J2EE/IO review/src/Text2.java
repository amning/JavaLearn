import java.io.File;
import java.util.Date;

/**
 * Created by 王宁 on 2017/4/10.
 */
public class Text2 {
    public static void main(String []args){
        File f4 =new File("C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review\\readme.txt");
        System.out.println("是否存在"+f4.exists());//判断是否存在
        System.out.println("是否为文件夹"+f4.isDirectory());//判断是否为文件夹
        System.out.println("是否文件"+f4.isFile());//判断是否是文件
        System.out.println("文件长度"+f4.length());//获取文件长度

        long time = f4.lastModified();
        Date d =new Date(time);

        System.out.println("文件最后修改时间："+d);
        f4.setLastModified(0);
        //文件重命名
        File f5 = new File("C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review\\1.txt");
        f4.renameTo(f5);
    }
}
