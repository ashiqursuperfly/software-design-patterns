package abstractFactoryPattern;

import abstractFactoryPattern.shapes.Shape;

public class Computer {
    private String cpu,mmu,resolution;

    public String getCpu() {
        return cpu;
    }

    public String getMmu() {
        return mmu;
    }

    public String getResolution() {
        return resolution;
    }

    public Computer(String cpu, String mmu, String resolution) {
        this.cpu = cpu;
        this.mmu = mmu;
        this.resolution = resolution;
    }
    public void display(Shape shape) {
        System.out.println(shape.toString()+" Resolution:"+resolution);
    }
}
