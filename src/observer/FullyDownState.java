package observer;

import java.util.List;
import java.util.Scanner;

public class FullyDownState implements State {

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
        //TODO: (Any) --> (FD) edges of the D.F.A
        switch (context.getPreviousState().getStateID()) {
            case "PartiallyDown":
                fromPartiallyDown();
                break;
            case "Operational":
                fromOperational();
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

    private void fromPartiallyDown() {

    }

    private void fromOperational() {
        List<User> subscribers = context.getSubscribers();

        for (User u:
                subscribers) {
            if(u instanceof PremiumUser){
                u.update(context,"ABC's Server Went fully down temporarily" +
                        " but since you are a premium user you can enjoy uninterrupted service provided by DEF");
            }
            else if(u instanceof RegularUser){
                //TODO: send user total bill since the last state change
                RegularUser temp = (RegularUser)u;
                Scanner sc = new Scanner(System.in);

                while (true){
                    System.out.println("Sorry,ABC's Server went fully down.Do You Want to Pay 20$/h Extra for uninterrupted service(provided by DEF)?\n" +
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
                            temp.update(context,"Your service will remain interrupted temporarily");
                            return;
                        case "3":
                            System.out.println("Invalid Choice");
                            break;
                    }
                }

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
}
