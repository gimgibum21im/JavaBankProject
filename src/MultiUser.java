import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiUser {
    // UserDB, AccouuntDB 관리
    String fPathUserDB = "DB\\UserDB.txt";
    User user;

    public MultiUser(User newUser) {
        user = newUser;
    }

    public boolean isExist() {
        try {
            BufferedReader UserDB = new BufferedReader(new FileReader(fPathUserDB));
            while (true) {
                String line = UserDB.readLine();
                if (line == null)
                    break;
                String id = line.split("\\s+")[0];
                if (user.getId().equals(id))
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser() {
        try {
            PrintWriter pw = new PrintWriter(fPathUserDB);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
