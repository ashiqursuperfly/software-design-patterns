package builder.shake;

import builder.ShopItemBuilder;
import builder.shake.shakeIngredient.ShakeExtraIngredients;
import builder.Ingredient;

import java.util.ArrayList;
import java.util.List;

class ShakeBuilder implements ShopItemBuilder {

    private ShakeType shakeType;
    private List<Ingredient> extraIngredients;
    private List<Ingredient> ingredients;

    public ShakeBuilder() {
        ingredients = new ArrayList<>();
        extraIngredients = new ArrayList<>();
    }

    public ShakeType getShakeType() {
        return shakeType;
    }

    public ShakeBuilder setShakeType(ShakeType shakeType) {
        this.shakeType = shakeType;
        return this;
    }

    public List<Ingredient> getExtraIngredients() {
        return extraIngredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public ShakeBuilder addIngredient(Ingredient ingredient) {

        if (ingredient instanceof ShakeExtraIngredients) {
            if (!extraIngredients.contains(ingredient)) {
                extraIngredients.add(ingredient);
            }
        } else {
            if (!ingredients.contains(ingredient)) {
                ingredients.add(ingredient);
            }
        }
        return this;
    }

    @Override
    public ShakeBuilder removeIngredient(Ingredient ingredient) {
        if (ingredient instanceof ShakeExtraIngredients) {
            extraIngredients.remove(ingredient);
        } else {
            ingredients.remove(ingredient);

        }
        return this;
    }

    public ShakeBuilder makeLactoseFree() {
        if (!extraIngredients.contains(ShakeExtraIngredients.AlmondMilk)) {
            extraIngredients.add(ShakeExtraIngredients.AlmondMilk);
        }
        return this;
    }

    /**
     * Calling of this method marks completion of shake-building process,
     * All other Methods Except this method return a ShakeBuilder
     **/
    public Shake build() {
        return new Shake(this);
    }
}
