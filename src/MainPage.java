import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainPage extends JFrame {
    public MainPage() {
        Container cp = getContentPane();
        setTitle("MainPage");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 로그인 버튼 생성
        JButton loginBtn = new JButton("로그인");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 창 열기
                dispose(); // 창닫기
                System.out.println("login");
            }
        });

        // 회원가입 버튼 생성
        JButton signUpBtn = new JButton("회원가입");
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 창 열기
                dispose(); // 창닫기
                System.out.println("signUp");
            }
        });

        // 버튼 add
        cp.add(loginBtn);
        cp.add(signUpBtn);

        // MainPage 설정
        setLayout(new FlowLayout());
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainPage();
    }
}