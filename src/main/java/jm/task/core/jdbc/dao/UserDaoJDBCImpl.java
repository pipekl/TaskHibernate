package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util util = new Util();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS pensionniiFond (id bigint primary key auto_increment, name varchar(100), lastName varchar(100), age tinyint);";
        util.connect(sql);
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS pensionniiFond";
        util.connect(sql);
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT pensionniiFond (name, lastName, age) VALUES ('"
                + name + "', '" + lastName + "', " + age + " );";
        util.connect(sql);
        System.out.println("User с именем – " + name + " добавлен в базу данных pensionniiFond");
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM pensionniiFond WHERE id = " + id;
        util.connect(sql);
    }

    public List<User> getAllUsers() {
        return util.connectShow();
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE pensionniiFond";
        util.connect(sql);
    }
}
