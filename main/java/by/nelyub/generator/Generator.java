package by.nelyub.generator;

import by.nelyub.entities.*;

import java.util.Random;
import java.util.Set;

/**
 * Class for generation entities.
 */
public class Generator {
    private static final  String[] firstName = {"Ivan", "Natasha", "Nick", "Henry", "John", "Mary", "Joseph", "Emma",
            "Vittorio", "Jessamine", "Alec", "Abilene", "Sampson", "Isabella", "Darcy", "Emily", "James", "Mariann",
            "Penelope", "Opal", "Mildred", "Celia", "Cora" };
    private static final  String[] lastName = {"Huber", "Bauer", "Wagner", "Pichler", "Moser", "Schuster", "Haas", "Lehner",
            "Koller", "Ebner", "Aigner", "Wallner", "Wolf", "Lechner", "Binder", "Auer", "Baumgartner", "Lang",
            "Brunner", "Egger", "Wimmer", "Schmidt", "Mayr", "Reiter", "Schneider", "Maier", "Schwarz" };
    private static final  String[] positions = {"junior tester", "middle tester", "office manager", "junior developer", "middle developer",
            "senior developer", "director", "project manager" };
    private static final  String[] streets = {"A10 road", "A21 road", "A200 road", "A4 road", "Addington Square", "Beech Street",
            "Boyle Street", "Burlington Gardens", "Camberwell Grove", "Clerkenwell Road", "Clifford Street",
            "Cowcross Street", "Fann Street", "Golden Lane", "Hackney Road", "Hallam Street", "Holborn Circus",
            "Long Lane", "Lower Grosvenor Street", "Monkwell Square", "New Burlington Street", "Northcote Road",
            "Old Burlington Street" };
    private static final  String[] cities = {"Minsk", "London", "New York", "Samarkand", "Aden", "Diriyah", "Omsk", "Salalah",
            "Almaty", "Qyzylorda", "Orenburg", "Semey", "Jerusalem", "Acre", "Jerusalem", "Samaria", "Ecbatana", "Susa",
            "Babylon", "Nineveh", "Calah", "Ashur", "Kandahar" };
    private static final  String[] countries = {"New Zealand", "Netherlands", "Nepal", "Nauru", "Namibia", "Mozambique",
            "Montenegro", "Mauritius", "Marshall", "Malta", "Maldives", "Kuwait", "Kyrgyzstan", "Laos",
            "Latvia", "Lebanon", "Lesotho", "Liberia", "Guatemala", "Guinea", "Guyana", "Haiti", " Honduras",
            "Hungary", "Iceland" };
    private static final String[] companies = {"Gsiw", "Fyew", "Oiew", "Hduiew", "Yuew", "Tiudew", "Tlde", "Biew",
            "Hoew", "Frestion", "Gref", "HPer", "Gire", "Erwq", "Gpro", "Grefot" };

    private static final int MAX_HOUSE = 500;
    private static final int MAX_OFFICE = 1000;
    /**
     * Generates city with current country.
     * @param country cities of which will be generated
     * @return generated city
     */
    public City generateCity(Country country){

        City city = new City();
        Random random = new Random();
        int index = random.nextInt(cities.length);
        city.setName(cities[index]);
        city.setCountry(country);
        return city;
    }

    /**
     * Generates country.
     * @return generated country.
     */
    public Country generateCountry(){
        Country country = new Country();
        Random random = new Random();
        int index = random.nextInt(countries.length);
        country.setName(countries[index]);
        return country;
    }

    /**
     * Generates address with current city.
     * @param city addresses of which will be generated
     * @return generated address
     */
    public Address generateAddress(City city){
        Address address = new Address();
        Random random = new Random();
        int index = random.nextInt(streets.length);
        address.setStreet(streets[index]);
        address.setHouse(random.nextInt(MAX_HOUSE));
        address.setOffice(random.nextInt(MAX_OFFICE));
        address.setCity(city);
        return address;
    }

    /**
     * Generates company with current employees and addresses.
     * @param employeeList employees from this company
     * @param addressList addresses of this company
     * @return generated company
     */
    public Company generateCompany(Set<Employee> employeeList, Set<Address> addressList){
        Company company = new Company();
        Random random = new Random();
        int index = random.nextInt(companies.length);
        company.setName(companies[index]);
        company.setEmployees(employeeList);
        company.setAddresses(addressList);
        return company;
    }

    /**
     * Generates employee with current address.
     * @param address of this employee
     * @return generates employee
     */
    public Employee generateEmployee(Address address){
        Employee employee = new Employee();
        Random random = new Random();
        int index  = random.nextInt(firstName.length);
        employee.setFirstName(firstName[index]);
        index = random.nextInt(lastName.length);
        employee.setLastName(lastName[index]);
        index = random.nextInt(positions.length);
        employee.setPosition(positions[index]);
        employee.setAddress(address);
        return employee;
    }
}
