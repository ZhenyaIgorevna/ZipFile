package by.nelyub.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class if entities company
 */

public class Company implements Serializable {
    private long id;
    private String name;
    private Set<Employee> employees = new HashSet<Employee>();
    private Set<Address> addresses = new HashSet<Address>();

    public Company() {
    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(long id, String name, Set<Employee> employees, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.employees = employees;
        this.addresses = addresses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}