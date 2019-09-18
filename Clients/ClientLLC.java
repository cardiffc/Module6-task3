package Clients;

public class ClientLLC extends Client {
    private final double COMISSION = 1;
    public ClientLLC(int accNumber, double accAmount) {
        super(accNumber, accAmount);
    }

    public void setAccAmount (double amount) {
        double actualAmount = amount < 0 ? (actualAmount = amount + (amount / 100) * COMISSION) : amount ;
        super.setAccAmount(actualAmount);
    }
}
