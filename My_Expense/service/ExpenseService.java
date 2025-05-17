package com.example.My_Expense.service;
import com.example.My_Expense.model.Expense;
import com.example.My_Expense.repository.ExpenseRepository;
import com.example.My_Expense.dto.CategorySummary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense save(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Expense getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Expense> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Expense> getByDateRange(LocalDate start, LocalDate end) {
        return repository.findByDateBetween(start, end);
    }

    public List<CategorySummary> getCategorySummary() {
        return repository.getTotalByCategory();
    }

    public double getTotalInRange(LocalDate start, LocalDate end) {
        Double result = repository.getTotalByDateRange(start, end);
        return result != null ? result : 0.0;
    }
}