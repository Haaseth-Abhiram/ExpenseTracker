//package com.version;

import java.util.ArrayList;
import java.util.Scanner;
class Expense {

    int id;
    String title;
    double amount;
    String category;

    Expense(int id, String title, double amount, String category) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }


    void displayExpense() {
        System.out.println(id + " | " +title + " | " +amount + " | " +category
        );
    }
}

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Expense> expenses = new ArrayList<>();

        int choice;
        int expenseId = 1;

        do {

            System.out.println("EXPENSE TRACKER");

            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expense");
            System.out.println("4. Search by Category");
            System.out.println("5. Remove Expense");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                // Add an Expense
                case 1:

                    System.out.print("Enter expense title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    Expense e = new Expense( expenseId, title, amount,category);
                    expenses.add(e);

                    System.out.println("Expense Added Successfully!");

                    expenseId++;

                    break;

                // View all expenses
                case 2:

                    if(expenses.isEmpty()) {

                        System.out.println("No expenses found.");
                    }
                    else {

                        System.out.println("\nID | TITLE | AMOUNT | CATEGORY");

                        for(Expense exp : expenses) {

                            exp.displayExpense();
                        }
                    }

                    break;

                // Calculate the total
                case 3:

                    double total = 0;

                    for(Expense exp : expenses) {

                        total = total + exp.amount;
                    }

                    System.out.println("Total Expense = " + total);

                    break;

                // Search the category
                case 4:

                    System.out.print("Enter category to search: ");
                    String searchCategory = sc.nextLine();

                    boolean found = false;

                    for(Expense exp : expenses) {

                        if(exp.category.equalsIgnoreCase(searchCategory)) {

                            exp.displayExpense();

                            found = true;
                        }
                    }

                    if(!found) {

                        System.out.println("No expenses found in this category.");
                    }

                    break;

                // Remove the expense
                case 5:

                    System.out.print("Enter expense ID to remove: ");
                    int removeId = sc.nextInt();

                    boolean removed = false;

                    for(int i = 0; i < expenses.size(); i++) {

                        if(expenses.get(i).id == removeId) {

                            expenses.remove(i);

                            removed = true;

                            System.out.println("Expense Removed Successfully!");

                            break;
                        }
                    }

                    if(!removed) {

                        System.out.println("Expense not found.");
                    }

                    break;
                	case 6:

                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while(choice != 6);

        sc.close();
    }
}