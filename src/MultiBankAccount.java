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

    public BankAccount[] getDBInfo(String UserAccountInfo[]) {
        int uasLen = UserAccountInfo.length;
        BankAccount dbBankAccount[] = new BankAccount[uasLen];

        int cnt = 0;
        try {
            BufferedReader AccountDB = new BufferedReader(new FileReader(fPathAccountDB));

            while (true) {
                String temp = AccountDB.readLine();
                if (temp == null)
                    break;

                String[] line = temp.split("\\s+");
                for (String account : UserAccountInfo) {
                    if (account.equals(line[0])) {
                        if (Boolean.parseBoolean(line[1])) { // 예금
                            DepositAccount dbAccount = new DepositAccount(Boolean.parseBoolean(line[1]), line[0],
                                    Double.parseDouble(line[2]));
                            dbBankAccount[cnt] = dbAccount;
                            break;
                        } else {// 적금
                            SavingsAccount dbAccount = new SavingsAccount(Boolean.parseBoolean(line[1]), line[0],
                                    Double.parseDouble(line[2]), Integer.parseInt(line[3]),
                                    Integer.parseInt(line[4]), Boolean.parseBoolean(line[5]));
                            dbBankAccount[cnt] = dbAccount;
                            break;
                        }
                    }
                }
                cnt++;
            } // while 끝

            AccountDB.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbBankAccount;
    }
}