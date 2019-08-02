package abstractFactory;

public class FactoryB implements AbstractFactory {

    private String cpu="CPU-B",mmu="MMU-B";
    private int resolutionWidth=350,resolutionHeight=250;

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,new Resolution(resolutionWidth,resolutionHeight));
    }


}
