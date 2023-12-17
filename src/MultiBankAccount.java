import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiBankAccount {
    private String fPathAccountDB = "DB\\AccountDB.txt";
    private BankAccount bankAccount;

    /** 개설용 */
    public MultiBankAccount(BankAccount newBankAccount) {
        bankAccount = newBankAccount;
    }

    public void addAccount() {
        try {
            PrintWriter AccountDB = new PrintWriter(new FileWriter(fPathAccountDB, true));
            String str;
            try {
                DepositAccount temDepositAccount = (DepositAccount) bankAccount;
                str = temDepositAccount.toString();
            } catch (Exception e) {
                SavingsAccount tempSavingsAccount = (SavingsAccount) bankAccount;
                str = tempSavingsAccount.toString();
            }
            AccountDB.println(str);
            AccountDB.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}