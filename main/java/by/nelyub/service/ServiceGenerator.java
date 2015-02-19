package by.nelyub.service;

import by.nelyub.entities.*;
import by.nelyub.generator.Generator;

import java.util.*;

/**
 * Class for generation lists of entities.
 */
public class ServiceGenerator {
    private Generator generator = new Generator();
    private static final int COLLECTION_MAX_SIZE = 8;
    private static final int TABLE_SIZE = 10_000;

    /**
     * Generates list of countries.
     *
     * @return generated list of countries.
     */
    public List<Country> generateCountries() {
        List<Country> countries = new ArrayList<Country>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            Country country = generator.generateCountry();
            countries.add(country);
        }
        return countries;
    }

    /**
     * Generates list of cities.
     *
     * @param countries which contains  generated cities
     * @return generated list of cities.
     */
    public List<City> generateCities(List<Country> countries) {
        ArrayList<City> cities = new ArrayList<City>();
        Random random = new Random();
        for (int i = 0; i < TABLE_SIZE; i++) {
            Country country = countries.get(random.nextInt(countries.size()));
            City city = generator.generateCity(country);
            cities.add(city);
        }
        return cities;

    }

    /**
     * Generates list of addresses.
     *
     * @param cities which contains generated addresses
     * @return generated list of addresses
     */
    public List<Address> generateAddresses(List<City> cities) {
        ArrayList<Address> addresses = new ArrayList<Address>();
        Random random = new Random();
        for (int i = 0; i < TABLE_SIZE; i++) {
            City city = cities.get(random.nextInt(cities.size()));
            Address address = generator.generateAddress(city);
            addresses.add(address);
        }
        return addresses;
    }

    /**
     * Generates list of employees.
     *
     * @param addresses which contains generated employees
     * @return generated list of employees
     */
    public List<Employee> generateEmployees(List<Address> addresses) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Collections.shuffle(addresses);
        for (int i = 0; i < TABLE_SIZE; i++) {
            Employee employee = generator.generateEmployee(addresses.get(i));
            employees.add(employee);
        }
        return employees;
    }

    /**
     * Generates list of companies
     *
     * @param employees which works in  generated companies
     * @param addresses which contains in  generated companies
     * @return generated list of companies
     */
    public List<Company> generateCompanies(List<Employee> employees, List<Address> addresses) {
        //
        ArrayList<Company> companies = new ArrayList<Company>();
        for (int i = 0; i < TABLE_SIZE; i++) {

            List<Employee> subListEmployees = generateSubList(employees, COLLECTION_MAX_SIZE);
            List<Address> subListAddresses = generateSubList(addresses, subListEmployees.size());
            Company company = generator.generateCompany(new HashSet<Employee>(subListEmployees),
                    new HashSet<Address>(subListAddresses));
            companies.add(company);
        }
        return companies;
    }

    /**
     * Generates sublist of given list
     * @param list from which will be create sublist
     * @return generates sublist
     */
    private <T> List<T> generateSubList(List<T> list, int size){
        Random random = new Random();
        int start = random.nextInt(list.size() - size);
        int end = random.nextInt(size) + start;
        List<T> subList = list.subList(start,end);
        if(subList.isEmpty()){
            subList.add(list.get(random.nextInt(list.size())));
        }
        return subList;
    }
}
