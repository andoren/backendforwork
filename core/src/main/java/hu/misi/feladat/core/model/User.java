package hu.misi.feladat.core.model;

import hu.misi.feladat.core.exceptions.*;

import java.util.regex.Pattern;

public class User {
    public User() {
    }

    public User(Integer id, String username, String realname, String email,  Role role ) {
        setId(id);
        setRealname(realname);
        setRole(role);
        setUsername(username);
    }
    public User(Integer id, String username, String password,String realname, String email,  Role role  ) throws InvalidPassword {
        this(id,username,realname,email,role);
        setPassword(password);

    }

    private Integer id;
    private String password;
    private String realname;
    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPassword {
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}";
        Pattern pattern = Pattern.compile(regex);
        boolean isMatched = Pattern.matches(regex, password);
        if (!isMatched) throw new InvalidPassword("The password must contains atleast one lower case letter, one Upper case letter, a special char, no whitespace allowed, and must be at least 6 char long and max 20 .");
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
