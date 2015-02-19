package by.nelyub.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class of entities address.
 */
public class Address implements Serializable {
    private long id;
    private String street;
    private int house;
    private int office;
    private City city;
    private Set<Company> companies = new HashSet<Company>();
    private Set<Employee> employees = new HashSet<Employee>();

    public Address() {}

    public Address(long id, String street, int house, int office) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.office = office;
    }

    public Address(long id, String street, int house, int office,City city, Set<Company> companies, Set<Employee> employees) {
        this.id = id;
        this.street = street;
        this.house = house;
        this.office = office;
        this.city = city;
        this.companies = companies;
        this.employees = employees;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public int getHouse(){
        return house;
    }

    public void setHouse(int house){
        this.house = house;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(city.getCountry().getName()).append(", ").append(city.getName());
        sb.append(", ").append(street);
        sb.append(", ").append(house);
        sb.append(" - ").append(office);
        return sb.toString();
    }
}
