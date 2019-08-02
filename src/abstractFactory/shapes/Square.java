package abstractFactory.shapes;

import abstractFactory.Computer;

public class Square implements Shape {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength*sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4*sideLength;
    }

    @Override
    public String toString() {
        return "Square(Area="+getArea()+",Perimeter="+getPerimeter()+")";
    }

    @Override
    public boolean isCompatible(Computer computer) {
        return !(computer.getResolution().getWidth() < sideLength) && !(computer.getResolution().getHeight() < sideLength);
    }
}
