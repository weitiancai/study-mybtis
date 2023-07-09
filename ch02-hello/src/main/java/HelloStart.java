import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import po.Role;
import po.SqlSessionFactoryUtil;

public class HelloStart {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            // 新增角色
            roleMapper.insertRole(role);

            roleMapper.deleteRole(2L);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
