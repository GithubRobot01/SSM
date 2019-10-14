package itcast.mapper;

import itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    @Options(useGeneratedKeys =true,keyColumn = "id")
    void addUser(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=${value}")
    void delUser(int id);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    column = "id",
                    property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "myssm.OrderMapper.findById")
            )
    })
    List<User> findUserAndOrder();


    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    column = "id",
                    property = "roleList",
                    javaType = List.class,
                    many=@Many(select = "myssm.RoleMapper.findRoleByUid")
            )
    })
    List<User> findUserAndRole();

}
