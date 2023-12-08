import javax.swing.JOptionPane;

public class MultiUserController {
    public MultiUserController(User newUser) {
        processSignUp(newUser);
    }

    public void processSignUp(User newUser) {
        MultiUser multiUser = new MultiUser(newUser);
        if (!multiUser.isExist()) {
            System.out.println("존재함");
        } else
            JOptionPane.showMessageDialog(null, "아이디가 중복됩니다. 아이디를 다시 입력해 주세요.");
    }
}
