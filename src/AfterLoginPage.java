import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AfterLoginPage extends JFrame {
    private JButton btnViewAccount;
    private JButton btnOpenAccount;
    private JButton btnLogOut;

    private MultiUserController multiUserController;

    public AfterLoginPage(MultiUserController muc) {
        multiUserController = muc;
        init();
        setDisplay();
        addListeners();
        showFrame();
    }

    public void init() {
        // 사이즈 통일화
        Dimension btnSize = new Dimension(200, 50);

        // 내 계좌 보기 버튼 생성
        btnViewAccount = new JButton("내 계좌 보기");
        btnViewAccount.setPreferredSize(btnSize);

        // 계좌 개설 버튼 생성
        btnOpenAccount = new JButton("계좌 개설");
        btnOpenAccount.setPreferredSize(btnSize);

        // 로그아웃 버튼 생성
        btnLogOut = new JButton("로그아웃");
        btnLogOut.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        JPanel pnl = new JPanel(flowLeft);
        pnl.add(btnViewAccount);
        pnl.add(btnOpenAccount);
        pnl.add(btnLogOut);

        // 공백 생성
        pnl.setBorder(new EmptyBorder(0, 0, 0, 10));

        // 패널 배치위치
        add(pnl, BorderLayout.SOUTH);
    }

    public void addListeners() {

        // 내 계좌 보기 버튼 리스너
        btnViewAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 내 계좌 보기 창 열기
                new ViewMyBankAccount(multiUserController);
                dispose();
            }
        });

        // 계좌 개설 버튼 리스너
        btnOpenAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 계좌 개설 창 열기
                new OpenAccountPage(multiUserController);
                dispose(); // 창닫기
            }
        });

        // 로그아웃 버튼 리스너
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                dispose();
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