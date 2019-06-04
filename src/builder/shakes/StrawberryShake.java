package builder.shakes;

import java.util.List;

public class StrawberryShake extends Shake {
    public StrawberryShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.StrawberryShake,extraIngredients);
        addIngredient(Ingredients.StrawberrySyrup);
        addIngredient(Ingredients.StrawberryIceCream);
    }
}
