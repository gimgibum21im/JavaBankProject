import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiUser {
    // UserDB, AccouuntDB 관리
    private String fPathUserDB = "DB\\UserDB.txt";
    private User user;
    private String line;

    public MultiUser(User newUser) {
        user = newUser;
    }

    /** UserDB안에 사용자가 존재하는지 알려주는 메소드 */
    public boolean isExist() {
        try {
            BufferedReader UserDB = new BufferedReader(new FileReader(fPathUserDB));

            while (true) {
                line = UserDB.readLine();
                if (line == null)
                    break;

                String id = line.split("\\s+")[0];
                if (user.getId().equals(id)) {
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
}
