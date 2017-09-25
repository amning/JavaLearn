package main;



import java.util.*;


public class Main {


    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String str = sc.next();
        check(str);
       String str1=check(str);
        System.out.println(str1);
        String str2 = check1(str);
        System.out.println(str2);*/
        int a=1;
        int b=13;
        do{
           b-=a;
           a++;
        }while (--b>=0);
        System.out.println(b);
    }
    public static void test(){

    }
    public static String check1(String str){
        Set<String> mLinkedSet = new LinkedHashSet<String>();
        String[] strArray = str.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strArray.length; i++)
        {
            if (!mLinkedSet.contains(strArray[i]))
            {
                mLinkedSet.add(strArray[i]);
                sb.append(strArray[i] + " ");
            }else{
                System.out.println("重复字符:"+strArray[i]);
            }
        }
//        System.out.println(mLinkedSet);
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
    public static String check(String s){
       // String str="01211113477440000447756677899123";
        StringBuffer sb=new StringBuffer();
        int len=s.length();
        int i=0;
        boolean flag=false;
        for(i=0; i<len;i++){
            char c=s.charAt(i);
            if(s.indexOf(c)!=s.lastIndexOf(c)){
                flag=false;
            }else{
                flag=true;
            }
            if(i==s.indexOf(c))
                flag=true;
            if(flag){
                sb.append(c);
            }
        }
       // System.out.print(sb.toString());

        return sb.toString();

    }
}
