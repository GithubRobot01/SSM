package myssm.service.impl;


import myssm.domain.Account;
import myssm.mapper.AccountMapper;
import myssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
        accountMapper.save(account);
    }

    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
