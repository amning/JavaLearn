package entity;

/**
 * Created by 王宁 on 2017/5/1.
 */
public class Config {
   //配置信息Config类与配置信息表 config相对应
    public int id;
    public String key;
    public String value;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
