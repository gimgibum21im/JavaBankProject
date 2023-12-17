public class SavingsAccount extends BankAccount {
    private int TOTAL_DEPOSIT_COUNT;
    private int currentDepositCount;

    // TDC = TOTAL_DEPOSIT_COUNT
    // CDC = currentDepositCount
    public SavingsAccount(boolean newWDS, String newAccountNum, String newAccountHolder, int newAccountBalance,
            int newTDC, int newCDC) {
        super(newWDS, newAccountNum, newAccountHolder, newAccountBalance);
        TOTAL_DEPOSIT_COUNT = newTDC;
        currentDepositCount = newCDC;
    }
}