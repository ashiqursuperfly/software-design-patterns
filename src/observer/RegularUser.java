package observer;

public class RegularUser implements User {

    private String email;

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

}
