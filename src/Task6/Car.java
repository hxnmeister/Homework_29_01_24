package Task6;

import Helpers.Helpers;

import java.util.Scanner;

public class Car {
    private int manufactureYear;
    private double engineCapacity;
    private String model;
    private String manufacturer;

    public Car(String model, String manufacturer, int manufactureYear, double engineCapacity) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.manufactureYear = manufactureYear;
        this.engineCapacity = engineCapacity;
    }
    public Car() {
        this(null, null, 0, 0.0);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    private double getDoubleInput(final String inputMessage) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print(inputMessage);
                return scanner.nextDouble();
            }
            catch (Exception ex) {
                System.out.println("\n Your input was invalid!");
                scanner.next();
                continue;
            }
        }
    }

    public void fillInfo() {
        setModel(Helpers.getStringInputByLength("\n Enter model: ", 4));
        setManufacturer(Helpers.getStringInputByLength("\n Enter manufacturer: ", 5));

        setManufactureYear(Helpers.getIntegerInput("\n Enter manufacture year: "));

        setEngineCapacity(getDoubleInput("\n Enter engine capacity: "));
    }

    @Override
    public String toString() {
        return String.format("\n Model: %s\n Manufacturer: %s\n Manufacture year: %s\n Engine capacity: %s\n",
                getModel(),
                getManufacturer(),
                getManufactureYear(),
                getEngineCapacity());
    }
}
