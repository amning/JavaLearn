import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by 王宁 on 2017/5/6.
 */
public class Startup {
    private ArrayList<Goods> goodsList = null;
    private int guessCount = 0;
    private Goods goods=null;
    private boolean isRight=false;
    private void setGoodsList(){
        goodsList = new ArrayList<>();
        goodsList.add(new Goods("电视机",1999f));
        goodsList.add(new Goods("照相机",2999f));
        goodsList.add(new Goods("手机",1888f));
    }

    public void giveGoods(){
        int num = (int)(Math.random()*goodsList.size());
        if(null!=goodsList){

            goods = goodsList.get(num);
            System.out.println("请猜猜"+goods.name+"的价格");
            goodsList.remove(goods);

        }
    }
    public void guess(float price){
        if(price<goods.price){
            System.out.println("再大点");
        } else if (price>goods.price) {
            System.out.println("再小点");
        }else{
            System.out.println("猜对了！");
            System.out.println("恭喜您获得了"+goods.name);
            isRight = true;

        }

    }

    public static void main(String[] args) {
        int count = 5;
        System.out.println("您一共可猜"+count+"次");
        Startup startup = new Startup();
        startup.setGoodsList();
        startup.giveGoods();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i<count;i++){
            startup.guess(scanner.nextFloat());

            if(startup.isRight){
                 startup.giveGoods();
            }
        }

        System.out.println("您的次数已用完，游戏结束！");
    }
}
