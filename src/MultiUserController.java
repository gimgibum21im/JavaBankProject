import javax.swing.JOptionPane;

public class MultiUserController {
    private User user;

    public MultiUserController(User newUser) {
        user = newUser;
    }

    public boolean processSignUp() {
        MultiUser multiUser = new MultiUser(user);
        if (!multiUser.isExist()) {
            System.out.println("존재하지 않음");
            multiUser.addUser();
            return true;
        } else
            JOptionPane.showMessageDialog(null, "아이디가 중복됩니다. 아이디를 다시 입력해 주세요.");
        return false;
    }

    public boolean processLogin() {
        MultiUser multiUser = new MultiUser(user);
        if (multiUser.isExist()) {
            System.out.println("존재하지 함");

            if (multiUser.checkPw()) {
                System.out.println("pw 맞음");
                setUser(multiUser.getDBUserInfo());
                System.out.println("dbUser 가져옴");
                return true;
            } else
                JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
        } else
            JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다.");
        return false;
    }

    public void setUser(User newUser) {
        System.out.println("setuser");
        user = newUser;
    }

    public void addAccountNum2User(BankAccount newAccount) {
        user.addAccount(newAccount);
    }
}
