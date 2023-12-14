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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SingUpPage extends JFrame {
    private JLabel lblId;
    private JLabel lblPw;
    private JLabel lblName;
    private JButton btnBack;
    private JButton btnSignUp;
    private JTextField tfId;
    private JTextField tfName;
    private JPasswordField tfPw;

    private MultiUserController multiUserController;

    public SingUpPage() {
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
        lblName = new JLabel("이름");
        lblName.setPreferredSize(lblSize);

        // ID, PW 텍스트 생성
        tfId = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);
        tfName = new JTextField(tfSize);

        // 뒤로가기 버튼 생성
        btnBack = new JButton("뒤로가기");
        btnBack.setPreferredSize(btnSize);

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

        JPanel pnlName = new JPanel(flowLeft);
        pnlName.add(lblName);
        pnlName.add(tfName);

        pnlNorth.add(pnlId);
        pnlNorth.add(pnlPw);
        pnlNorth.add(pnlName);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnBack);
        pnlSouth.add(btnSignUp);

        // 공백 생성
        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 패널 배치위치
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    public void addListeners() {
        // 뒤로가기 버튼 리스너
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 창 열기
                new LoginPage();
                dispose(); // 창닫기
                System.out.println("login");
            }
        });

        // 회원가입 버튼 리스너
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isBlank()) {
                    User newUser = new User(getTfId(), getTfPw(), getTfName());
                    multiUserController = new MultiUserController(newUser);
                    if (multiUserController.processSignUp()) {
                        new LoginPage();
                        dispose();
                    }
                }
            }
        });
    }

    public String getTfId() {
        return tfId.getText();
    }

    public String getTfPw() {
        return String.valueOf(tfPw.getPassword());
    }

    public String getTfName() {
        return tfName.getText();
    }

    public boolean isBlank() {
        boolean result = false;
        // requestFocus 해당 tf로 강제로 이동
        if (tfId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
            tfId.requestFocus();
            return true;
        }
        if (String.valueOf(tfPw.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
            tfPw.requestFocus();
            return true;
        }
        if (tfName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
            tfName.requestFocus();
            return true;
        }
        return result;
    }

    public void showFrame() {
        setTitle("Sign up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // component에 맞게 창 생성
        setLocationRelativeTo(null); // 화면 가운데 생성
        setVisible(true);
    }
}