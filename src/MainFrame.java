import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.format.SignStyle;

public class MainFrame extends JFrame {

    public MainFrame() {
        Container cp = getContentPane(); // Frame 생성
        cp.setLayout(new FlowLayout());

        // JButton loginBtn = new JButton("로그인");
        // JButton signUpBtn = new JButton("회원가입");
        // cp.add(loginBtn);
        // cp.add(signUpBtn);

        LoginButton loginBtn = new LoginButton();
        cp.add(loginBtn);
        SignUpButton signUpBtn = new SignUpButton();
        cp.add(signUpBtn);

        // JFrame 설정
        setTitle("MainFrame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
