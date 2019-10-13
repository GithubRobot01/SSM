package factory;

import itheima.dao.USerDao;
import itheima.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public USerDao getUserDao(){
        return new UserDaoImpl();
    }
}
