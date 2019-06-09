package builderPattern;

import builderPattern.ingredients.Ingredient;

public interface ShopItemBuilder {
    ShopItemBuilder addIngredient(Ingredient ingredient);

    ShopItemBuilder removeIngredient(Ingredient extraIngredient);
}
