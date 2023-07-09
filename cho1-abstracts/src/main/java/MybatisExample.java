import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;

public class MybatisExample {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);
        System.out.println("role_name->" + role.getRoleName());
        sqlSession.close();
    }
}
