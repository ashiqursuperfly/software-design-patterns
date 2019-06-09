package abstractFactoryPattern;

public class FactoryC implements AbstractFactory {

    private String cpu="CPU-C",mmu="MMU-C",resolution="550x430";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }


}
