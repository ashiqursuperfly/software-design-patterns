package abstract_factory;

public class ComputerFactoryB implements AbstractComputerFactory {

    private String cpu="CPU-B",mmu="MMU-B",resolution="350x250";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }

}
