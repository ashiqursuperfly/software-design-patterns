package observer;

public interface User {

    String getEmail();

    String getType();

    void update(ServerProviderCompany source,String message);

    float getBill();
}
