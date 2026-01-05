package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // ADD EXPENSE
    public void addExpense(Expense expense) {

        String sql = "INSERT INTO expenses(title, amount, category, expense_date) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4, expense.getExpenseDate());

            ps.executeUpdate();
            System.out.println("Expense added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL EXPENSES
    public List<Expense> getAllExpenses() {

        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id"));
                e.setTitle(rs.getString("title"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategory(rs.getString("category"));
                e.setExpenseDate(rs.getDate("expense_date"));
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE EXPENSE
    public void deleteExpense(int id) {

        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Expense deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
