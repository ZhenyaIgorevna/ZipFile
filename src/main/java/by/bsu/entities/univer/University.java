package by.bsu.entities.univer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhenya on 06.04.2015.
 */
public class University implements Serializable{
    private int id;
    private String name;
    private Set<Faculty> faculties = new HashSet<Faculty>();

    public University(){}

    public University(String name) {
        this.name = name;
    }

    public University(String name, Set<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
