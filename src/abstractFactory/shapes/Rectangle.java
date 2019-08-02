package abstractFactory.shapes;

import abstractFactory.Computer;

public class Rectangle implements Shape {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle(Area=" + getArea() + ",Perimeter=" + getPerimeter() + ")";
    }

    @Override
    public boolean isCompatible(Computer computer) {
        if((computer.getResolution().getWidth()< width || computer.getResolution().getHeight()< height) &&
        (computer.getResolution().getWidth()< height || computer.getResolution().getHeight()< width))return false;
        return true;
    }
}
