package charactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 王宁 on 2017/9/20.
 */
public class HasnMap {

    public int random(){
        return ((int) (Math.random()*9000)+1000);
    }
    public List<Hero> findByMap(HashMap<String,List<Hero>> m,String name){
        List<Hero> re = m.get(name);
        return re;
    }
    public List<Hero> findByInteration (List<Hero> h,String name){
        List<Hero> re = new ArrayList<>();
        for(Hero hero: h){
            if(hero.getName().equals(name)){
                re.add(hero);
            }
        }
        return re;
    }

}

