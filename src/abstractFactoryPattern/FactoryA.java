package abstractFactoryPattern;

public class FactoryA implements AbstractFactory {

    private String cpu="CPU-A",mmu="MMU-A",resolution="200x200";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }


}
