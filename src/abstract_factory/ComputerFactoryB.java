package abstract_factory;

public class ComputerFactoryB implements AbstractComputerFactory {

    private String cpu="CPU-B",mmu="MMU-B",resolution="350x250";

    @Override
    public String getCPU() {
        return cpu;
    }

    @Override
    public String getMMU() {
        return mmu;
    }

    @Override
    public String getResolution() {
        return resolution;
    }

    @Override
    public Computer createComputer() {
        return new Computer(cpu,mmu,resolution);
    }

}
