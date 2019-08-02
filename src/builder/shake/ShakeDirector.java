package builder.shake;

import builder.shake.shakeIngredient.ShakeBaseIngredients;
import builder.Ingredient;

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
                        .addIngredient(ShakeBaseIngredients.Milk)
                        .addIngredient(ShakeBaseIngredients.Sugar)
                        .addIngredient(ShakeBaseIngredients.ChocolateIceCream)
                        .addIngredient(ShakeBaseIngredients.ChocolateSyrup);
                break;
            case CoffeeShake:
                shakeBuilder.setShakeType(ShakeType.CoffeeShake)
                        .addIngredient(ShakeBaseIngredients.Milk)
                        .addIngredient(ShakeBaseIngredients.Sugar)
                        .addIngredient(ShakeBaseIngredients.Coffee)
                        .addIngredient(ShakeBaseIngredients.Jello);
                break;
            case VanillaShake:
                shakeBuilder.setShakeType(ShakeType.VanillaShake)
                        .addIngredient(ShakeBaseIngredients.Milk)
                        .addIngredient(ShakeBaseIngredients.Sugar)
                        .addIngredient(ShakeBaseIngredients.VanillaFlavouring)
                        .addIngredient(ShakeBaseIngredients.Jello);
                break;
            case StrawberryShake:
                shakeBuilder.setShakeType(ShakeType.StrawberryShake)
                        .addIngredient(ShakeBaseIngredients.Milk)
                        .addIngredient(ShakeBaseIngredients.Sugar)
                        .addIngredient(ShakeBaseIngredients.StrawberryIceCream)
                        .addIngredient(ShakeBaseIngredients.StrawberrySyrup);
                break;
            case ZeroShake:
                shakeBuilder.setShakeType(ShakeType.ZeroShake)
                        .addIngredient(ShakeBaseIngredients.Milk)
                        .addIngredient(ShakeBaseIngredients.Sweetener)
                        .addIngredient(ShakeBaseIngredients.VanillaFlavouring)
                        .addIngredient(ShakeBaseIngredients.SugarFreeJello);
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
