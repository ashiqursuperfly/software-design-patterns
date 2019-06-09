package builderPattern.shakeBuilder;

import builderPattern.ingredients.BaseIngredients;
import builderPattern.ingredients.Ingredient;

import java.util.List;

public class ShakeDirector {

    private List<Ingredient> extraIngredients;
    private boolean isLactoseFree;

    /**
     * Optional No param constructor to construct Shakes with no Extra Options
     **/
    public ShakeDirector() {
    }

    public ShakeDirector(List<Ingredient> extraIngredients, boolean isLactoseFree) {
        this.extraIngredients = extraIngredients;
        this.isLactoseFree = isLactoseFree;
    }

    /**
     * This method carries out the most important responsibility of a A Director
     * i.e defining the order in which to call construction steps, so you can create
     * and reuse specific configurations of products.
     **/
    public Shake produceShake(ShakeType shakeType) {
        ShakeBuilder shakeBuilder = new ShakeBuilder();
        switch (shakeType) {
            case ChocolateShake:
                shakeBuilder.setShakeType(ShakeType.ChocolateShake)
                        .addIngredient(BaseIngredients.Milk)
                        .addIngredient(BaseIngredients.Sugar)
                        .addIngredient(BaseIngredients.ChocolateIceCream)
                        .addIngredient(BaseIngredients.ChocolateSyrup);
                break;
            case CoffeeShake:
                shakeBuilder.setShakeType(ShakeType.CoffeeShake)
                        .addIngredient(BaseIngredients.Milk)
                        .addIngredient(BaseIngredients.Sugar)
                        .addIngredient(BaseIngredients.Coffee)
                        .addIngredient(BaseIngredients.Jello);
                break;
            case VanillaShake:
                shakeBuilder.setShakeType(ShakeType.VanillaShake)
                        .addIngredient(BaseIngredients.Milk)
                        .addIngredient(BaseIngredients.Sugar)
                        .addIngredient(BaseIngredients.VanillaFlavouring)
                        .addIngredient(BaseIngredients.Jello);
                break;
            case StrawberryShake:
                shakeBuilder.setShakeType(ShakeType.StrawberryShake)
                        .addIngredient(BaseIngredients.Milk)
                        .addIngredient(BaseIngredients.Sugar)
                        .addIngredient(BaseIngredients.StrawberryIceCream)
                        .addIngredient(BaseIngredients.StrawberrySyrup);
                break;
            case ZeroShake:
                shakeBuilder.setShakeType(ShakeType.ZeroShake)
                        .addIngredient(BaseIngredients.Milk)
                        .addIngredient(BaseIngredients.Sweetener)
                        .addIngredient(BaseIngredients.VanillaFlavouring)
                        .addIngredient(BaseIngredients.SugarFreeJello);
                break;
        }
        if (extraIngredients != null && extraIngredients.size() != 0) {
            for (Ingredient e :
                    extraIngredients) {
                shakeBuilder.addIngredient(e);
            }
        }
        if (isLactoseFree) {
            shakeBuilder.makeLactoseFree();
        }

        return shakeBuilder.build();
    }
}
