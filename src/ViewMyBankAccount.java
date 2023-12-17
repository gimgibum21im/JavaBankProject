import java.awt.BorderLayout;
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

public class ViewMyBankAccount extends JFrame {
    private JLabel lblBankAccount;
    private JLabel lblPw;
    private JButton btnConfirm;
    private JButton btnBack;
    private JTextField tfBankAccount;
    private JPasswordField tfPw;

    private MultiUserController multiUserController;

    public ViewMyBankAccount(MultiUserController nmuc) {
        multiUserController = nmuc;
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
        lblBankAccount = new JLabel("계좌번호");
        lblBankAccount.setPreferredSize(lblSize);
        lblPw = new JLabel("Password");
        lblPw.setPreferredSize(lblSize);

        // ID, PW 텍스트 생성
        tfBankAccount = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);

        // 확인 버튼 생성
        btnConfirm = new JButton("확인");
        btnConfirm.setPreferredSize(btnSize);

        // 뒤로가기 버튼 생성
        btnBack = new JButton("뒤로");
        btnBack.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlNorth(pnlId, pnlPw)
        JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(lblBankAccount);
        pnlId.add(tfBankAccount);

        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        pnlNorth.add(pnlId);
        pnlNorth.add(pnlPw);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnBack);
        pnlSouth.add(btnConfirm);

        // 공백 생성
        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 패널 배치위치
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    public void addListeners() {

        // 확인 버튼 리스너
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 확인 창 열기
                if (!isBlank()) {
                    if (getTfBankAccount().length() != 5)
                        JOptionPane.showMessageDialog(null, "계좌번호를 5자리로 입력해 주세요.");
                    else if (multiUserController.checkPw(getTfPw())) {
                        try {
                            int bankAccount = Integer.parseInt(getTfBankAccount());
                            new AfterLoginPage(multiUserController);
                            dispose(); // 창닫기
                        } catch (Exception e1) {
                            // TODO: handle exception
                            JOptionPane.showMessageDialog(null, "계좌번호를 숫자로 입력해 주세요.");
                        }
                    }
                }
            }
        });

        // 뒤로가기 버튼 리스너
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 뒤로가기 창 열기
                new AfterLoginPage(multiUserController);
                dispose(); // 창닫기
            }
        });
    }

    public String getTfBankAccount() {
        return tfBankAccount.getText();
    }

    public String getTfPw() {
        return String.valueOf(tfPw.getPassword());
    }

    public boolean isBlank() {
        boolean result = false;
        // requestFocus 해당 tf로 강제로 이동
        if (tfBankAccount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.");
            tfBankAccount.requestFocus();
            return true;
        }
        if (String.valueOf(tfPw.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
            tfPw.requestFocus();
            return true;
        }
        return result;
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