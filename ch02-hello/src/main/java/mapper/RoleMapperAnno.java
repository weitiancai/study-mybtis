package mapper;

import org.apache.ibatis.annotations.Select;
import po.Role;

public interface RoleMapperAnno {
    @Select(value = "select id,role_name as roleName, note from t_role where id = #{id}")
    Role getRole(Long id);
}
