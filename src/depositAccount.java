public class DepositAccount extends BankAccount {
    public DepositAccount(boolean newWDS, String newAccountNum, double newAccountBalance) {
        super(newWDS, newAccountNum, newAccountBalance);
    }

    public DepositAccount(boolean newWDS) {
        super(newWDS);
    }
}
