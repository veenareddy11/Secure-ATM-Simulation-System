package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class AccountDAO {

    // Login validation
    public boolean validatePin(int accNo, int pin) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM account WHERE acc_no=? AND pin=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ps.setInt(2, pin);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    // Get current balance
    public double getBalance(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT balance FROM account WHERE acc_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getDouble("balance");
    }

    // Update balance after transaction
    public void updateBalance(int accNo, double newBalance) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE account SET balance=? WHERE acc_no=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, newBalance);
        ps.setInt(2, accNo);
        ps.executeUpdate();
    }
 // Save transaction
    public void saveTransaction(int accNo, String type, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO transaction(acc_no, type, amount) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.executeUpdate();
    }

    // Get last 5 transactions
    public ResultSet getMiniStatement(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT type, amount, txn_date FROM transaction " +
                     "WHERE acc_no=? ORDER BY txn_date DESC LIMIT 5";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, accNo);
        return ps.executeQuery();
    }

}
