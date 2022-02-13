package Inheritance;

public class Car extends Vehicle {
    int numOfDoors;

    void printCar() {
        System.out.println("Car " + "color: " + getColor() + " MS: " + maxSpeed + " nd: " + numOfDoors);
    }
}

