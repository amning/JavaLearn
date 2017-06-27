import java.io.*;
import java.util.Scanner;

/**
 * Created by 王宁 on 2017/4/13.
 *  System.out 是常用的在控制台输出数据的
    System.in 可以从控制台输入数据
    使用System.in.read虽然可以读取数据，但是很不方便
    使用Scanner就可以逐行读取了
 */
public class SystemIn {
    public static void main(String [] args) {
        //从键盘获取输入
        Scanner s =new Scanner(System.in);
        System.out.println("请输入类的名称：");
        String classname = s.nextLine();
        classname = toUpperFistLetter(classname);
        System.out.println("请输入类的属性");
        String type = s.nextLine();
        System.out.println("请输入属性的名称");
        String propertyName = s.nextLine();
        String Uproperty = toUpperFistLetter(propertyName);
        File f = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");
        String FileRead = null;
       //读取模板文件
        try (
                //创建文件读取
                FileReader fr = new FileReader(f);
        ) {
            char cs[] = new char[(int) f.length()];
            fr.read(cs);
            FileRead = new String(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //替换
        String fc = FileRead.replaceAll("@class@",classname);

        fc = fc.replaceAll("@type@",type);
        fc = fc.replaceAll("@property@",propertyName);
       // fc = fc.replaceAll("@Uproperty@",Uproperty);
        String fileName = classname+".java";

        File file = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\ct.java");

        //替换后的内容
        System.out.println("替换后的内容：");
        System.out.println(fc);

        try(
                FileWriter fw = new FileWriter(file);

                ){
            fw.write(fc);

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("文件保存在"+file.getAbsolutePath());

    }

    private static String toUpperFistLetter(String propertyName) {
        char upperCaseFirst = Character.toUpperCase(propertyName.charAt(0));
        String rest = propertyName.substring(1);
        return upperCaseFirst+rest;
    }


    public void systemIN(){
        try (InputStream is = System.in;) {
            while (true) {
                int i = is.read();
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void systemScan(){
        Scanner s =new Scanner(System.in);
        while(true){
            String line = s.nextLine();
            System.out.println(line);
        }
    }
}
