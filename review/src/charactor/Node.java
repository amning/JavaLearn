package charactor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/9/19.
 *
 * 假设通过二叉树对如下10个随机数进行排序
 67,7,30,73,10,0,78,81,10,74
 排序的第一个步骤是把数据插入到该二叉树中
 插入基本逻辑是，小、相同的放左边，大的放右边
 */
public class Node {
    // 左子节点
    public Node leftNode;
    // 右子节点
    public Node rightNode;
    // 值
    public Object value;
    public void add(Object v){
        if(null==value)
            value=v;
        else {
            if((Integer)v-((Integer)value)<=0){
                if(null==leftNode){
                    leftNode=new Node();
                    leftNode.add(v);
                }
            }else {
                if(null==rightNode){
                    rightNode=new Node();
                    rightNode.add(v);
                }
            }
        }
    }
    public List<Object> values(){
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.values());

        return values;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node r = new Node();
        for(int number:arr){
            r.add(number);
        }
        System.out.println(r.values());
    }
}
