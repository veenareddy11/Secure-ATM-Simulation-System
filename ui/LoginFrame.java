package ui;

import javax.swing.*;
import dao.AccountDAO;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Secure ATM Login");
        setSize(300, 220);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel accLabel = new JLabel("Account No:");
        accLabel.setBounds(30, 30, 100, 25);
        add(accLabel);

        JTextField accField = new JTextField();
        accField.setBounds(130, 30, 120, 25);
        add(accField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(30, 70, 100, 25);
        add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(130, 70, 120, 25);
        add(pinField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 120, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            try {
                int acc = Integer.parseInt(accField.getText());
                int pin = Integer.parseInt(new String(pinField.getPassword()));

                AccountDAO dao = new AccountDAO();

                if (dao.validatePin(acc, pin)) {
                    JOptionPane.showMessageDialog(this, "Login Successful ✅");
                    new ATMFrame(acc);   // 👉 OPEN ATM MENU
                    dispose();           // 👉 CLOSE LOGIN WINDOW
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid PIN ❌");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error occurred");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
