package itcast.mapper;

import itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Insert("insert into account values (#{id},#{name},#{money})")
    void save(Account account);

    @Select("select * from account")
    List<Account> findAll();

}
