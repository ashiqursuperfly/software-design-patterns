package clientCode;

import builderPattern.ingredients.BaseIngredients;
import builderPattern.ingredients.ExtraIngredients;
import builderPattern.ingredients.Ingredient;
import builderPattern.shakeBuilder.Shake;
import builderPattern.shakeBuilder.ShakeDirector;
import builderPattern.shakeBuilder.ShakeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ShakeShack {

    public static List<Shake> createNewOrder() {
        Scanner sc = new Scanner(System.in);
        List<Shake> items = new ArrayList<>();
        while (true) {
            System.out.println("Choose a shake:: 1.Chocolate Shake 2.Coffee Shake 3.Strawberry Shake 4.Vanilla Shake 5.Zero Shake");
            System.out.println("E. Confirm Order");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2")
                    || choice.equalsIgnoreCase("3") || choice.equalsIgnoreCase("4")
                    || choice.equalsIgnoreCase("5")) {
                Shake newShake = addAShakeInCurrentOrder(Integer.parseInt(choice));
                if(newShake!=null)items.add(newShake);
            } else if (choice.equalsIgnoreCase("E")) {
                if (items.size() != 0) {
                    return items;
                } else {
                    System.out.println("Error : Cannot Confirm Order. Please Add atleast 1 shake to your Order");
                }

            } else if (choice.equalsIgnoreCase("O")) {
                System.out.println("Error: Cannot Open a new Order without Closing this order.\nDo You want to add new Shake to your order?");

            } else System.out.println("Invalid Input,Try again");


        }

    }

    public static Shake addAShakeInCurrentOrder(int choice) {
        ShakeType shakeType = null;
        switch (choice) {
            case 1:
                shakeType = ShakeType.ChocolateShake;
                System.out.println("Added new shake " + ShakeType.ChocolateShake.name());
                break;
            case 2:
                shakeType = ShakeType.CoffeeShake;
                System.out.println("Added new shake " + ShakeType.CoffeeShake.name());
                break;
            case 3:
                shakeType = ShakeType.StrawberryShake;
                System.out.println("Added new shake " + ShakeType.StrawberryShake.name());
                break;
            case 4:
                shakeType = ShakeType.VanillaShake;
                System.out.println("Added new shake " + ShakeType.VanillaShake.name());
                break;
            case 5:
                shakeType = ShakeType.ZeroShake;
                System.out.println("Added new shake " + ShakeType.ZeroShake.name());
                break;
            default:
                System.out.println("Error: Invalid Input !");


        }
        Scanner sc = new Scanner(System.in);
        boolean isLactoseFree = false;
        List<Ingredient> extraIngredients = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to 1.Make your Shake Lactose Free/Full\n 2.Add/RemoveTopping ? 3.Confirm This Shake(You cant undo this)\n" +
                    "4.Cancel This Shake");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("1.Make Lactose Free 2.Remove Lactose Free Ingredient 3.Cancel");
                Scanner sc4 = new Scanner(System.in);
                int c4 = sc4.nextInt();
                if (c4 == 1) {
                    isLactoseFree = true;
                    System.out.println("Your shake is now Lactose Free,Replaced " + BaseIngredients.Milk + " by " + ExtraIngredients.AlmondMilk);
                } else if (c4 == 2) {
                    isLactoseFree = false;
                    System.out.println("Replaced " + ExtraIngredients.AlmondMilk.name() + " by " + BaseIngredients.Milk.name());
                }
            } else if (choice == 2) {
                System.out.println("Options : 1.Cookie(+40) 2.Candy(+50) 3.Remove Topping");
                Scanner sc2 = new Scanner(System.in);
                int choice2 = sc2.nextInt();
                if (choice2 == 1) {
                    extraIngredients.add(ExtraIngredients.Cookie);
                    System.out.println("Topping " + ExtraIngredients.Cookie.name() + " Added");
                } else if (choice2 == 2) {
                    extraIngredients.add(ExtraIngredients.Candy);
                    System.out.println("Topping " + ExtraIngredients.Candy.name() + " Added");
                } else if (choice2 == 3) {
                    System.out.println("Remove: 1.Cookie(+40Tk) 2.Candy(+50Tk) 3.Cancel");
                    Scanner sc3 = new Scanner(System.in);
                    int c3 = sc3.nextInt();
                    if (c3 == 1) {
                        extraIngredients.remove(ExtraIngredients.Cookie);
                        System.out.println("Topping " + ExtraIngredients.Cookie + " removed");
                    } else if (c3 == 2) {
                        extraIngredients.remove(ExtraIngredients.Candy);
                        System.out.println("Topping " + ExtraIngredients.Candy + " removed");
                    }
                } else {
                    System.out.println("Error :Invalid Topping Choice!");
                }

            } else if (choice == 3) {
                System.out.println("Confirmed 1 Shake " + shakeType + " in current order");

                ShakeDirector shakeDirector = new ShakeDirector(extraIngredients, isLactoseFree);

                return shakeDirector.produceShake(shakeType); //End of Shake Building Process for this Shake.
            }
            else if (choice == 4) {
                System.out.println("Cancelled 1 " + shakeType + " from current order");
                return null;
            }
            else {
                System.out.println("Error :Invalid Additional Choice!");
            }

        }

    }

    public static void printOrder(List<Shake> newOrder) {
        System.out.println(":: Your Order Details ::");
        System.out.println("Shake--BaseIngredients--Extras--BasePrice--ExtraPrice--TotalPrice");
        for (int i = 0; i < newOrder.size(); i++) {
            System.out.println("[" + i + "] " + newOrder.get(i));
        }
    }

}

public class ShakeShackClientCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*The clientCode only needs to create a ShakeDirector and call ProduceShake
          e.g :
          ShakeDirector shakeDirector = new ShakeDirector();
          shakeDirector.produceShake(ShakeType.ChocolateShake);
          **/

        while (true) {
            System.out.println("Enter 'O' to open an Order");
            if (sc.nextLine().equalsIgnoreCase("O")) {
                ShakeShack.printOrder(ShakeShack.createNewOrder());
            } else System.out.println("Invalid Input");
        }

    }


}
