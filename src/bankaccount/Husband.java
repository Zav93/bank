package bankaccount;

import java.util.logging.Level;
import java.util.logging.Logger;

class Husband implements Runnable {

    private BankAccountManager manager;
    private double amount_deposit;
    private double amount_withdraw;

    public Husband(BankAccountManager manager, double amount_deposit,
                   double amount_withdraw) {
        this.manager = manager;
        this.amount_deposit = amount_deposit;
        this.amount_withdraw = amount_withdraw;
    }

    public void run() {
        try {
            manager.amountDeposited(amount_deposit);
            manager.amountWithdrawn(amount_withdraw);
        } catch (InterruptedException ex) {
            Logger.getLogger(Wife.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}