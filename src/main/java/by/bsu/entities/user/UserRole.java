package by.bsu.entities.user;

/**
 * Created by Yauheniya_Neliub on 2/24/2015.
 */
public enum UserRole {
    ADMIN("admin"),
    STUDENT("student"),
    TEACHER("teacher");

    private String value;

    UserRole(){}

    UserRole(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
