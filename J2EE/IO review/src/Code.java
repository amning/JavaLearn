import java.io.UnsupportedEncodingException;

/**
 * Created by 王宁 on 2017/4/11.
 */
public class Code {
    public static void main(String [] args){
        byte[] bs= new byte[3];
        bs[0]=(byte)0xE5;
        bs[1]=(byte)0xB1;
        bs[2]=(byte)0x8C;
        String str = new String();
        str = toHanzi(bs);
        System.out.println(str);
        String str1= "孙士伟";
        showCode(str1);

      }
    public static String toHanzi(byte[] bs){

        try {
            String str = new String(bs,"UTF-8");
            return str;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }


    public static void showCode(String str){
        String [] encodes= {

                "GBK","GB2312","UTF-8","UTF-16","UTF-32"
        };

        for(String encode:encodes){
            showCode(str,encode);
        }
    }
    public static void showCode(String str,String encode){
        try {
            System.out.printf(" \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }
}
