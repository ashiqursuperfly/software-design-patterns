package decorator;

public class ConcreteADecorator implements ADecoratorInterface {
    private InterfaceA baseObject;

    public ConcreteADecorator(InterfaceA baseObject) {
        this.baseObject = baseObject;
    }

    @Override
    public String extraFeature() {
        return "Extra Feature";
    }

    @Override
    public String feature() {
        return baseObject.feature() + this.extraFeature();
    }
}
