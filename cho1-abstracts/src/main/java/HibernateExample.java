import org.hibernate.Session;
import po.Role;

public class HibernateExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Role role = session.get(Role.class, 1L);
        System.out.println("role_name -> " + role.getRoleName());
        session.close();
    }
}
