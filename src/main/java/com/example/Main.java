package com.example;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExpenseDAO dao = new ExpenseDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date = sc.next();

                    Expense expense = new Expense(
                            title,
                            amount,
                            category,
                            Date.valueOf(date)
                    );

                    dao.addExpense(expense);
                    break;

                case 2:
                    List<Expense> list = dao.getAllExpenses();
                    System.out.println("\nID | TITLE | AMOUNT | CATEGORY | DATE");
                    for (Expense e : list) {
                        System.out.println(
                                e.getId() + " | " +
                                e.getTitle() + " | " +
                                e.getAmount() + " | " +
                                e.getCategory() + " | " +
                                e.getExpenseDate()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Expense ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteExpense(id);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
