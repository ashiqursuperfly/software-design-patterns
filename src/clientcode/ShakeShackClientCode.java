package clientcode;

import builder.ShakeShack;
import builder.ShakeType;
import builder.shakes.ExtraIngredients;
import builder.shakes.Shake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShakeShackClientCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Enter 'O' to open an Order");
            if(sc.nextLine().equalsIgnoreCase("O")){
                ShakeShack.printOrder(ShakeShack.createNewOrder());
            }
            else System.out.println("Invalid Input");
        }

//	    System.out.println(ShakeShack.Builder.newInstance().setShakeType(ShakeType.ChocolateShake)
//                .addExtraIngredient(ExtraIngredients.Cookie).addExtraIngredient(ExtraIngredients.AlmondMilk).produceShake());
    }


}
