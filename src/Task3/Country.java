package Task3;

import Helpers.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {
    private int population;
    private short phoneCode;
    private String name;
    private String continent;
    private String capital;
    private List<String> cities;

    public Country(int population, short phoneCode, String name, String continent, String capital, List<String> cities) {
        this.population = population;
        this.phoneCode = phoneCode;
        this.name = name;
        this.continent = continent;
        this.capital = capital;
        this.cities = cities;
    }

    public Country(int population, short phoneCode, String name, String continent, String capital) {
        this.population = population;
        this.phoneCode = phoneCode;
        this.name = name;
        this.continent = continent;
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public short getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(short phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void fillInfo() {
        Scanner scanner = new Scanner(System.in);
        String inputValue;
        List<String> cities = new ArrayList<String>();

        setName(Helpers.getStringInputByLength("\n Enter country name: ", 5));
        setContinent(Helpers.getStringInputByLength("\n Enter continent: ",6));
        setCapital(Helpers.getStringInputByLength("\n Enter capital: ", 5));

        System.out.println("\n In fields below enter cities names.");
        System.out.println(" If you want to end entering just leave empty field and press \"Enter\"");

        do {
            inputValue = Helpers.getStringInputByLength("\n Enter city: ", 3);
            if(!inputValue.isEmpty()){
                cities.add(inputValue);
                continue;
            }

            setCities(cities);
        }while (!inputValue.isEmpty());

        setPhoneCode(Helpers.getShortIntegerInput("\n Enter phone code: "));

        setPopulation(Helpers.getIntegerInput("\n Enter population: "));
    }

    @Override
    public String toString() {
        return String.format(" Country: %s\n Capital: %s\n Continent: %s\n Cities: %s\n Phone code: %s\n Population: %s\n",
                getName(), getCapital(), getContinent(), String.join(", ", cities), getPhoneCode(), getPopulation());
    }
}
