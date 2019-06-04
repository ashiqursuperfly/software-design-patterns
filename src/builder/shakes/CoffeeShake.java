package builder.shakes;

import java.util.List;

public class CoffeeShake extends Shake {

    public CoffeeShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.CoffeeShake,extraIngredients);
        addIngredient(Ingredients.Coffee);
        addIngredient(Ingredients.Jello);
    }
}
