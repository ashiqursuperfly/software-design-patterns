package observer;

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
                //TODO:
                break;
            case "Operational":
                //TODO:
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
}
