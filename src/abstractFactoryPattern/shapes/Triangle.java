package abstractFactoryPattern.shapes;

import abstractFactoryPattern.Computer;

public class Triangle implements Shape {

    private double side1,side2,side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle(Area="+getArea()+",Perimeter="+getPerimeter()+")";
    }

    @Override
    public boolean isCompatible(Computer computer) {
        double area = getArea();

        double h1 = getArea()*2/side1;
        if(isTriangleCompatible(side1,h1,computer))return true;

        double h2 = getArea()*2/side2;
        if(isTriangleCompatible(side2,h2,computer))return true;

        double h3 = getArea()*2/side3;
        if(isTriangleCompatible(side3,h3,computer))return true;

        return false;
    }

    public boolean isTriangleCompatible(double base,double height,Computer computer) {
        if((computer.getResolution().getWidth()< base || computer.getResolution().getHeight()< height)&&
                (computer.getResolution().getWidth()< height || computer.getResolution().getHeight()< base))return false;
        return true;
    }
    public static boolean isValid(double side1, double side2, double side3) {
        return (side3 + side1) > side2 && (side2 + side1) > side3 &&  (side3 + side2) > side1;
    }
}
