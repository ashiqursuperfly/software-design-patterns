package builder.shakes;

public enum ExtraIngredients {

    AlmondMilk(60),Candy(50), Cookie(40);

    public int addedPrice;

    ExtraIngredients(int addedPrice) {
        this.addedPrice = addedPrice;
    }
}
