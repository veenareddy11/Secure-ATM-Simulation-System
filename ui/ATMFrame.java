package ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

import dao.AccountDAO;
import service.ATMService;

public class ATMFrame extends JFrame {

    int accNo;

    public ATMFrame(int accNo) {
        this.accNo = accNo;

        // ===== Window Settings =====
        setTitle("Secure ATM System");
        setSize(380, 330);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // ===== Title =====
        JLabel title = new JLabel("SECURE ATM SYSTEM", JLabel.CENTER);
        title.setBounds(50, 10, 280, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        // ===== Buttons =====
        JButton balBtn = new JButton("Balance Enquiry");
        balBtn.setBounds(110, 60, 160, 30);
        add(balBtn);

        JButton withdrawBtn = new JButton("Withdraw Cash");
        withdrawBtn.setBounds(110, 100, 160, 30);
        add(withdrawBtn);

        JButton depositBtn = new JButton("Deposit Cash");
        depositBtn.setBounds(110, 140, 160, 30);
        add(depositBtn);

        JButton miniBtn = new JButton("Mini Statement");
        miniBtn.setBounds(110, 180, 160, 30);
        add(miniBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(110, 220, 160, 30);
        add(exitBtn);

        // ===== Font Styling =====
        Font btnFont = new Font("Segoe UI", Font.BOLD, 13);
        balBtn.setFont(btnFont);
        withdrawBtn.setFont(btnFont);
        depositBtn.setFont(btnFont);
        miniBtn.setFont(btnFont);
        exitBtn.setFont(btnFont);

        // ===== Button Colors =====
        balBtn.setBackground(new Color(0, 153, 255));
        balBtn.setForeground(Color.WHITE);

        withdrawBtn.setBackground(new Color(255, 102, 102));
        withdrawBtn.setForeground(Color.WHITE);

        depositBtn.setBackground(new Color(102, 204, 102));
        depositBtn.setForeground(Color.WHITE);

        miniBtn.setBackground(new Color(255, 204, 102));

        exitBtn.setBackground(Color.LIGHT_GRAY);

        // ===== Backend Objects =====
        AccountDAO dao = new AccountDAO();
        ATMService service = new ATMService();

        // ===== Button Actions =====

        // Balance
        balBtn.addActionListener(e -> {
            try {
                double bal = dao.getBalance(accNo);
                JOptionPane.showMessageDialog(
                        this,
                        "Available Balance: ₹" + bal,
                        "Balance Enquiry",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error fetching balance");
            }
        });

        // Withdraw
        withdrawBtn.addActionListener(e -> {
            try {
                String amt = JOptionPane.showInputDialog(
                        this,
                        "Enter withdrawal amount:"
                );
                if (amt != null) {
                    service.withdraw(accNo, Double.parseDouble(amt));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        // Deposit
        depositBtn.addActionListener(e -> {
            try {
                String amt = JOptionPane.showInputDialog(
                        this,
                        "Enter deposit amount:"
                );
                if (amt != null) {
                    service.deposit(accNo, Double.parseDouble(amt));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        // Mini Statement
        miniBtn.addActionListener(e -> {
            try {
                StringBuilder sb = new StringBuilder();
                var rs = dao.getMiniStatement(accNo);

                sb.append("DATE\t\tTYPE\tAMOUNT\n");
                sb.append("----------------------------------------\n");

                while (rs.next()) {
                    sb.append(rs.getString("txn_date")).append("\t")
                      .append(rs.getString("type")).append("\t")
                      .append(rs.getDouble("amount")).append("\n");
                }

                JOptionPane.showMessageDialog(
                        this,
                        sb.toString(),
                        "Mini Statement",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to fetch statement");
            }
        });

        // Exit
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Thank you for using Secure ATM 🙏");
            dispose();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
