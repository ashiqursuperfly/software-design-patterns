package abstractFactory.shapes;

import abstractFactory.ComputerDisplayable;

public interface Shape extends ComputerDisplayable {
    double getArea();
    double getPerimeter();
}
