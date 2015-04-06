package by.bsu.entities.user;

import by.bsu.entities.user.UserRole;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public class User {
    private String login;
    private String password;
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
