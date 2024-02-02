package Task4;

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        fraction1.setValues();
        fraction2.setValues();

        fraction1.actionSelector(fraction2);
    }
}
