package builder.shakes;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: To add a new Shake :-> 1.Extend this class 2.Implement the abstract method(s)
 * 3.Call the super constructor Shake(ShakeType,List<ExtraIngredients>) with the appropriate ShakeType
 * Note: Marking this class abstract prevents a developer from instantiating the class.
 * Therefore,no Shake can be created without the above mentioned steps.
 **/
public abstract class Shake {

    private ShakeType shakeType;
    private List<Ingredients> ingredients;
    private List<ExtraIngredients> extraIngredients;

    /**
     * Only one available Constructor ensures classes extending this class
     * "Must" call this super constructor to instantiate an object properly
     * (since there isn't even a default constructor)
     * This ensures no shake is created without appropriate shakeType which is exactly what we need
     **/
    Shake(ShakeType shakeType, List<ExtraIngredients> extraIngredients) {
        this.shakeType = shakeType;
        ingredients = new ArrayList<>();
        this.extraIngredients = new ArrayList<>();
        addIngredient(Ingredients.Milk);
        addIngredient(Ingredients.Sugar);
        for (ExtraIngredients e :
                extraIngredients) {
            if (e.equals(ExtraIngredients.AlmondMilk))
                removeIngredient(Ingredients.Milk);
            addExtraIngredient(e);
        }
    }

    abstract void setSpecializedIngredients(); // All Concrete Shakes must provide implementation of this method

    public void addIngredient(Ingredients ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredients ingredient) {
        ingredients.remove(ingredient);
    }

    public void addExtraIngredient(ExtraIngredients ingredient) {
        extraIngredients.add(ingredient);
    }

    @Override
    public String toString() {
        int totalPrice = shakeType.basePrice;
        StringBuilder baseIngredientsString = new StringBuilder(),
                extraIngredientsString = new StringBuilder(), extraPriceString = new StringBuilder();
        for (Ingredients i :
                ingredients) {
            baseIngredientsString.append(i.name()).append(",");
        }
        baseIngredientsString.deleteCharAt(baseIngredientsString.length() - 1);
        for (ExtraIngredients i :
                extraIngredients) {
            extraIngredientsString.append(i.name()).append(",");
        }
        if (extraIngredientsString.length() > 0)
            extraIngredientsString.deleteCharAt(extraIngredientsString.length() - 1);

        if (extraIngredients.size() != 0) {
            for (ExtraIngredients i :
                    extraIngredients) {
                totalPrice += i.addedPrice;
                extraPriceString.append(i.name()).append(" ").append(i.addedPrice).append(",");
            }
            if (extraPriceString.length() > 0) extraPriceString.deleteCharAt(extraPriceString.length() - 1);
        }

        return getClass().getSimpleName() + ": " + baseIngredientsString.toString() +
                " | " + extraIngredientsString.toString() + " | " + shakeType.basePrice +
                " | " + extraPriceString.toString() + " | " + totalPrice;
    }
}
