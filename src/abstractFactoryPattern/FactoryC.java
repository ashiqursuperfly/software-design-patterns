package abstractFactoryPattern;

public class FactoryC implements AbstractFactory {

    private String cpu="CPU-C",mmu="MMU-C";
    private int resolutionWidth=550,resolutionHeight=430;

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,new Resolution(resolutionWidth,resolutionHeight));
    }


}
