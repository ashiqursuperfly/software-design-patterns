package builder.shakes;

import java.util.List;

public class CoffeeShake extends Shake {

    public CoffeeShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.CoffeeShake, extraIngredients);
        setSpecializedIngredients();
    }

    @Override
    void setSpecializedIngredients() {
        addIngredient(Ingredients.Coffee);
        addIngredient(Ingredients.Jello);
        //TODO:handle changes to Coffee shake ingredients here
    }
}
