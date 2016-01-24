package bankaccount;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccountManager {

    private static final Lock lock = new ReentrantLock();
    private Condition myCond = lock.newCondition();
    BankAccount myAccount;
    private static final BankLogger log = new BankLogger();

    public BankAccountManager(BankAccount myAccount) {
        this.myAccount = myAccount;
    }

    public void amountWithdrawn(double money_Withdrawn)
            throws InterruptedException {
        lock.lock();
        try {
            if (money_Withdrawn > myAccount.getAccount()) {
                myCond.await();
            }

            System.out.println("Amount Withdrawn is " + money_Withdrawn);
            myAccount.withdraw(money_Withdrawn);
            System.out.println("Total Amount is " + myAccount.getAccount());
        } finally {
            lock.unlock();
        }
    }

    public void amountDeposited(double money_deposited)
            throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Amount Deposited is " + money_deposited);
            myAccount.deposit(money_deposited);
            System.out.println("Total Amount is " + myAccount.getAccount());
            myCond.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
