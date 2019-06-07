package clientcode;

import abstract_factory.*;
import abstract_factory.shapes.*;

import java.util.Scanner;

public class ComputerSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractComputerFactory factory;
        Computer computer;
        while (true){
            System.out.println("Pick A Computer: 1.ComputerA 2.ComputerB 3.ComputerC");
            int c = sc.nextInt();
            switch (c){
                case 1:
                    factory = new ComputerFactoryA();
                    computer = factory.createComputer();
                    pickAndDisplayShape(computer);
                    break;
                case 2:
                    factory = new ComputerFactoryB();
                    computer = factory.createComputer();
                    pickAndDisplayShape(computer);
                    break;
                case 3:
                    factory = new ComputerFactoryC();
                    computer = factory.createComputer();
                    pickAndDisplayShape(computer);
                    break;
                default:
                    System.out.println("Invalid Computer Factory !");
                    break;

            }
        }
    }

    private static Shape inputCircle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        double radius = sc.nextDouble();
        return new Circle(radius);
    }

    private static Shape inputTriangle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of Side 1");
        double side1 = sc.nextDouble();

        System.out.println("Enter Length of Side 2");
        double side2 = sc.nextDouble();

        System.out.println("Enter Length of Side 3");
        double side3 = sc.nextDouble();

        return new Triangle(side1,side2,side3);

    }

    private static Shape inputSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of Side");
        double side = sc.nextDouble();
        return new Square(side);
    }

    private static Shape inputRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length");
        double length = sc.nextDouble();

        System.out.println("Enter width");
        double width = sc.nextDouble();
        return new Rectangle(length,width);
    }

    private static void pickAndDisplayShape(Computer computer){
        while (true){
            System.out.println("Pick A Shape to Draw 1.Triangle 2.Rectangle 3.Circle 4.Square 5.Turn Off Computer");
            Scanner sc2 = new Scanner(System.in);
            int c2 = sc2.nextInt();
            switch (c2){
                case 1:
                    computer.display(inputTriangle());
                    break;
                case 2:
                    computer.display(inputRectangle());
                    break;
                case 3:
                    computer.display(inputCircle());
                    break;
                case 4:
                    computer.display(inputSquare());
                    break;
                case 5:
                    return;


            }
        }
    }

}
