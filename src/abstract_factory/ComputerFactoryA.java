package abstract_factory;

public class ComputerFactoryA implements AbstractComputerFactory {

    private String cpu="CPU-A",mmu="MMU-A",resolution="200x200";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }


}
