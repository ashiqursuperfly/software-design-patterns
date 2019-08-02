package builder;

public interface ShopItemBuilder {
    ShopItemBuilder addIngredient(Ingredient ingredient);

    ShopItemBuilder removeIngredient(Ingredient extraIngredient);
}
