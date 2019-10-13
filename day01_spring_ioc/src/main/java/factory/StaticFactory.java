package factory;

import itheima.dao.USerDao;
import itheima.dao.impl.UserDaoImpl;

public class StaticFactory  {
    public static USerDao getUserDao(){
        return new UserDaoImpl();
    }
}
