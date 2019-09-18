package Clients;

public class ClientIp extends Client {
    public ClientIp(int accNumber, double accAmount) {
        super(accNumber, accAmount);
    }
    public void setAccAmount (double amount)
    {
        double actualComission = amount < 1000 ? 1 : 0.5;
        double actualAmount = amount;
        actualAmount = amount >= 0 ? (amount - (amount / 100) * actualComission) : amount;
        super.setAccAmount(actualAmount);
    }
}
