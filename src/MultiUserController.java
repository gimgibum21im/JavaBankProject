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

    public void processLogin() {
        MultiUser multiUser = new MultiUser(user);
        if (multiUser.isExist()) {
            System.out.println("존재하지 않음");
        } else
            JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다.");
    }
}
