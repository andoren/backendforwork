import hu.misi.feladat.core.exceptions.InvalidEmailException;
import hu.misi.feladat.core.exceptions.InvalidPassword;
import hu.misi.feladat.core.exceptions.InvalidRealnameException;
import hu.misi.feladat.core.exceptions.InvalidUsernameException;
import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.daomysql.dao.impl.MysqlDAO;
import org.junit.Test;

public class RandomTest {
    @Test
    public void addUserTest() throws InvalidUsernameException, InvalidRealnameException, InvalidPassword, InvalidEmailException {
        MysqlDAO dao = new MysqlDAO();
        User user = new User();
        user.setUsername("valami");
        user.setEmail("mpekar55@gmail.com");
        user.setPassword("Feladat2020#");
        user.setRealname("Pekár Mihály");
        user.setRole(Role.admin);
        User newuser = dao.addUser(user);
        user.getEmail();
    }
}
