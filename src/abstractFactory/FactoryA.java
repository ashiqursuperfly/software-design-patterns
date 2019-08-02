package abstractFactory;

public class FactoryA implements AbstractFactory {

    private String cpu="CPU-A",mmu="MMU-A";
    private int resolutionWidth=200,resolutionHeight=200;

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,new Resolution(resolutionWidth,resolutionHeight));
    }


}
