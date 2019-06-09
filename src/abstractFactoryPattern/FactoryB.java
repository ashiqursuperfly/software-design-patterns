package abstractFactoryPattern;

public class FactoryB implements AbstractFactory {

    private String cpu="CPU-B",mmu="MMU-B",resolution="350x250";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }

}
