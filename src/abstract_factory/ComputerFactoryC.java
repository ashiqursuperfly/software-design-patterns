package abstract_factory;

public class ComputerFactoryC implements AbstractComputerFactory {

    private String cpu="CPU-C",mmu="MMU-C",resolution="550x430";

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }


}
