import java.util.Random;

import javax.swing.JOptionPane;

public class BankAccount {
    private boolean withdrawalStatus; // WDS
    private String accountNum;
    public double accountBalance;

    /**
     * 
     * @param newWDS            withdroawalStauts 출금 가능여부
     * @param newAccountNum
     * @param newAccountBalance
     */
    public BankAccount(boolean newWDS, String newAccountNum, double newAccountBalance) {
        withdrawalStatus = newWDS;
        accountNum = newAccountNum;
        accountBalance = newAccountBalance;
    }

    /**
     * 
     * @param newWDS withdroawalStauts 출금 가능여부
     */
    public BankAccount(boolean newWDS) {
        Random rd = new Random();

        String newAccountNum = "";
        for (int i = 0; i < 5; i++) {
            newAccountNum += rd.nextInt(10) + "";
        }
        int newAccountBalance = 0;

        withdrawalStatus = newWDS;
        accountNum = newAccountNum;
        accountBalance = newAccountBalance;
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

    public double getAccountBalance() {
        return accountBalance;
    }

}