package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by 王宁 on 2017/6/6.
 */
public class Person {
    private String name;

    private String [] arrs;
    private List<String> list;
    private Map<String,String> map;
    private Properties properties;
    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }



    public void setName(String name) {
        this.name = name;
    }
    public void test1(){

        System.out.println("arr"+arrs);
        System.out.println("list"+list);
        System.out.println("map"+map);
        System.out.println("properties"+properties);

    }
}
