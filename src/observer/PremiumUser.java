package observer;

public class PremiumUser implements User {

    private String email;

    public PremiumUser(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getType() { return getClass().getSimpleName(); }
}
