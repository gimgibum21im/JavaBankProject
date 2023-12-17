public class SavingsAccount extends BankAccount {
    private int TOTAL_DEPOSIT_COUNT;
    private int currentDepositCount;
    private boolean doneImplement; // impement를 받아는지
    private final double RATE = 0.4;

    // TDC = TOTAL_DEPOSIT_COUNT
    // CDC = currentDepositCount
    public SavingsAccount(boolean newWDS, String newAccountNum, double newAccountBalance,
            int newTDC, int newCDC, boolean newDoneImplement) {
        super(newWDS, newAccountNum, newAccountBalance);
        TOTAL_DEPOSIT_COUNT = newTDC;
        currentDepositCount = newCDC;
        doneImplement = newDoneImplement;
    }

    /** 개설용 */
    public SavingsAccount(boolean newWDS, int newTDC) {
        super(newWDS);
        TOTAL_DEPOSIT_COUNT = newTDC;
        currentDepositCount = 0;
        doneImplement = false;
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

    public String toString() {
        return Boolean.toString(getWithdrawalStatus()) + " " + getAccountNum() + " " + getAccountBalance() + " "
                + Boolean.toString(doneImplement) + " " + TOTAL_DEPOSIT_COUNT + " " + currentDepositCount;
    }
}