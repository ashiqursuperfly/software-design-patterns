package observer;

public class PremiumUser implements User {

    private String email, currentServiceProviderCompany;

    private float bill = (float) Math.PI;

    public PremiumUser(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getType() { return getClass().getSimpleName(); }

    @Override
    public void update(ServerProviderCompany source,String message) {
        System.out.println("Notification From :"+source.getClass().getSimpleName()+" To:"+email +" Message:"+ message);
    }

    @Override
    public float getBill() {
        return bill;
    }


    public String getCurrentServiceProviderCompany() {
        return currentServiceProviderCompany;
    }

    public void setCurrentServiceProviderCompany(String currentServiceProviderCompany) {
        this.currentServiceProviderCompany = currentServiceProviderCompany;
    }
}
