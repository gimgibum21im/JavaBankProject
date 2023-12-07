import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SingUpPage extends JFrame {
    private JLabel lblId;
    private JLabel lblPw;
    private JButton btnSignUp;
    private JTextField tfId;
    private JPasswordField tfPw;

    public SingUpPage() {
        init();
        setDisplay();
        addListeners();
        showFrame();
    }

    public void init() {
        // 사이즈 통일화
        Dimension lblSize = new Dimension(80, 30);
        Dimension btnSize = new Dimension(90, 80);
        int tfSize = 10;

        // ID, PW 레이블 생성
        lblId = new JLabel("ID");
        lblId.setPreferredSize(lblSize);
        lblPw = new JLabel("Password");
        lblPw.setPreferredSize(lblSize);

        // ID, PW 텍스트 생성
        tfId = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);

        // 회원가입 버튼 생성
        btnSignUp = new JButton("회원가입");
        btnSignUp.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlWest(pnlId, pnlPw)
        JPanel pnlWest = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(lblId);
        pnlId.add(tfId);

        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        pnlWest.add(pnlId);
        pnlWest.add(pnlPw);

        JPanel pnlEast = new JPanel();
        pnlEast.add(btnSignUp);

        // 공백 생성
        pnlWest.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlEast.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 패널 배치위치
        add(pnlWest, BorderLayout.WEST);
        add(pnlEast, BorderLayout.EAST);
    }

    public void addListeners() {

        // 회원가입 버튼 리스너
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 창 열기
                new SingUpPage();
                dispose(); // 창닫기
                System.out.println("signUp");
            }
        });
    }

    public void showFrame() {
        setTitle("Sign up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // component에 맞게 창 생성
        setLocationRelativeTo(null); // 화면 가운데 생성
        setVisible(true);
    }
}
