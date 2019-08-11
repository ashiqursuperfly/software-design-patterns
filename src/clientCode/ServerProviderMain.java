package clientCode;


import observer.ABCCompany;
import observer.PremiumUser;
import observer.RegularUser;
import observer.States;

import java.util.Scanner;

public class ServerProviderMain {
    public static void main(String[] args) {

        ABCCompany abcCompany = ABCCompany.getInstance();
        abcCompany.subscribe(new RegularUser("r1@gmail.com"));
        abcCompany.subscribe(new RegularUser("r2@gmail.com"));
        abcCompany.subscribe(new PremiumUser("p1@gmail.com"));
        abcCompany.subscribe(new PremiumUser("p2@gmail.com"));


        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("*****");
            System.out.println("Current State:"+abcCompany.getCurrentState());
            System.out.println("Move to:");
            System.out.println("1.Partially Down State 2.Fully Down State 3.Operational State");
            System.out.println("*****");
            String c = sc.nextLine();
            switch (c){
                case "1":
                   abcCompany.switchState(States.partiallyDownState);
                   break;
                case "2":
                    abcCompany.switchState(States.fullyDownState);
                    break;
                case "3":
                    abcCompany.switchState(States.operationalState);
                    break;
                default:
                    try {
                        throw new Exception("Invalid Input");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
            }
        }

    }
}
