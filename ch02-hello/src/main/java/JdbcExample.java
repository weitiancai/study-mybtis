import com.mysql.cj.log.Log;
import po.Role;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcExample {
    public static void main(String[] args) {
        JdbcExample example = new JdbcExample();
        Role role = example.getRole(3L);
        System.out.println("role_note -> " + role.getNote());
    }

    private Role getRole(long id) {
        Connection connection = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select id,role_name,note from t_role where id = ?");
            ps.setLong(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long roleId = rs.getLong("id");
                String roleName = rs.getString("role_name");
                String note = rs.getString("note");
                Role role = new Role();
                role.setId(roleId);
                role.setRoleName(roleName);
                role.setNote(note);
                return role;
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
            this.close(rs, ps, connection);
        }
        return null;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybatis1?characterEncoding=utf8";
            String user = "root";
            String password = "Wm123456";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException exception) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, exception);
        }
        return connection;
    }

    private void close(ResultSet rs, Statement stmt, Connection connection) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            if (stmt != null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        }
    }

}
