import java.io.*;

/**
 * Created by 王宁 on 2017/4/12.
 * 对象流练习
 * 对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘
 * 一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口
 *
 */
//1、首先去创建一个hero类 使其实现Serializable接口
//2、创建对象输出流
public class objectBufferedDemo {
    public static  void main(String [] args){
        //Hero h = new Hero();
       // h.name  ="g";
       // h.hp=312;
        File f = new File("C:\\Users\\王宁\\Desktop\\javaReview\\IO review\\2.txt");
        //创建hArr数组
        Hero[] hArr = new Hero[10];
        objectBufferedDemo obd = new objectBufferedDemo();
        obd.objectBuf(hArr,f);
    }
    /*
    准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
    然后把该数组序列化到一个文件heros.lol
    接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
     */
   public void objectBuf(Hero[] hArr, File f ){
        //对数组进行遍历赋值
        for(int i = 0;i<hArr.length;i++){

            hArr[i]=new Hero("hero："+i);
        }
            try (
                    //创建对象输出流
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream ops =new ObjectOutputStream(fos);
                    //创建对象输入流
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ips = new ObjectInputStream(fis);

            ){
                ops.writeObject(hArr);

                Hero[] h2Arr =(Hero[]) ips.readObject();
               for(int j = 0;j<h2Arr.length;j++){
                   System.out.println(h2Arr[j].name);
                }


            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }


    /*
    创建一个Hero对象，设置其名称为garen。
    把该对象序列化到一个文件garen.lol。
    然后再通过序列化把该文件转换为一个Hero对象
    注：把一个对象实例化有一个前提类，这个对象的类，必须实现了Serializable接口
     */
    public void objectBuf(Hero h, File f ){
        try (
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream ops =new ObjectOutputStream(fos);
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ips = new ObjectInputStream(fis);

        ){
            ops.writeObject(h);

            Hero h2 =(Hero) ips.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);


        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
