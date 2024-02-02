package Helpers;

import java.util.Scanner;

public class Helpers {
    static private final Scanner SCANNER = new Scanner(System.in);

    static public String getStringInputByLength(final String inputMessage, final int lineMaxLength) {
        String tempString;

        while(true) {
            System.out.print(inputMessage);
            tempString = SCANNER.nextLine();

            if(tempString.isEmpty()){
                System.out.println("\n Your line was empty!");
                continue;
            }
            else if (tempString.length() < lineMaxLength) {
                System.out.println("\n Your input line \"" + tempString + "\" is too short!");
                continue;
            }

            return tempString;
        }
    }

    static public short getShortIntegerInput(final String inputMessage) {
        while(true) {
            try {
                System.out.print(inputMessage);
                return SCANNER.nextShort();
            }
            catch (Exception ex) {
                System.out.println("\n Your input was invalid!");
                SCANNER.next();
                continue;
            }
        }
    }

    static public int getIntegerInput(final String inputMessage) {
        while(true) {
            try {
                System.out.print(inputMessage);
                return SCANNER.nextInt();
            }
            catch (Exception ex) {
                System.out.println("\n Your input was invalid!");
                SCANNER.next();
                continue;
            }
        }
    }
}
