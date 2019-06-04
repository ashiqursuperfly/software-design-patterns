package builder.shakes;

import java.util.List;

public class VanillaShake extends Shake {

    public VanillaShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.VanillaShake,extraIngredients);
        setSpecializedIngredients();
    }

    @Override
    void setSpecializedIngredients() {
        addIngredient(Ingredients.VanillaFlavouring);
        addIngredient(Ingredients.Jello);
        //TODO:handle changes to Vanilla shake ingredients here
    }
}
