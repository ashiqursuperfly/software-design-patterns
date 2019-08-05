package observer;

import java.util.List;

public class OperationalState implements State {

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

        //(Any) --> (OP) edges of the D.F.A
        switch (context.getPreviousState().getStateID()) {
            case "PartiallyDownState":
                fromPartiallyDown();
                break;
            case "FullyDownState":
                fromFullyDown();
                break;
            default:
                try {
                    throw new Exception("Invalid State Transition");
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                break;
        }

    }

    private void fromFullyDown() {

        List<User> subscribers = context.getSubscribers();

        for (User u:
             subscribers) {
            if(u instanceof RegularUser){
                u.update(context,"Hello :"+u.getEmail()+" ABC's Server is Back to Operational State");
                RegularUser temp = (RegularUser)u;
                if(temp.isPayingForServerDown()) {
                    u.update(context, "Bill:" + u.getBill() + " since last change");
                }
            }
            else if(u instanceof PremiumUser){
                // do nothing
                u.update(context,"Hello :"+u.getEmail()+" ABC's Server is Back to Operational State");
            }
            else {
                try {
                    throw new Exception("Invalid User Type:"+u.getType());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

    }

    private void fromPartiallyDown() {

        List<User> subscribers = context.getSubscribers();

        for (User u:
                subscribers) {
            if(u instanceof RegularUser){
                u.update(context,"Hello :"+u.getEmail()+" ABC's Server is Back to Operational State");
                RegularUser temp = (RegularUser)u;
                if(temp.isPayingForServerDown()) {
                    u.update(context, "Bill:" + u.getBill() + " since last change");
                }

            }
            else if(u instanceof PremiumUser){
                // do nothing
                u.update(context,"Hello :"+u.getEmail()+" ABC's Server is Back to Operational State");
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
