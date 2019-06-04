package builder.shakes;

import java.util.ArrayList;
import java.util.List;

public class ShakeBuilder{

    private ShakeType shakeType;
    private List<ExtraIngredients> extraIngredients;

    public ShakeBuilder() {
        extraIngredients = new ArrayList<>();
    }

    public static ShakeBuilder newInstance()
    {
        return new ShakeBuilder();
    }

    public ShakeBuilder setShakeType(ShakeType shakeType) {
        this.shakeType = shakeType;
        return this;
    }

    public ShakeBuilder addExtraIngredient(ExtraIngredients extraIngredient){

        if(!extraIngredients.contains(extraIngredient)){
            extraIngredients.add(extraIngredient);
            System.out.println("Topping "+extraIngredient.name() + " Added");
        }
        else System.out.println("Error : Already Added "+extraIngredient.name());
        return this;
    }
    public ShakeBuilder makeLactoseFree(){
        if(!extraIngredients.contains(ExtraIngredients.AlmondMilk)){
            extraIngredients.add(ExtraIngredients.AlmondMilk);
            System.out.println("Your shake is now Lactose Free,Replaced "+Ingredients.Milk+ " by" +ExtraIngredients.AlmondMilk);
        }
        else System.out.println("Error : Already Lactose Free with "+ExtraIngredients.AlmondMilk.name());
        return this;
    }
    public Shake produceShake(){
        switch (shakeType){
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
        System.out.println("Error : Please Specify Shake Type!");
        return null;
    }
}
