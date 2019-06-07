package abstract_factory;

public interface AbstractComputerFactory {
    String getCPU();
    String getMMU();
    String getResolution();
    Computer createComputer();
}
