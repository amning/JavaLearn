import java.io.*;

/**
 * Created by 王宁 on 2017/4/13.
 */
public class copyFile {
    public static void main(String [] args){
        String s1="C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt";
        String s2="C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\2.txt";
        copyFile(s1,s2);
    }
    public static void copyFile(String srcFolder, String destFolder){
        File fsr = new File(srcFolder);
        File fdr = new File(destFolder);
        //建立缓冲区
        byte buf [] = new byte[1024];
        int len = 0;

        try(

                FileInputStream fis= new FileInputStream(fsr);
                FileOutputStream fos = new FileOutputStream(fdr);

        ){

            while((len = fis.read(buf))!=-1){
                fos.write(buf,0,len);
                fos.flush();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

}
