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

public class DWPage extends JFrame {
    private JLabel lblAmount;
    private JButton btnDeposit;
    private JButton btnWithdraw;
    private JTextField tfAmount;

    private MultiUserController multiUserController;
    private MultiBankAccountController multiBankAccountController;

    public DWPage(MultiUserController newMultiUserController,
            MultiBankAccountController newMultiBankAccountController) {
        multiUserController = newMultiUserController;
        multiBankAccountController = newMultiBankAccountController;
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
        lblAmount = new JLabel("금액");
        lblAmount.setPreferredSize(lblSize);

        // ID, PW 텍스트 생성
        tfAmount = new JTextField(tfSize);

        // 입금 버튼 생성
        btnDeposit = new JButton("입금");
        btnDeposit.setPreferredSize(btnSize);

        // 출금 버튼 생성
        btnWithdraw = new JButton("출금");
        btnWithdraw.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlNorth(pnlId, pnlPw)
        JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(lblAmount);
        pnlId.add(tfAmount);

        pnlNorth.add(pnlId);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnDeposit);
        pnlSouth.add(btnWithdraw);

        // 공백 생성
        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        // 패널 배치위치
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }

    public void addListeners() {

        // 입금 버튼 리스너
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 입금 창 열기
                if (!isBlank()) {
                    try {
                        multiBankAccountController.geBankAccount().deposit(Integer.parseInt(getTfAmount()));
                    } catch (Exception e1) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "금액을 숫자로 입력해주세요.");
                    }
                }
            }
        });

        // 출금 버튼 리스너
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isBlank()) {
                    try {
                        multiBankAccountController.geBankAccount().withdraw(Integer.parseInt(getTfAmount()));
                    } catch (Exception e1) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "금액을 숫자로 입력해주세요.");
                    }
                }
            }
        });
    }

    public String getTfAmount() {
        return tfAmount.getText();
    }

    public boolean isBlank() {
        boolean result = false;
        // requestFocus 해당 tf로 강제로 이동
        if (tfAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "금액을 입력해주세요.");
            tfAmount.requestFocus();
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
