package hu.misi.feladat.service.impl;

import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.core.service.IUserService;
import hu.misi.feladat.service.dao.UserDao;

import java.util.Collection;

public class UserService implements IUserService {
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    private UserDao dao;

    public Collection<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public Collection<User> getUsersByRole(Role role) {
        return dao.getUsersByRole(role);
    }

    public boolean modifyUser(User user) {
        return dao.modifyUser(user);
    }

    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    public User addUser(User user) {
        return dao.addUser(user);
    }

    public boolean deleteUserById(int id) {
        return dao.deleteUserById(id);
    }
}
