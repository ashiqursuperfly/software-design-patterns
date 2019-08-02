package builder.shake;

public enum ShakeType {
    ChocolateShake(230), CoffeeShake(230), VanillaShake(190), StrawberryShake(200), ZeroShake(240);
    public int basePrice;

    ShakeType(int basePrice) {
        this.basePrice = basePrice;
    }
}
