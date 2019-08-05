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

        //TODO: (Any) --> (OP) edges of the D.F.A
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
                //TODO: send user total bill since the last state change
                RegularUser temp = (RegularUser)u;
                if(temp.isPayingForServerDown())
                    u.update(context,"Bill:"+u.getBill()+" since last change");
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
                //TODO: send user total bill since the last state change
                RegularUser temp = (RegularUser)u;
                if(temp.isPayingForServerDown())
                    u.update(context,"Bill:"+u.getBill()+" since last change");
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
