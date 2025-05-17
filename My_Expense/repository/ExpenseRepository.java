package com.example.My_Expense.repository;

import com.example.My_Expense.model.Expense;
import com.example.My_Expense.dto.CategorySummary;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT new com.example.My_Expense.dto.CategorySummary(e.category, SUM(e.amount)) FROM Expense e GROUP BY e.category")
    List<CategorySummary> getTotalByCategory();

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.date BETWEEN :start AND :end")
    Double getTotalByDateRange(@Param("start") LocalDate start, @Param("end") LocalDate end);








}
