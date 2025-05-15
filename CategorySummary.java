package com.example.My_Expense.dto;

public class CategorySummary {
    private String Category;
    private double total;

    public CategorySummary(String category, double total) {
        this.Category = category;
        this.total = total;
    }

    public String getCategory() { return Category; }
    public double getTotal() { return total; }


}
