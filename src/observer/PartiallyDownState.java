package observer;

import java.util.List;
import java.util.Scanner;

public class PartiallyDownState implements State {
    private ServerProviderCompany context;

    @Override
    public void setContext(ServerProviderCompany statefulObject) {
        this.context = statefulObject;
    }

    @Override
    public String getStateID() {
        return getClass().getSimpleName();
    }

    @Override
    public void stateSpecificBehaviour() {

        //TODO: (Any) --> (PD) edges of the D.F.A
        switch (context.getPreviousState().getStateID()) {
            case "Operational":
                fromOperational();
                break;
            case "FullyDown":
                //DoNothing
                break;
            default:
                try {
                    throw new Exception("Invalid State Transition");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    private void fromOperational() {
        List<User> subscribers = context.getSubscribers();

        for (User u:
                subscribers) {
            if(u instanceof PremiumUser){
                fromOperationalPremium(u);
            }
            else if(u instanceof RegularUser){
                fromOperationalRegular(u);
            }
            else{
                try {
                    throw new Exception("Invalid User Type:"+u.getType());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

    private void fromOperationalRegular(User u){
        RegularUser temp = (RegularUser)u;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("ABC's Server Partially Down.Do You Want to Pay 20$/h Extra for Full-Functionality service(provided by DEF)?\n" +
                    "1.YES 2.NO\n");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    temp.setPayingForServerDown(true);
                    temp.update(context,"Congrats. You are now receiving service from DEF");
                    //TODO: subscribe user to DEF
                    return;
                case "2":
                    temp.setPayingForServerDown(false);
                    temp.update(context,"You will temporarily receive limited service");
                    return;
                case "3":
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    private void fromOperationalPremium(User u){
        PremiumUser temp = (PremiumUser) u;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("ABC's Server Partially Down.\n" +
                    "1.Use Full-Service from DEF \n" +
                    "2.Use Full-Service from ABC and DEF Combined\n");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    temp.setCurrentServiceCompany("DEF");
                    temp.update(context,"Congrats. You are now receiving service from DEF");
                    //TODO: subscribe user to DEF
                    return;
                case "2":
                    temp.setCurrentServiceCompany("ABC-DEF");
                    temp.update(context,"You will temporarily receive limited service");
                    return;
                case "3":
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
