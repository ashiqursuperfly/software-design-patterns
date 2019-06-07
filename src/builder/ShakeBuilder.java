package builder;

import java.util.ArrayList;
import java.util.List;
/** Note:We dont need a Director Class here since the sequence in which each building process gets done is unimportant here
 * therefore,directing can be done in the client code. Real World Example of this is Java's StringBuilder Class **/
public class ShakeBuilder {

    private ShakeType shakeType;
    private List<ExtraIngredients> extraIngredients;

    public ShakeBuilder() {
        extraIngredients = new ArrayList<>();
    }

    public static ShakeBuilder builder() {
        return new ShakeBuilder();
    }

    /**
     * This allows consumers to change the ShakeType any moment if they want
     * but still keep their additional choices such as topping,lactose-intolerance intact
     **/
    public ShakeBuilder setShakeType(ShakeType shakeType) {
        this.shakeType = shakeType;
        return this;
    }

    public ShakeBuilder addExtraIngredient(ExtraIngredients extraIngredient) {
        if (!extraIngredients.contains(extraIngredient)) {
            extraIngredients.add(extraIngredient);
            System.out.println("Topping " + extraIngredient.name() + " Added");
        } else System.out.println("Error : Already Added " + extraIngredient.name());
        return this;
    }
    public ShakeBuilder removeExtraIngredient(ExtraIngredients extraIngredient) {
        if (!extraIngredients.contains(extraIngredient)) {
            System.out.println("No Problems :"+ extraIngredient.name()+" was not added anyway!");
        } else {
            extraIngredients.remove(extraIngredient);
            System.out.println("Topping " + extraIngredient.name() + " removed");
        }
        return this;
    }
    public ShakeBuilder makeLactoseFull() {
        if (extraIngredients.contains(ExtraIngredients.AlmondMilk)) {
            extraIngredients.remove(ExtraIngredients.AlmondMilk);
            System.out.println("Replaced " + ExtraIngredients.AlmondMilk.name() + " by " + Ingredients.Milk.name());
        } else System.out.println("Already Contains Lactose Ingredient " + Ingredients.Milk.name());
        return this;
    }

    public ShakeBuilder makeLactoseFree() {
        if (!extraIngredients.contains(ExtraIngredients.AlmondMilk)) {
            extraIngredients.add(ExtraIngredients.AlmondMilk);
            System.out.println("Your shake is now Lactose Free,Replaced " + Ingredients.Milk + " by " + ExtraIngredients.AlmondMilk);
        } else System.out.println("Error : Already Lactose Free with " + ExtraIngredients.AlmondMilk.name());
        return this;
    }

    /**
     * Calling of this method marks completion of shake-building process,
     * All other Methods Except this method return a ShakeBuilder
     **/
    public Shake produceShake() {
        switch (shakeType) {
            case ChocolateShake:
                return new ChocolateShake(this.extraIngredients);
            case CoffeeShake:
                return new CoffeeShake(this.extraIngredients);
            case VanillaShake:
                return new VanillaShake(this.extraIngredients);
            case StrawberryShake:
                return new StrawberryShake(this.extraIngredients);
            case ZeroShake:
                return new ZeroShake(this.extraIngredients);
        }
        System.out.println("Error : Please Specify Shake Type!"); //ensures no shake can be created without calling setShakeType()
        return null;
    }
}
