import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {
    private JLabel lblId;
    private JLabel lblPw;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JTextField tfId;
    private JPasswordField tfPw;

    public LoginPage() {
        init();
        setDisplay();
        addListeners();
        showFrame();
    }

    public void init() {
        // 사이즈 통일화
        Dimension lblSize = new Dimension(80, 30);
        Dimension btnSize = new Dimension(100, 25);
        int tfSize = 10;

        // ID, PW 레이블 생성
        lblId = new JLabel("ID");
        lblId.setPreferredSize(lblSize);
        lblPw = new JLabel("Password");
        lblPw.setPreferredSize(lblSize);

        // ID, PW 텍스트 생성
        tfId = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);

        // 로그인 버튼 생성
        btnLogin = new JButton("로그인");
        btnLogin.setPreferredSize(btnSize);

        // 회원가입 버튼 생성
        btnSignUp = new JButton("회원가입");
        btnSignUp.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlNorth(pnlId, pnlPw)
        JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(lblId);
        pnlId.add(tfId);

        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        pnlNorth.add(pnlId);
        pnlNorth.add(pnlPw);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnSignUp);

        // 공백 생성
        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 패널 배치위치
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    public void addListeners() {

        // 로그인 버튼 리스너
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 창 열기
                dispose(); // 창닫기
                System.out.println("login");
            }
        });

        // 회원가입 버튼 리스너
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 창 열기
                new SingUpPage();
                dispose(); // 창닫기
            }
        });
    }

    public void showFrame() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // component에 맞게 창 생성
        setLocationRelativeTo(null); // 화면 가운데 생성
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}