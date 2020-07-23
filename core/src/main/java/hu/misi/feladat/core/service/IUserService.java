package hu.misi.feladat.core.service;

import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;

import java.util.Collection;

public interface IUserService {
    Collection<User> getAllUsers();
    Collection<User> getUsersByRole(Role role);
    boolean ModifyUser(User user);
    User AddUser(User user);
    boolean DeleteUser(User user);
}
