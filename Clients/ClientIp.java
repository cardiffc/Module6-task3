package Clients;

public class ClientIp extends Client {
    private final double SMALL_COMMISSION = 0.5;
    private final double COMMISSION = 1;

    public ClientIp(int accNumber, double accAmount) {
        super(accNumber, accAmount);
    }

    public void setAccAmount (double amount)
    {
        double actualAmount;
        if (amount > 0 && amount < 1000)
        {
            actualAmount = amount - (amount / 100) * COMMISSION;
        }
        else if (amount > 0 && amount >= 1000)
        {
            actualAmount = amount - (amount / 100) * SMALL_COMMISSION;
        }
        else {
            actualAmount = amount;
        }
        super.setAccAmount(actualAmount);
    }
}
