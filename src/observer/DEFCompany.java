package observer;

import java.util.ArrayList;
import java.util.List;

public class DEFCompany implements ServerProviderCompany {

    private static DEFCompany instance = new DEFCompany();
    private State currentState, previousState;

    private List<User> subscribers;

    private DEFCompany() {

        currentState = States.operationalState;
        subscribers = new ArrayList<>();
    }

    public static DEFCompany getInstance() {
        return instance;
    }

    @Override
    public boolean subscribe(User user) {
        return subscribers.add(user);
    }

    @Override
    public boolean unSubscribe(User user) {
        return subscribers.remove(user);
    }

    @Override
    public List<User> getSubscribers() {
        return subscribers;
    }

    @Override
    public void switchState(State currentState) {
        this.previousState = this.currentState;
        this.previousState.setContext(null);
        this.currentState = currentState;
        this.currentState.setContext(this);
        notifyAllSubscribers();
    }

    @Override
    public void notifyAllSubscribers() {
        this.currentState.stateSpecificBehaviour();
    }

    @Override
    public State getPreviousState() {
        return previousState;
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }
}
