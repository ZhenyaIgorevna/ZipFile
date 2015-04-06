package by.bsu.entities.univer;

import java.io.Serializable;

/**
 * Created by Zhenya on 06.04.2015.
 */
public class Faculty  implements Serializable{
    private int id;
    private String name;
    private University university;

    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty(String name, University university) {
        this.name = name;
        this.university = university;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
