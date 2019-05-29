package builder.shakes;

import builder.ShakeType;

import java.util.List;

public class VanillaShake extends Shake {
    public VanillaShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.VanillaShake,extraIngredients);
        addIngredient(Ingredients.VanillaFlavouring);
        addIngredient(Ingredients.Jello);
    }
}
