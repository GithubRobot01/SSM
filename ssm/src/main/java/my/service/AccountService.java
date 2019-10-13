package my.service;

import my.domain.Account;

import java.util.List;

/**
 * 业务层操作账户信息
 */
public interface AccountService {
    /**
     * 添加账户信息
     * @param account
     */
    void save(Account account);

    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();
}
