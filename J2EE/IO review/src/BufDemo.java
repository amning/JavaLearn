

/**
 * Created by 王宁 on 2017/4/11.
 *  缓存流buffer
 *  缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。
 *  按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作缓存流在写入数据的时候，
 *  会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。
 *  按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作
 */
import java.io.*;
public class BufDemo {
    public static void main(String [] args){
        //创建文件字符流
        File f = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\1.txt");
        BufDemo f1 = new BufDemo();
        f1.removeComments(f);
    }

    /*
        移除Java文件中的注释(只处理//形式/*形式注释暂不处理)
     */

    public void removeComments(File javaFile ){
        StringBuffer sb = new StringBuffer();
        // 读取内容
        try (FileReader fr = new FileReader(javaFile); BufferedReader br = new BufferedReader(fr)) {
            while (true) {
                String line = br.readLine();
                if (null == line)
                    break;
                // 如果不是以//开头，就保存在StringBuffer中
                if (!line.trim().startsWith("//"))
                {
                    //去掉句末的注释
//                  if(line.contains("//"))
//                  {
//                      int index=line.indexOf("//");
//                      line=line.substring(0, index);
//                      sb.append(line).append("\r\n");
//                      continue;
//                  }
                    sb.append(line).append("\r\n");
                }

            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(javaFile); PrintWriter pw = new PrintWriter(fw);) {
            // 写出内容
            pw.write(sb.toString());
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    /*
    public void bufWrite(File f,String str){
        try(FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            ){

            pw.print(str);

        }catch (IOException e){
                    e.printStackTrace();
        }
    }
    public String bufReadNoComment(File f){
        StringBuffer sb = new StringBuffer();
        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
        ){
            while(true){
                String line  = br.readLine();
                if (line==null){
                    break;
                }if (!line.trim().startsWith("//")){
                    sb.append(line).append("\r\n");
                     String str = sb.toString();
                     return str;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
return  null;
    }
    */
    /*
    buffer方法进行写出
     */
    public void bufWrite(File f){
        try (
                //文件输入流
            FileWriter fw = new FileWriter(f);
            //输入缓冲流
            PrintWriter pw = new PrintWriter(fw);
        )
            //BufferedWriter bw = new BufferedWriter(fw);
        {

            pw.println("garen kill teemo");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*
    buffer方法进行读取
     */
    public void bufRead(File f){
        try
           ( //文件输入流
             FileReader fr = new FileReader(f);
            //输入缓冲流
            BufferedReader br = new BufferedReader(fr);)
            //遍历
            {
            while(true){

                String line = br.readLine();
                if(null==line)
                    break;
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
