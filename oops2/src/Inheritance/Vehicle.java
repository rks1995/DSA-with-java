package Inheritance;

public class Vehicle {
    // todo: inheritate classes cannot access the private variables
    private String color;
    protected int maxSpeed;
    int price;

     public String getColor() {
     return color;
     }

     public void setColor(String color) {
     this.color = color;
     }
     
     public void setMaxSpeed(int maxSpeed) {
    	 this.maxSpeed = maxSpeed;
     }
    public void print() {
        System.out.println("Vehicle " + "color" + color + "maxSpeed" + maxSpeed);
    }
}

