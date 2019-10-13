package itcast.mapper;

import org.apache.ibatis.annotations.Select;

import itcast.domain.Role;
import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{uid}")
    List<Role> findRoleByUid(int uid);
}
