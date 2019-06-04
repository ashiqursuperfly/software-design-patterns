package builder.shakes;

import java.util.List;

public class ChocolateShake extends Shake {

    public ChocolateShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.ChocolateShake,extraIngredients);
        setSpecializedIngredients();
    }

    @Override
    void setSpecializedIngredients() {
        addIngredient(Ingredients.ChocolateSyrup);
        addIngredient(Ingredients.ChocolateIceCream);
        //TODO:handle changes to chocolate shake ingredients here
    }
}
