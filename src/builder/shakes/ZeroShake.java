package builder.shakes;

import builder.ShakeType;

import java.util.List;

public class ZeroShake extends Shake {
    public ZeroShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.ZeroShake,extraIngredients);
        removeIngredient(Ingredients.Sugar);
        addIngredient(Ingredients.Sweetener);
        addIngredient(Ingredients.SugarFreeJello);
        addIngredient(Ingredients.VanillaFlavouring);
    }
}
