package decorator;

public class A implements InterfaceA {
    private String feature;

    public A() {
        this.feature = "Base Feature";
    }

    public String feature(){
        return feature;
    }
}
