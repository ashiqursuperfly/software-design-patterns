package clientcode;

import builder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShakeShack {
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
                items.add(addAShakeInCurrentOrder(Integer.parseInt(choice)));
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
        ShakeBuilder builder = ShakeBuilder.builder();
        switch (choice) {
            case 1:
                builder.setShakeType(ShakeType.ChocolateShake);
                System.out.println("Added new shake " + ShakeType.ChocolateShake.name());
                break;
            case 2:
                builder.setShakeType(ShakeType.CoffeeShake);
                System.out.println("Added new shake " + ShakeType.CoffeeShake.name());
                break;
            case 3:
                builder.setShakeType(ShakeType.StrawberryShake);
                System.out.println("Added new shake " + ShakeType.StrawberryShake.name());
                break;
            case 4:
                builder.setShakeType(ShakeType.VanillaShake);
                System.out.println("Added new shake " + ShakeType.VanillaShake.name());
                break;
            case 5:
                builder.setShakeType(ShakeType.ZeroShake);
                System.out.println("Added new shake " + ShakeType.ZeroShake.name());
                break;
            default:
                System.out.println("Error: Invalid Input !");


        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to 1.Make your Shake Lactose Free\n 2.AddTopping ? 3.Confirm This Shake");
            choice = sc.nextInt();
            if (choice == 1) {
                builder.makeLactoseFree();
            } else if (choice == 2) {
                System.out.println("Options : 1.Cookie(+40Tk) 2.Candy(+50Tk)");
                Scanner sc2 = new Scanner(System.in);
                int choice2 = sc2.nextInt();
                if (choice2 == 1) {
                    builder.addExtraIngredient(ExtraIngredients.Cookie);
                } else if (choice2 == 2) {
                    builder.addExtraIngredient(ExtraIngredients.Candy);
                } else {
                    System.out.println("Error :Invalid Topping Choice!");
                }

            } else if (choice == 3) {
                return builder.produceShake();
            } else {
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

class ShakeShackClientCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'O' to open an Order");
            if (sc.nextLine().equalsIgnoreCase("O")) {
                ShakeShack.printOrder(ShakeShack.createNewOrder());
            } else System.out.println("Invalid Input");
        }

//	    System.out.println(ShakeShack.Builder.builder().setShakeType(ShakeType.ChocolateShake)
//                .addExtraIngredient(ExtraIngredients.Cookie).addExtraIngredient(ExtraIngredients.AlmondMilk).produceShake());
    }


}
