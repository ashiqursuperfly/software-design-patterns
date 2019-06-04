package builder.shakes;

import java.util.List;

public class ChocolateShake extends Shake {

    public ChocolateShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.ChocolateShake,extraIngredients);
        addIngredient(Ingredients.ChocolateSyrup);
        addIngredient(Ingredients.ChocolateIceCream);
    }
}
