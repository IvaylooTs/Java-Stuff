import java.util.*;

public class Car {
    private String brand;
    private String model;
    private String color;
    private int power;
    private String engineType;
    private String transmissionType;
    private int yearOfProduction;

    public Car() {
    }

    public Car(String brand, String model, String color, int power, String engineType, String transmissionType, int yearOfProduction) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.power = power;
        this.engineType = engineType;
        this.transmissionType = transmissionType;
        this.yearOfProduction = yearOfProduction;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Car[] filterCars(Car[] cars, char letter) {
        ArrayList<Car> filteredCars = new ArrayList<Car>();
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().toLowerCase().charAt(0) == letter) {
                filteredCars.add(car);
                count++;
            }
        }
        return filteredCars.toArray(new Car[count]);
    }

    public Car[] sortCarsByBrand(Car[] cars, boolean ascending) {
        Comparator<Car> brandComparator = Comparator.comparing(Car::getBrand);

        if (!ascending) {
            brandComparator = brandComparator.reversed();
        }

        Arrays.sort(cars, brandComparator);
        return cars;
    }
    public static Car[] removeDuplicates(Car[] cars) {
        Set<Car> uniqueCars = new HashSet<>();
        Set<String> seenBrands = new HashSet<>();
        int count = 0;

        // Проход през масива отзад напред за по-ефективно извличане на последните уникални коли
        for (int i = cars.length - 1; i >= 0; i--) {
            Car car = cars[i];

            // Ако марката не е била видяна, добави като уникална
            if (seenBrands.add(car.getBrand().toLowerCase())) {
                uniqueCars.add(car);
                count++;
            }
        }

        // Преобразуване на множеството от уникални коли в масив
        return uniqueCars.toArray(new Car[count]);
    }
}
