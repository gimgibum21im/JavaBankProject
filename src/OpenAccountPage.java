import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OpenAccountPage extends JFrame {
    private JButton btnDeposit;
    private JButton btn6Savings;
    private JButton btn12Savings;
    private JButton btnBack;

    private MultiUserController multiUserController;

    public OpenAccountPage(MultiUserController muc) {
        multiUserController = muc;
        init();
        setDisplay();
        addListeners();
        showFrame();
    }

    public void init() {
        // 사이즈 통일화
        Dimension btnSize = new Dimension(200, 50);

        // 예금 개설 버튼 생성
        btnDeposit = new JButton("예금");
        btnDeposit.setPreferredSize(btnSize);

        // 6개월 적금 개설 버튼 생성
        btn6Savings = new JButton("6개월 적금");
        btn6Savings.setPreferredSize(btnSize);

        // 12개월 적금 개설 버튼 생성
        btn12Savings = new JButton("12개월 적금");
        btn12Savings.setPreferredSize(btnSize);

        // 뒤로가기 버튼 생성
        btnBack = new JButton("뒤로가기");
        btnBack.setPreferredSize(btnSize);
    }

    public void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        JPanel pnl = new JPanel(flowLeft);
        pnl.add(btnDeposit);
        pnl.add(btn6Savings);
        pnl.add(btn12Savings);
        pnl.add(btnBack);

        // 공백 생성
        pnl.setBorder(new EmptyBorder(0, 0, 0, 10));

        // 패널 배치위치
        add(pnl, BorderLayout.SOUTH);
    }

    public void addListeners() {

        // 예금 개설 버튼 리스너
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // 6개월 적금 개설 버튼 리스너
        btn6Savings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // 창닫기
            }
        });

        // 12개월 적금 버튼 리스너
        btn12Savings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // 뒤로가기 버튼 리스너
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AfterLoginPage(multiUserController);
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