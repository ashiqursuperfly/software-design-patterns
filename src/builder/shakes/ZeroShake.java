package builder.shakes;

import java.util.List;

public class ZeroShake extends Shake {

    public ZeroShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.ZeroShake,extraIngredients);
        setSpecializedIngredients();
    }

    @Override
    void setSpecializedIngredients() {
        removeIngredient(Ingredients.Sugar);
        addIngredient(Ingredients.Sweetener);
        addIngredient(Ingredients.SugarFreeJello);
        addIngredient(Ingredients.VanillaFlavouring);
        //TODO:handle changes to Zero Shake ingredients here
    }
}
