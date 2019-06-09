package abstractFactoryPattern.shapes;

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
}
