package observer;

import java.util.List;
import java.util.Scanner;

class FullyDownState implements State {

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
        //(Any) --> (FD) edges of the D.F.A
        switch (context.getPreviousState().getStateID()) {
            case "PartiallyDownState":
                fromPartiallyDown();
                break;
            case "OperationalState":
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
        List<User> subscribers = context.getSubscribers();

        for (User u :
                subscribers) {
            if (u instanceof PremiumUser) {

                PremiumUser temp = (PremiumUser)u;

                if(temp.getCurrentServiceProviderCompany().equals(ABCCompany.class.getSimpleName()+","+DEFCompany.class.getSimpleName())){
                    DEFCompany.getInstance().subscribe(u);
                    u.update(context, "Hello :" + u.getEmail() + "\nABC's Server Went fully down temporarily." +
                            "Previously You Were using Combined Service from ABC & DEF.\n Now, you'll be using full service from DEF");
                }
                else {
                    u.update(context, "Hello :" + u.getEmail() + "\nABC's Server Went fully down temporarily" +
                            " but since you are a premium user you can enjoy uninterrupted service provided by DEF");
                }

            }

        }
    }

    private void fromOperational() {
        List<User> subscribers = context.getSubscribers();

        for (User u:
                subscribers) {
            if(u instanceof PremiumUser){
                u.update(context,"Hello :"+u.getEmail()+"\nABC's Server Went fully down temporarily" +
                        " but since you are a premium user you can enjoy uninterrupted service provided by DEF");
            }
            else if(u instanceof RegularUser){
                u.update(context,"Hello :"+u.getEmail());
                RegularUser temp = (RegularUser)u;
                Scanner sc = new Scanner(System.in);
                boolean input = true;
                while (input){
                    System.out.println("Sorry,ABC's Server went fully down.Do You Want to Pay 20$/h Extra for uninterrupted service(provided by DEF)?\n" +
                            "1.YES 2.NO\n");
                    String choice = sc.nextLine();

                    switch (choice){
                        case "1":
                            input = false;
                            temp.setPayingForServerDown(true);
                            temp.update(context,"Congrats. You are now receiving service from DEF");
                            DEFCompany.getInstance().subscribe(temp);
                            break;
                        case "2":
                            input = false;
                            temp.setPayingForServerDown(false);
                            temp.update(context,"Your service will remain interrupted temporarily");
                            break;
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
