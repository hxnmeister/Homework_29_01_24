package Task5;

import Helpers.Helpers;

public class Author {
    private String firstName;
    private String lastName;
    private String patronymic;

    public Author(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Author(){
        this(null, null);
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

    public void fillBio(){
        setFirstName(Helpers.getStringInputByLength("\n Enter first name: ", 3));
        setLastName(Helpers.getStringInputByLength("\n Enter last name: ", 4));
        setPatronymic(Helpers.getStringInputByLength("\n Enter patronymic (enter \"0\" to skip): ", 1));
    }

    public static Author getAuthorBio() {
        String firstName = Helpers.getStringInputByLength("\n Enter first name: ", 3);
        String lastName = Helpers.getStringInputByLength("\n Enter last name: ", 4);
        String patronymic = Helpers.getStringInputByLength("\n Enter patronymic (enter \"0\" to skip): ", 1);

        return new Author(firstName, lastName, patronymic.equals("0") ? null : patronymic);
    }

    @Override
    public String toString() {
        return String.format(" %s %s %s ",
                getFirstName(),
                getLastName(),
                getPatronymic() == null ? "" : patronymic);
    }
}
