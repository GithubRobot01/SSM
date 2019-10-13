package itheima.service.impl;

import itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itheima.service.AccountService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional
@EnableTransactionManagement
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    /*public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    //@Transactional(readOnly = false)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i=1/0;
        accountDao.in(inMan,money);
    }
}
