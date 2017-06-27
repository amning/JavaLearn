import java.io.*;

/**
 * Created by 王宁 on 2017/4/10.
 * InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
 FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取 */
public class TestStream {
    public static void main(String []args){
        try {
            File f =new File("C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review\\1.txt");
            FileInputStream fs = new FileInputStream(f);
            byte[] buff = new byte[(int)f.length()];

            //读取
            fs.read(buff);
            for(byte b :buff){
                System.out.println(b);
            }
            fs.close();

       }catch (Exception e){
            e.printStackTrace();
        }
        try {
            // 准备文件lol2.txt其中的内容是空的
            File f = new File("C:\\Users\\王宁\\Desktop\\the review of java ee\\IO review\\1.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = {88, 89};

            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
