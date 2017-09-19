package inte;

import charactor.Hero;

/**
 * Created by 王宁 on 2017/9/19.
 */
public interface Stack {
    public void push(Hero hero);
    public Hero pull();
    public Hero peek();

}
