package hu.misi.feladat.service.impl;
import hu.misi.feladat.core.exceptions.InvalidEmailException;
import hu.misi.feladat.core.exceptions.InvalidPassword;
import hu.misi.feladat.core.exceptions.InvalidRealnameException;
import hu.misi.feladat.core.exceptions.InvalidUsernameException;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.service.dao.UserDao;
import hu.misi.feladat.service.impl.UserService;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.*;
import hu.misi.feladat.core.model.Role;
import org.junit.matchers.JUnitMatchers;

import java.util.Arrays;
import java.util.Collection;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.same;
public class UserServiceTest {
    @Mock
    private UserDao dao;
    @TestSubject
    private UserService service;

    Collection<User> dummyDB;
    User exceptionUser;
    User goodUser;
    User userWithoutAnything;
    @Before
    public void init() throws InvalidUsernameException, InvalidEmailException, InvalidPassword, InvalidRealnameException {
        dao = EasyMock.niceMock(UserDao.class);
        this.service = new UserService(dao);
        exceptionUser = new User(10,"hibasuser","Hibás#2User","hibA 2020","hiba@gmail.com", Role.admin);
        goodUser = new User(10,"gooduser","Good2User#","hibA 2020","hiba@gmail.com", Role.admin);
        userWithoutAnything = new User();
        dummyDB = Arrays.asList(new User(1,"meoww","A1234a#","Meow Meow","mewo@gmail.com",Role.admin),
                new User(2,"wooff","A1234a#","Meow Woof","woof@gmail.com",Role.user),
                new User(3,"meoww","A1234a#","Meow Meow","mewo@gmail.com",Role.user),
                new User(4,"meoww","A1234a#","Meow Meow","mewo@gmail.com",Role.admin),
                new User(5,"wooff","A1234a#","Meowasd Meow","mewo223@gmail.com",Role.user)
                );
        EasyMock.expect(dao.getAllUsers()).andReturn(dummyDB).anyTimes();
        EasyMock.expect(dao.getUsersByRole(Role.user)).andReturn(Arrays.asList(new User(5,"wooff","A1234a#","Meowasd Meow","mewo223@gmail.com",Role.user),
                new User(3,"meoww","A1234a#","Meow Meow","mewo@gmail.com",Role.user),
                        new User(5,"wooff","A1234a#","Meowasd Meow","mewo223@gmail.com",Role.user))).anyTimes();
        EasyMock.expect(dao.addUser(same(userWithoutAnything))).andReturn(goodUser).anyTimes();
        EasyMock.expect(dao.deleteUserById(1)).andReturn(true).anyTimes();
        EasyMock.expect(dao.modifyUser(same(goodUser))).andReturn(true).anyTimes();
        EasyMock.expect(dao.getUserById(1)).andReturn(goodUser).anyTimes();
        EasyMock.replay(dao);
    }
    @Test
    public void getAllUser(){
        Collection<User> users = service.getAllUsers();
        Assert.assertEquals(dummyDB.size(),users.size());
    }
    @Test
    public void getAllNonAdminUser(){
        Collection<User> users = service.getUsersByRole(Role.user);
        Assert.assertEquals(3,users.size());
    }
    @Test
    public void addUser(){
        User user = service.addUser(userWithoutAnything);
        Assert.assertEquals(goodUser,user);
    }
    @Test
    public void deleteUser(){
        boolean result = service.deleteUserById(1);
        Assert.assertEquals(true,result);
    }
    @Test
    public void modifyUser(){
        boolean result = service.modifyUser(goodUser);
        Assert.assertEquals(true,result);
    }
    @Test
    public void getUserById(){
        User user = service.getUserById(1);
        Assert.assertEquals(user,goodUser);
    }

}

