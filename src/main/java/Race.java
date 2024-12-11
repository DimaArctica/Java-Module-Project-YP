import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Race {
    ArrayList<Car> carArrayList = new ArrayList<>();
    ArrayList<String> leadersArrayList = new ArrayList<>();
    int numberOfLeaders = 0;
    static int maxSpeed = 250, numberOfCars = 3;

    void addCars() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= numberOfCars; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String carName = scanner.next();
            while (true) {
                int carSpeed;
                System.out.println("Введите скорость машины в км/ч №" + i + ":");
                scanner.nextLine();
                if (scanner.hasNextInt()) {
                    carSpeed = scanner.nextInt();
                    if (carSpeed < 0 || carSpeed > maxSpeed) {
                        System.out.println("Введена некорректная скорость. Введите целое число от 0 до 250.");
                    } else {
                        carArrayList.add(new Car(carName, carSpeed));
                        break;
                    }
                } else {
                    System.out.println("Введена некорректная скорость. Введите целое число от 0 до 250.");
                }
            }
        }

    }

    void calculateRaceLeader(ArrayList<Car> carsArrayList) {
        Car raceLeader = new Car("leaderName", -1);
        int topDistance = raceLeader.distance;
        for (Car currentCar : carsArrayList) {
            if (currentCar.distance >= raceLeader.distance) {
                raceLeader = currentCar;
                topDistance = currentCar.distance;
            }
        }
        for (Car currentCar : carsArrayList) {
            if (currentCar.distance == topDistance) {
                leadersArrayList.add(currentCar.name);
            }
        }
    }

    String convertLeadersArrayToString(ArrayList<String> carsArrayList) {
        String[] leadersArray = new String[carsArrayList.size()];
        String leadersString;
        for (String currentLeadersCar : carsArrayList) {
            leadersArray[numberOfLeaders] = currentLeadersCar;
            numberOfLeaders++;
        }
        leadersString = Arrays.toString(leadersArray);
        return leadersString.substring(1, leadersString.length() - 1); //избавляемся от квадратных скобок в начале и в конце строки
    }

    void printLeaders() {
        String fastestCar;
        fastestCar = convertLeadersArrayToString(leadersArrayList);
        if (numberOfLeaders > 1) {
            System.out.println("Самые быстрые машины: " + fastestCar);
        } else {
            System.out.println("Самая быстрая машина: " + fastestCar);
        }

    }
}
