package main.test;

import java.util.HashSet;

/**
 * Created by 王宁 on 2017/9/20.
 * 创建一个长度是100的字符串数组
 使用长度是2的随机字符填充该字符串数组
 统计这个字符串数组里重复的字符串有多少种
 *
 *
 */
public class TestHashSet {

    public static void main(String[] args) {
        String [] ss=new String[100];
        for(int i=0;i<ss.length;i++){
            ss[i]=randomString(2);
        }
        for(int i=0;i<ss.length;i++){
            System.out.println(ss[i]+" ");
            if(19==i%20)
                System.out.println();
        }
        HashSet<String> result = new HashSet<>();

        for(String s1:ss){
            int repeat=0;
            for(String s2:ss){
                if(s1.equalsIgnoreCase(s2)){
                    repeat++;
                    if (2==repeat){
                        result.add(s2);
                        break;
                    }
                }
            }
        }
        System.out.println(result.size());
        if(result.size()!=0){
            for (String s:result){
                System.out.print(s+" ");
            }
        }
    }

    public static  String randomString(int n){
        String pool="";
        for(short i='0';i<='9';i++){
            pool+=(char)i;
        }
        for(short i='a';i<='z';i++){
            pool+=(char)i;
        }
        for(short i='A';i<='Z';i++){
            pool+=(char)i;
        }
        char cs[] = new char[n];
        for(int i=0;i<cs.length;i++){
            int index= (int) (Math.random()*pool.length());
            cs[i]=pool.charAt(index);
        }
        String result=new String(cs);
        return result;
    }
}
