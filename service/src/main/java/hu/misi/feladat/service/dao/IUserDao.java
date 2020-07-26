package hu.misi.feladat.service.dao;

import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;

import java.util.Collection;

public interface IUserDao {
    Collection<User> getAllUsers();
    Collection<User> getUsersByRole(Role role);
    boolean modifyUser(User user);
    User getUserById(int id);
    User addUser(User user);
    boolean deleteUserById(int id);
    boolean logIn(String username,String password);
}
