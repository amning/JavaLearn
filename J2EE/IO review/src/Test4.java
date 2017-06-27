import java.io.File;

/**
 * Created by 王宁 on 2017/4/10.
 * 遍历这个目录下所有的文件(不用遍历子目录)

 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

 */
public class Test4 {
    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File minFile = null;
    static File maxFile = null;

    //使用递归来遍历一个文件夹的子文件
    public static void listFiles(File file){
        if(file.isFile()){
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0 && file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }

        }

        if(file.isDirectory()){
            File[] fs = file.listFiles();
            if (null==fs) {
                return;
            }
            for (File f : fs) {
                listFiles(f);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("d:\\");
        listFiles(f);
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());

    }
}
