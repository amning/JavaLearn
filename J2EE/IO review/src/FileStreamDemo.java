import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 王宁 on 2017/4/11.
 * FileReader 是Reader子类，以FileReader 为例进行文件读取
 * FileWriter 是Writer的子类，以FileWriter 为例把字符串写入到文件
 */
public class FileStreamDemo {
    public static void main(String [] args){
        FileStreamDemo demo = new FileStreamDemo();
       demo.write("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");
        demo.read("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");
    }
    public  void write(String dir){
        File f = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(f);
            String data = "aa";
            char [] cs = data.toCharArray();
            fw.write(cs);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void read(String dir){
        File f = new File(dir);
        FileReader fr  = null;
        try{

            fr = new FileReader(f);
            char[] buf = new char[(int)f.length()];
            fr.read(buf);
            for(char c : buf){
                System.out.println(c);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try{
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
