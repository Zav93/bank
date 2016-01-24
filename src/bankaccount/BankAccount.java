package bankaccount;

class BankAccount {

    private double total = 0;

    public void withdraw(double amount) {
        total -= amount;
    }

    public void deposit(double amount) {
        total += amount;
    }

    public double getAccount() {
        return total;

    }
}