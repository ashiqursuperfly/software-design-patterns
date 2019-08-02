package builder.shake;

import builder.shake.shakeIngredient.ShakeExtraIngredients;
import builder.Ingredient;

import java.util.List;

public class Shake {

    private ShakeType shakeType;
    private List<Ingredient> ingredients;
    private List<Ingredient> extraIngredients;

    public Shake(ShakeBuilder shakeBuilder) {
        this.shakeType = shakeBuilder.getShakeType();
        this.ingredients = shakeBuilder.getIngredients();
        this.extraIngredients = shakeBuilder.getExtraIngredients();
    }

    @Override
    public String toString() {
        int totalPrice = shakeType.basePrice;
        StringBuilder baseIngredientsString = new StringBuilder(),
                extraIngredientsString = new StringBuilder(), extraPriceString = new StringBuilder();

        for (Ingredient i :
                ingredients) {
            baseIngredientsString.append(i.toString()).append(",");
        }
        baseIngredientsString.deleteCharAt(baseIngredientsString.length() - 1);

        for (Ingredient i :
                extraIngredients) {
            extraIngredientsString.append(i.toString()).append(",");
        }

        if (extraIngredientsString.length() > 0)
            extraIngredientsString.deleteCharAt(extraIngredientsString.length() - 1);

        if (extraIngredients.size() != 0) {
            for (Ingredient i :
                    extraIngredients) {
                if (i instanceof ShakeExtraIngredients) {
                    ShakeExtraIngredients ei = (ShakeExtraIngredients) i;
                    totalPrice += ei.addedPrice;
                    extraPriceString.append(ei.toString()).append(" ").append(ei.addedPrice).append(",");
                }
            }
            if (extraPriceString.length() > 0) extraPriceString.deleteCharAt(extraPriceString.length() - 1);
        }

        return shakeType.name() + ": " + baseIngredientsString.toString() +
                " | " + extraIngredientsString.toString() + " | " + shakeType.basePrice +
                " | " + extraPriceString.toString() + " | " + totalPrice;
    }


}
