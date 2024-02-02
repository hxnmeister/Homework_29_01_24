package Task4;

import Helpers.Helpers;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction() {
        this(0, 0);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setValues() {
        int tempDenominator;

        setNumerator(Helpers.getIntegerInput("\n Enter numerator: "));

        do {
            tempDenominator = Helpers.getIntegerInput("\n Enter denominator: ");

            if(tempDenominator == 0){
                System.out.println("\n Denominator cannot equals to zero!");
                continue;
            }

            setDenominator(tempDenominator);
        }while (tempDenominator == 0);
    }

    private int[] findCommonDenominator(int operand1Den, int operand2Den) {
        int increaseIndex1 = 2;
        int increaseIndex2;

        while (true){
            if((operand1Den * increaseIndex1) % operand2Den == 0){
                operand1Den *= increaseIndex1;
                increaseIndex2 = operand1Den / operand2Den;

                return new int[] { increaseIndex1, increaseIndex2 };
            }

            ++increaseIndex1;
        }
    }

    private Fraction add(int operand1Num, int operand1Den, int operand2Num, int operand2Den) {

        if(operand1Den != operand2Den){
            int[] commonDenominator = findCommonDenominator(operand1Den, operand2Den);
            return new Fraction(operand1Num * commonDenominator[0] + operand2Num * commonDenominator[1], commonDenominator[1] * commonDenominator[0]);
        }

        return new Fraction(operand1Num + operand2Num, operand1Den);
    }

    private Fraction subtract(int operand1Num, int operand1Den, int operand2Num, int operand2Den) {

        if(operand1Den != operand2Den){
            int[] commonDenominator = findCommonDenominator(operand1Den, operand2Den);
            return new Fraction(operand1Num * commonDenominator[0] - operand2Num * commonDenominator[1], operand1Num * commonDenominator[0]);
        }

        return new Fraction(operand1Num - operand2Num, operand1Den);
    }

    private Fraction multiplication(int operand1Num, int operand1Den, int operand2Num, int operand2Den) {
        return new Fraction(operand1Num * operand2Num, operand1Den * operand2Den);
    }

    private Fraction division(int operand1Num, int operand1Den, int operand2Num, int operand2Den) {
        if(operand2Num == 0){
            System.out.println("\n Denominator cannot equals to zero!");
            return null;
        }

        return new Fraction(operand1Num * operand2Den, operand1Den * operand2Num);
    }

    public void actionSelector(Fraction fraction) {
        int operand1Num = this.getNumerator();
        int operand1Den = this.getDenominator();
        int operand2Num = fraction.getNumerator();
        int operand2Den = fraction.getDenominator();
        short choice;

        do {
            System.out.println("\n Choose an action:");
            System.out.println("  1. Addition;");
            System.out.println("  2. Subtraction;");
            System.out.println("  3. Division;");
            System.out.println("  4. Multiplication;");
            choice = Helpers.getShortIntegerInput("\n Enter choice: ");

            switch (choice){
                case 1:
                    System.out.println(add(operand1Num, operand1Den, operand2Num, operand2Den));
                    break;
                case 2:
                    System.out.println(subtract(operand1Num, operand1Den, operand2Num, operand2Den));
                    break;
                case 3:
                    System.out.println(division(operand1Num, operand1Den, operand2Num, operand2Den));
                    break;
                case 4:
                    System.out.println(multiplication(operand1Num, operand1Den, operand2Num, operand2Den));
                    break;
                default:
                    System.out.println("\n Incorrect input, try again!");
                    break;
            }
        }while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
    }

    @Override
    public String toString() {
        return String.format(" %s/%s", getNumerator(), getDenominator());
    }
}
