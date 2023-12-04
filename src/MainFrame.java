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

        // 익명 클래스 test
        JButton testBtn = new JButton("testBtn");
        cp.add(testBtn);
        testBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");

                dispose(); // 현재 frame창 닫음

                // 새 프레임 생성 테스트 및 설정
                JFrame testP = new JFrame();
                setTitle("MainFrame");
                testP.setSize(500, 500);
                testP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                testP.setVisible(true);
            }
        });

        // MainFrame 설정
        setTitle("MainFrame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
