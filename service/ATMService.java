package service;

import dao.AccountDAO;

public class ATMService {

    AccountDAO dao = new AccountDAO();

    // Withdraw money
    public void withdraw(int accNo, double amount) throws Exception {
        double balance = dao.getBalance(accNo);

        if (amount <= 0) {
            System.out.println("Invalid amount ❌");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance ❌");
        } else {
            dao.updateBalance(accNo, balance - amount);
            System.out.println("Withdrawal successful ✅");
            dao.saveTransaction(accNo, "Withdraw", amount);

        }
    }

    // Deposit money
    public void deposit(int accNo, double amount) throws Exception {
        if (amount <= 0) {
            System.out.println("Invalid amount ❌");
            return;
        }

        double balance = dao.getBalance(accNo);
        dao.updateBalance(accNo, balance + amount);
        System.out.println("Deposit successful ✅");
        dao.saveTransaction(accNo, "Deposit", amount);

    }
}
