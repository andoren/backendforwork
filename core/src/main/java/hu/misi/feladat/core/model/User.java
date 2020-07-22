package hu.misi.feladat.core.model;

public class User {
    public User() {
    }

    public User(Integer id, String password, String realname, Role role, String username) {
        this.id = id;
        this.password = password;
        this.realname = realname;
        this.role = role;
        this.username = username;
    }

    private Integer id;
    private String password;
    private String realname;
    private Role role;
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

    public void setPassword(String password) {
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
