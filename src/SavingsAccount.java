public class SavingsAccount extends BankAccount {
    private int TOTAL_DEPOSIT_COUNT;
    private int currentDepositCount;
    private boolean doneImplement; // impement를 받아는지
    private final double RATE = 0.4;

    // TDC = TOTAL_DEPOSIT_COUNT
    // CDC = currentDepositCount
    public SavingsAccount(boolean newWDS, String newAccountNum, String newAccountHolder, double newAccountBalance,
            int newTDC, int newCDC, boolean newDoneImplement) {
        super(newWDS, newAccountNum, newAccountHolder, newAccountBalance);
        TOTAL_DEPOSIT_COUNT = newTDC;
        currentDepositCount = newCDC;
        doneImplement = newDoneImplement;
    }

    public void implement() {
        accountBalance += getAccountBalance() * (RATE * (double) (TOTAL_DEPOSIT_COUNT / 12));
    }

    public boolean compareDepositCount() {
        if (currentDepositCount == TOTAL_DEPOSIT_COUNT && !doneImplement) {
            doneImplement = true;
            return true;
        }
        return false;
    }
}