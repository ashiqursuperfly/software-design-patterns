package clientCode;

import observer.*;

public class ServerProviderMain {
    public static void main(String[] args) {

        ABCCompany abcCompany = new ABCCompany();
        abcCompany.subscribe(new RegularUser("r1@gmail.com"));
        abcCompany.subscribe(new RegularUser("r2@gmail.com"));
        abcCompany.subscribe(new PremiumUser("p1@gmail.com"));
        abcCompany.subscribe(new PremiumUser("p2@gmail.com"));

        abcCompany.switchState(States.partiallyDownState);
        abcCompany.switchState(States.operationalState);

        abcCompany.switchState(States.fullyDownState);
        abcCompany.switchState(States.operationalState);

        abcCompany.switchState(States.partiallyDownState);
        abcCompany.switchState(States.fullyDownState);
        abcCompany.switchState(States.partiallyDownState);



    }
}
