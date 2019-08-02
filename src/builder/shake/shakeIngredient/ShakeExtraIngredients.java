package builder.shake.shakeIngredient;

import builder.Ingredient;

public enum ShakeExtraIngredients implements Ingredient {

    AlmondMilk(60), Candy(50), Cookie(40);

    public int addedPrice;

    ShakeExtraIngredients(int addedPrice) {
        this.addedPrice = addedPrice;
    }

}
