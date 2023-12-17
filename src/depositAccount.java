public class DepositAccount extends BankAccount {
    public DepositAccount(boolean newWDS, String newAccountNum, String newAccountHolder, double newAccountBalance) {
        super(newWDS, newAccountNum, newAccountHolder, newAccountBalance);
    }

    public DepositAccount(boolean newWDS, String newAccountHolder) {
        super(newWDS, newAccountHolder);
    }
}
