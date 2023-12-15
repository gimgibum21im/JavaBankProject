import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiUser {
    // UserDB, AccouuntDB 관리
    private String fPathUserDB = "DB\\UserDB.txt";
    private User user;
    private String line[];
    private String userId;
    private String userPw;

    public MultiUser(User newUser) {
        user = newUser;
    }

    /** UserDB안에 사용자가 존재하는지 알려주는 메소드 */
    public boolean isExist() {
        try {
            BufferedReader UserDB = new BufferedReader(new FileReader(fPathUserDB));

            while (true) {
                line = UserDB.readLine().split("\\s+");
                if (line == null)
                    break;

                userId = line[0];
                if (user.getId().equals(userId)) {
                    UserDB.close();
                    return true;
                }
            }

            UserDB.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser() {
        try {
            PrintWriter UserDB = new PrintWriter(new FileWriter(fPathUserDB, true));
            UserDB.println(user.toString()); // Id, PW, Name, 계좌수, 계좌
            UserDB.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public boolean checkPw() {
        userPw = line[1];

        if (userPw.equals(user.getPw()))
            return true;
        return false;
    }

    public User getDBUserInfo() {
        User dbUser;
        String userName = line[2];

        int accountCnt = Integer.parseInt(line[3]);
        if (accountCnt == 0) {
            dbUser = new User(userId, userPw, userName);
        }

        else {
            String accountSeqs = "";
            for (int i = 4; i < 3 + accountCnt; i++) {
                accountSeqs += line[i];
                accountSeqs += " ";
                System.out.println(accountSeqs);
            }
            accountSeqs += line[3 + accountCnt];

            dbUser = new User(userId, userPw, userName, Integer.toString(accountCnt), accountSeqs);
        }

        return dbUser;
    }
}
