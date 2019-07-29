package lesson02HW.task04;

/**
 * Created by anton.sviatov on 17.07.2019.
 */

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void square() {
        System.out.println("Square of the rectangle is " + (width * height));
    }

    public void perimeter() {
        System.out.println("Perimeter of the rectangle is " + (2 * (width + height)));
    }

}
