package mapper;

import po.Role;

public interface RoleMapper {
    Role getRole(Long id);

    int insertRole(Role role);

    int deleteRole(Long id);
}
