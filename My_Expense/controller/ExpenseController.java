package com.example.My_Expense.controller;
import com.example.My_Expense.model.Expense;
import com.example.My_Expense.service.ExpenseService;
import com.example.My_Expense.dto.CategorySummary;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.save(expense);
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        Expense existing = service.getById(id);
        if (existing == null) throw new RuntimeException("Expense not found");

        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setDate(expense.getDate());
        existing.setDescription(expense.getDescription());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/range")
    public List<Expense> getByDateRange(@RequestParam String start, @RequestParam String end) {
        return service.getByDateRange(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/summary/category")
    public List<CategorySummary> categorySummary() {
        return service.getCategorySummary();
    }

    @GetMapping("/summary/total")
    public double getTotalInDateRange(@RequestParam String start, @RequestParam String end) {
        return service.getTotalInRange(LocalDate.parse(start), LocalDate.parse(end));
    }
}
