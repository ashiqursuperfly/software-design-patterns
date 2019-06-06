package builder;

import java.util.List;

public class StrawberryShake extends Shake {

    public StrawberryShake(List<ExtraIngredients> extraIngredients) {
        super(ShakeType.StrawberryShake,extraIngredients);
        setSpecializedIngredients();
    }

    @Override
    void setSpecializedIngredients() {
        addIngredient(Ingredients.StrawberrySyrup);
        addIngredient(Ingredients.StrawberryIceCream);
        //TODO:handle changes to Strawberry shake ingredients here
    }
}
