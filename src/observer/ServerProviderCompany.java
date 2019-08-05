package observer;

import java.util.List;

public interface ServerProviderCompany {

    /** Observer Pattern's Subject Methods **/
    boolean subscribe(User user);

    boolean unSubscribe(User user);

    List<User> getSubscribers();

    void notifyAllSubscribers();

    /** State Pattern's StatefulObject Methods**/
    void switchState(State currentState);

    State getPreviousState();

    State getCurrentState();
}
