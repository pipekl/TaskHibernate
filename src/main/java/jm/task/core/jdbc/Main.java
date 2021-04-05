package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        List<User> users = List.of(
                new User("Vissarion", "Nedopobedimii", (byte) 96),
                new User("Evlampii", "Shac", (byte) 83),
                new User("Klavdiya", "Przhevalskaya", (byte) 91),
                new User("Vladimir", "Tutin", (byte) 101));

        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
        }

        userService.removeUserById(3);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
