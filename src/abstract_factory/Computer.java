package abstract_factory;

import abstract_factory.shapes.Shape;

public class Computer {
    private String cpu,mmu,resolution;

    public Computer(String cpu, String mmu, String resolution) {
        this.cpu = cpu;
        this.mmu = mmu;
        this.resolution = resolution;
    }
    public void display(Shape shape) {
        System.out.println(shape.toString()+" Resolution:"+resolution);
    }
}
