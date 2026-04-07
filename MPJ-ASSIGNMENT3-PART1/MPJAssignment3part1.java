import java.util.Scanner;

class Shape{
    double len, br, rad;
    Shape(double l, double b) {
        len = l;
        br = b;
    }
    Shape(double r) {
        rad = r;
    }
    double area(double l, double b) {
        return l*b;
    }
    double area(double r) {
        return 3.14*r*r;
    }
}
public class MPJAssignment3part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();
                    Shape rect = new Shape(l, b);
                    System.out.println("Area of Rectangle = " + rect.area(l, b));
                    break;
                case 2:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    Shapes circle = new Shapes(r);
                    System.out.println("Area of Circle = " + circle.area(r));
                    break;
                case 3:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (choice!=3);
        sc.close();
    }
}
