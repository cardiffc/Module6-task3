package Clients;

public abstract class Client {
    private int accNumber;
    private double accAmount;

    public Client (int accNumber, double accAmount)
    {
        this.accNumber = accNumber;
        this.accAmount = accAmount;
    }
    public void setAccAmount (double amount)
    {
        if (amount >= 0)
        {
            this.accAmount += amount;
        } else {
            setWdAmount(amount);
        }
    }

    public void setWdAmount (double amount)
    {
        if (Math.abs(amount) <= this.accAmount)
        {
            this.accAmount += amount;
        }
        else {
            System.out.println("Недостаточно средств");
        }
    }
    public double getAccAmount ()
    {
        return accAmount;
    }
}
