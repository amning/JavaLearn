/**
 * Created by 王宁 on 2017/9/4.
 */
public class Queue {
    private int[] array;
    private int front;
    private int end;
    private int number;
    private int max;
    private Queue(int maxsize){
        array= new int[maxsize];
        max=maxsize;
        front=0;
        end=0;
        number=0;
    }
    private void insert(int item){
        if(isFull()){
            System.out.println("this Queue is full ");
            return;
        }
        array[end++]=item;
        number++;
    }
    private int remove(){
        if(isEmpty()){
            System.out.println("this queue is empty");
            return -1;
        }
        number--;
        return array[front++];
    }
    private int peekFront(){
        return array[front];
    }
    public boolean isFull(){
        return end == max;
    }
    private boolean isEmpty(){
        return (front==0&&end==0)||front==max;
    }

    private int size(){
        return end-front;
    }
}
