package Task1;

import Helpers.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Human {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phoneNumber;
    private HomeAddress homeAddress;

    public Human(Date birthDate, String firstName, String lastName, String patronymic, String phoneNumber, HomeAddress homeAddress) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }
    public Human(Date birthDate, String firstName, String lastName, String patronymic, String phoneNumber) {
        this(birthDate, firstName, lastName, patronymic, phoneNumber, null);
    }
    public Human(Date birthDate, String firstName, String lastName, String patronymic) {
        this(birthDate, firstName, lastName, patronymic, null);
    }
    public Human(Date birthDate, String firstName, String lastName) {
        this(birthDate, firstName, lastName, null);
    }
    public Human(String firstName, String lastName, String patronymic) {
        this(null, firstName, lastName, patronymic);
    }
    public Human(String firstName, String lastName) {
        this((Date) null, firstName, lastName);
    }
    public Human(){
        this(null, null);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    private Date getDateInput(final String inputMessage) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while(true) {
            try {
                System.out.print(inputMessage);
                return simpleDateFormat.parse(scanner.nextLine());
            }
            catch(Exception ex) {
                System.out.println("\n Your input is invalid, try again!");
                continue;
            }
        }
    }

    private String getPhoneNumberInput(final String inputMessage, final String regExp){
        String tempPhoneNumber;
        Pattern pattern = Pattern.compile(regExp);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print(inputMessage);
            tempPhoneNumber = scanner.nextLine();
            Matcher matcher = pattern.matcher(tempPhoneNumber);

            if(!matcher.matches()){
                System.out.println("\n You entered wrong format phone number!");
                continue;
            }

            return tempPhoneNumber;
        }
    }

    public void fillBio() {
        String patronymic;
        final String regExp = "^(\\+380|0)\\d{2}\\d{7}$";

        setFirstName(Helpers.getStringInputByLength("\n Enter firstname: ", 2));
        setLastName(Helpers.getStringInputByLength("\n Enter lastname: ", 2));

        patronymic = Helpers.getStringInputByLength("\n Enter patronymic (enter \"0\" to skip): ", 1);
        setPatronymic(patronymic.equals("0") ? null : patronymic);

        setBirthDate(getDateInput("\n Enter your birth date (yyyy-MM-dd): "));

        setPhoneNumber(getPhoneNumberInput("\n Enter your phone number (+380|0998877999): ", regExp));

        homeAddress = HomeAddress.getHomeAddress();
    }

    @Override
    public String toString() {
        return String.format("\n %s %s %s:\n  Birthday: %s\n  Phone number: %s\n  Home address:\n%s\n",
                getLastName(),
                getFirstName(),
                getPatronymic() == null ? "" : getPatronymic(),
                new SimpleDateFormat("yyyy-MM-dd").format(getBirthDate()), getPhoneNumber(), getHomeAddress());
    }
}
