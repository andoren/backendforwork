import hu.misi.feladat.core.exceptions.InvalidEmailException;
import hu.misi.feladat.core.exceptions.InvalidPassword;
import hu.misi.feladat.core.exceptions.InvalidRealnameException;
import hu.misi.feladat.core.exceptions.InvalidUsernameException;
import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.daomysql.dao.impl.MysqlUserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class RandomTest {
    private MysqlUserDAO dao;
    @Before
    public void init(){
         dao= new MysqlUserDAO();
    }
    //@Test
    public void addUserTest() throws InvalidUsernameException, InvalidRealnameException, InvalidPassword, InvalidEmailException {

        User user = new User();
        user.setUsername("valami2");
        user.setEmail("mpekar55@gmail.com");
        user.setPassword("Feladat2020#");
        user.setRealname("Pekár Mihály");
        user.setRole(Role.admin);
        User newuser = dao.addUser(user);

    }
    @Test
    public void getUserTest(){
        User user = dao.getUserById(1);
        System.out.println(user.getUsername());
    }
    @Test
    public void ModifyUser() throws InvalidEmailException {
        User user = dao.getUserById(1);
        user.setEmail("mpekar5@gmail.com");
        boolean result = dao.modifyUser(user);
        Assert.assertTrue(result);
    }
    //@Test
    public void deleteUser(){
        boolean result = dao.deleteUserById(4);
        Assert.assertTrue(result);
    }
    @Test
    public void getUsers(){
        Collection<User> users = dao.getAllUsers();
        for (User user:users
                ) {
            System.out.println(user.getRole().name());
        }
    }
    @Test
    public void getUsersByRole(){
        Collection<User> users = dao.getUsersByRole(Role.user);
        for (User user:users
             ) {
            System.out.println(user.getUsername());
        }

    }
    @Test
    public void logIn(){
        boolean success = dao.logIn("valami2","sdadasd#");
        System.out.println(success);
    }
}
