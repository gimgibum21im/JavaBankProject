import javax.swing.JOptionPane;

public class BankAccount {
    private boolean withdrawalStatus; // WDS
    private String accountNum;
    private String accountHolder;
    private int accountBalance;
    private String password;

    public BankAccount(boolean newWDS, String newAccountNum, String newAccountHolder, int newAccountBalance,
            String newPw) {
        withdrawalStatus = newWDS;
        accountNum = newAccountNum;
        accountHolder = newAccountHolder;
        accountBalance = newAccountBalance;
        password = newPw;
    }

    public boolean deposit(int amount) {
        boolean result = false;
        if (amount < 0)
            JOptionPane.showMessageDialog(null, "잘못된 입금액이라 무시합니다.");
        else {
            accountBalance += amount;
            result = true;
        }
        return result;
    }

    public boolean withdraw(int amount) {
        boolean result = false;
        if (amount < 0)
            JOptionPane.showMessageDialog(null, "잘못된 출금액이라 무시합니다.");
        else if (amount > accountBalance)
            JOptionPane.showMessageDialog(null, "잔고가 부족합니다.");
        else {
            accountBalance -= amount;
            result = true;
        }
        return result;
    }

    public boolean getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getPw() {
        return password;
    }

}