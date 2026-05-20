package com.version;

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