package by.nelyub.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class if entities country
 */

public class Country implements Serializable{
    private long id;
    private String name;
    private Set<City> cities = new HashSet<City>();


    public Country(){}

    public Country(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country(long id, String name, Set<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}