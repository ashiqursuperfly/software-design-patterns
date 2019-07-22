package abstractFactoryPattern;


import abstractFactoryPattern.shapes.Shape;

public class Computer {
    private String cpu,mmu;
    private Resolution resolution;

    public String getCpu() {
        return cpu;
    }

    public String getMmu() {
        return mmu;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public Computer(String cpu, String mmu, Resolution resolution) {
        this.cpu = cpu;
        this.mmu = mmu;
        this.resolution = resolution;
    }
    public void display(Shape shape) {
        if(shape.isCompatible(this))System.out.println(shape.toString()+" Resolution:"+resolution);
        else System.out.println("Error : The specified Shape cant be displayed in this Computer with resolution :"+resolution);
    }

}
