/**
 * Created by 王宁 on 2017/9/4.
 */
public class Stack {
    private int top;
    private int max;
    private int array[];
    public Stack(int max){
        this.max= max;
        array=new int[max];
        top=0;
    }
    public void push(int value){
        if (isFull()){
            System.out.println("this stack is full");
            return;
        }
        array[top++]=value;
    }
    public int pop(){
        return array[--top];
    }
    public boolean isEmpty(){
        if(top == 0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(top == max ){
            return true;
        }
        return false;
    }
}
