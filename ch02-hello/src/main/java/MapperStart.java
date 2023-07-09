import mapper.RoleMapper;
import po.Role;

public class MapperStart {

    public static void main(String[] args) {
        showXml();
//        showAnno();
    }

    private static void showAnno(){
        RoleMapper roleMapper = MybatisUtil.getSqlSessionFactoryByConf().openSession().getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);

        System.out.println(role.getRoleName());
    }

    private static void showXml(){
        RoleMapper roleMapper = MybatisUtil.getSqlSessionFactory().openSession().getMapper(RoleMapper.class);
        // 没有记录会报错
        Role role = roleMapper.getRole(2L);

        System.out.println(role.getRoleName());

    }
}
