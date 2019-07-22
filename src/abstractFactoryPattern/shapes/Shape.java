package abstractFactoryPattern.shapes;

import abstractFactoryPattern.ComputerDisplayable;

public interface Shape extends ComputerDisplayable {
    double getArea();
    double getPerimeter();
}
