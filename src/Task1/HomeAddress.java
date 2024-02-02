package Task1;

import Helpers.Helpers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeAddress {
    private String city;
    private String country;
    private String street;
    private short house;
    private short apartment;

    public HomeAddress(String city, String country, String street, short house, short apartment) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
    public HomeAddress(String city, String country, String street, short house) {
        this(city, country, street, house, (short)0);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getHouse() {
        return house;
    }

    public void setHouse(short house) {
        this.house = house;
    }

    public short getApartment() {
        return apartment;
    }

    public void setApartment(short apartment) {
        this.apartment = apartment;
    }

    static public HomeAddress getHomeAddress() {
        String country = Helpers.getStringInputByLength("\n Enter country: ", 4);
        String city = Helpers.getStringInputByLength("\n Enter city: ", 3);
        String street = Helpers.getStringInputByLength("\n Enter street: ", 5);
        short house = Helpers.getShortIntegerInput("\n Enter house: ");
        short apartment = Helpers.getShortIntegerInput("\n Enter apartment: ");

        return new HomeAddress(city, country, street, house, apartment);
    }

    @Override
    public String toString() {
        return String.format("   Country: %s\n   City: %s\n   Street: %s\n   House: %o\n   Apartment: %o\n",
                getCountry(), getCity(), getStreet(), getHouse(), getApartment());
    }
}
