package observer;

public class RegularUser implements User {

    private String email;

    private boolean isPayingForServerDown;

    private float bill = (float) Math.PI;

    public RegularUser(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getType() {
        return getClass().getSimpleName();
    }

    @Override
    public void update(ServerProviderCompany source,String message) {
        System.out.println("Notification From :"+source.getClass().getSimpleName() +" Message:"+ message);
    }

    @Override
    public float getBill() {
        return bill;
    }

    public boolean isPayingForServerDown() {
        return isPayingForServerDown;
    }

    public void setPayingForServerDown(boolean payingForServerDown) {
        isPayingForServerDown = payingForServerDown;
    }
}
