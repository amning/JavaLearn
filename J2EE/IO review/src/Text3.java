import java.io.File;
import java.io.IOException;

/**
 * Created by 王宁 on 2017/4/10.
 */
public class Text3 {
    public static void main(String [] args) throws IOException{
        File f = new File( "C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review\\1.txt");
       System.out.print( f.list());//返回当前文件夹下的所有文件（不包含子文件夹），返回值为字符串数组
        File[] fs = f.listFiles();//返回当前文件夹下的所有文件（不包含子文件夹），返回值文件数组
        f.getParent();//获取文件所在文件夹 return 字符串
        f.getParentFile();//获取文件所在文件夹，return 文件
        f.mkdir();//创建文件夹，如果父文件夹不存在，创建无效
        f.mkdirs();//创建文件夹，如果父文件夹不存在，创建父目录
        f.createNewFile();//创建一个空文件，如果父文件夹不存在，就会抛出异常
        f.getParentFile().mkdirs();//创建一个空文件之前，通常会创建父目录
        System.out.print(f.listRoots());//列出盘符
      //  f.delete();//删除文件
        f.deleteOnExit();//JVM结束时，删除文件，常用于临时文件的删除
    }
}
