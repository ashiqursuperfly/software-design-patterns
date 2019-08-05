package observer;

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
                //TODO:
                break;
            case "FullyDown":
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
