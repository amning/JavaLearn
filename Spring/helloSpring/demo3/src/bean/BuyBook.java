package bean;
/**
 * Created by 王宁 on 2017/6/7.
 */
import org.aspectj.lang.ProceedingJoinPoint;

public class BuyBook {
    public void before1(){
        System.out.println("add..before1");
    }

    public void after(){
        System.out.println("add..after");
    }
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法之前");
        //执行被增强方法
        proceedingJoinPoint.proceed();
        System.out.println("方法之后");
    }
}
