package itcast.service;

import itcast.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
