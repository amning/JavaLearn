package test;

import com.album.dao.UserDao;
import com.album.domain.User;
import junit.framework.TestCase;

/**
 * Created by 王宁 on 2017/6/12.
 */

public class Test extends TestCase {

    public void testDemo(){
        UserDao dao = new UserDao();
      dao.delById(1);
}
}
