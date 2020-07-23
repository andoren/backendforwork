package hu.misi.feladat.core.model;

import hu.misi.feladat.core.exceptions.*;

import java.util.regex.Pattern;

public class User {
    public User() {
    }

    public User(Integer id, String username, String realname, String email,  Role role )throws InvalidUsernameException {
        setId(id);
        setRealname(realname);
        setRole(role);
        setUsername(username);
    }
    public User(Integer id, String username, String password,String realname, String email,  Role role  ) throws InvalidPassword, InvalidUsernameException {
        this(id,username,realname,email,role);
        setPassword(password);

    }

    private Integer id;
    private String password;
    private String realname;
    private Role role;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public void setUsername(String username) throws InvalidUsernameException {
        if(username == null) throw  new InvalidUsernameException("The username cannot be null.");
        else if(username.length() < 5) throw  new InvalidUsernameException("The username must be atleast 5 length long.");
        else if (username.length() >20)throw  new InvalidUsernameException("The username cannot be longer than 20 char.");
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
