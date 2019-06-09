package builderPattern.ingredients;

public enum ExtraIngredients implements Ingredient {

    AlmondMilk(60),Candy(50), Cookie(40);

    public int addedPrice;

    ExtraIngredients(int addedPrice) {
        this.addedPrice = addedPrice;
    }
}
