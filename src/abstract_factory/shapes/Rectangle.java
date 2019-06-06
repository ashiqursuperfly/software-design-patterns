package abstract_factory.shapes;

public class Rectangle implements Shape {

    private double length,width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "Rectangle(Area="+getArea()+",Perimeter="+getPerimeter()+")";
    }
}
