public class MultiBankAccount {
    private boolean withdrawalStatus; // WDS
    private String accountNum;
    private String accountHolder;
    private int accountBalance;
    private String password;

    public MultiBankAccount(boolean newWDS, String newAccountNum, String newAccountHolder, int newAccountBalance,
            String newPw) {
        withdrawalStatus = newWDS;
        accountNum = newAccountNum;
        accountHolder = newAccountHolder;
        accountBalance = newAccountBalance;
        password = newPw;
    }

    public boolean deposit(int amount) {
        if (amount <= 0)
            return false;
        else {
            accountBalance += amount;
            return true;
        }
    }

}