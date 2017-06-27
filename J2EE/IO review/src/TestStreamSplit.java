/**
 * Created by 王宁 on 2017/4/10.
 * 找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
 比如文件 eclipse.exe，大小是309k。
 拆分之后，成为
 eclipse.exe-0
 eclipse.exe-1
 eclipse.exe-2
 eclipse.exe-3
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//TODO 未分析
public class TestStreamSplit {
    public static void split(String src,int fileSize,String dest) throws FileNotFoundException{
        if("".equals(src)||src==null||fileSize==0||"".equals(dest)||dest==null){
            System.out.println("分割失败");
        }
        File srcFile = new File(src);
        long srcSize = srcFile.length();
        long destSize = fileSize*1024;
        int num = (int)(srcSize/destSize);
        num = srcSize%destSize == 0?num:num+1;
        String fileName = src.substring(src.lastIndexOf("\\"));
        InputStream in = null;
        byte[] bytes = new byte[1024];
        int len = -1;
        try{
            in = new FileInputStream(srcFile);
            for(int i =0;i<num;i++){
                String destName = dest + File.separator + fileName +"-" + i;
                OutputStream out = new FileOutputStream(destName);



                int count = 0;
                while((len = in.read(bytes))!=-1){
                    out.write(bytes, 0, len);
                    count+=len;
                    if(count>=destSize){
                        break;
                    }
                }
                out.flush();
                out.close();

            }
        }catch(IOException e){
            e.printStackTrace();

        }




    }

    public static void merge(String destPath,File[] srcPaths){


        if(destPath==null||"".equals(destPath)||srcPaths==null){
            System.out.println("合并失败");
        }
        for (File string : srcPaths) {
            if(string==null)
                System.out.println("合并失败");
        }


        //String name = srcPaths[0].substring(srcPaths[0].lastIndexOf("\\"));
        //String destName = name.substring(0, name.lastIndexOf("-"));
        String name = srcPaths[0].getName();
        String destName = name.substring(0, name.lastIndexOf("-"));
        destPath = destPath+destName;//合并后的文件路径
        File destFile = new File(destPath);
        OutputStream out = null;

        try{
            out = new FileOutputStream(destFile);
            for(int i=0;i < srcPaths.length;i++){
                File srcFile = srcPaths[i];
                InputStream in = new FileInputStream(srcFile);
                byte[] bytes = new byte[1024];
                int len = -1;

                while((len = in.read(bytes))!=-1){
                    out.write(bytes,0,len);
                    out.flush();
                }
                in.close();
            }
            out.close();

        }catch (IOException e) {
            e.printStackTrace();
        }finally{

        }

    }






    public static void main(String[] args) {


        String destPath = "D:\\temp\\temp\\";

        String destPath1 = "D:\\temp";
        File[] srcPaths = new File(destPath1).listFiles();

        System.out.println("开始合并。。。");
        merge(destPath, srcPaths);
        System.out.println("合并结束");
    }




}