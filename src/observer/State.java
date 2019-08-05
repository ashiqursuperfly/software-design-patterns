package observer;

interface State {
    String getStateID();
    void setContext(ServerProviderCompany statefulObject);
    void stateSpecificBehaviour();
}
