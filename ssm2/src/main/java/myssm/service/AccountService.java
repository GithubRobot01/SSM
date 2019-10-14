package myssm.service;


import myssm.domain.Account;

import java.util.List;

/**
 * 业务层操作账户信息
 */
public interface AccountService {
     void save(Account account);
     List<Account> findAll();
}
