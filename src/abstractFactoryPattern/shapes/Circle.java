package abstractFactoryPattern.shapes;

import abstractFactoryPattern.Computer;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI*radius*radius);
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle(Area="+getArea()+",Perimeter="+getPerimeter()+")";
    }

    @Override
    public boolean isCompatible(Computer computer) {
        return !(computer.getResolution().getWidth() < 2 * radius) && !(computer.getResolution().getHeight() < 2 * radius);
    }
}
