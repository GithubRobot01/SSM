package my.mapper;

import my.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {
    /**
     * 添加账户信息
     * @param account
     */
    @Insert("insert into account values(#{id},#{name},#{money})")
    void save(Account account);

    /**
     * 查看所有账户的信息
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();
}
