package by.nelyub.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class of entities city.
 */

public class City implements Serializable{
    private long id;
    private String name;
    private Country country;
    private Set<Address> addresses = new HashSet<Address>();

    public City(){}

    public City(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(long id, String name, Country country, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.addresses = addresses;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", country=").append(country);
        sb.append('}');
        return sb.toString();
    }
}
