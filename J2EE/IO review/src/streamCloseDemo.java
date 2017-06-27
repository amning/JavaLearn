import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 王宁 on 2017/4/11.
 */
public class streamCloseDemo {
    public static void main(String[] args){
        File f = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            byte[] buf = new byte[(int)f.length()];
            fis.read(buf);
            for(byte b : buf){
               Byte By =  new Byte(b);
               String s = By.toString();
                System.out.println(By);
                // 在try 里关闭流
                //fis.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //在finally中关闭流
            if(fis!=null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
