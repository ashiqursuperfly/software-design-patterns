package abstract_factory;

public class ComputerFactoryA implements AbstractComputerFactory {

    private String cpu="CPU-A",mmu="MMU-A",resolution="200x200";

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
