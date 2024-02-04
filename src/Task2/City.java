package Task2;

import Helpers.Helpers;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class City {
    private int population;
    private int postcode;
    private short phoneCode;
    private String name;
    private String region;
    private String country;

    public City(int population, int postcode, String name, String region, String country, short phoneCode) {
        this.population = population;
        this.postcode = postcode;
        this.name = name;
        this.region = region;
        this.country = country;
        this.phoneCode = phoneCode;
    }
    public City(){
        this(0, (short) 0, null, null, null, (short) 0);
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(short phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void fillInfo() {
        setName(Helpers.getStringInputByLength("\n Enter city name: ", 3));
        setCountry(Helpers.getStringInputByLength("\n Enter country: ", 5));
        setRegion(Helpers.getStringInputByLength("\n Enter region: ", 5));

        setPhoneCode(Helpers.getShortIntegerInput("\n Enter phone code: "));

        setPostcode(Helpers.getIntegerInput("\n Enter postcode: "));
        setPopulation(Helpers.getIntegerInput("\n Enter population: "));
    }

    @Override
    public String toString() {
        return String.format(" City: %s\n Region: %s\n Country: %s\n Phone code: %02d\n Postcode: %s\n Population: %s\n",
                getName(),
                getRegion(),
                getCountry(),
                getPhoneCode(),
                getPostcode(),
                getPopulation());
    }
}
