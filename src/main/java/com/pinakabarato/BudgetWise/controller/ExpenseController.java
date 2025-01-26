package com.pinakabarato.BudgetWise.controller;

import com.pinakabarato.BudgetWise.entity.Expense;
import com.pinakabarato.BudgetWise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    public String saveExpense(@RequestBody Expense expense) throws ExecutionException, InterruptedException {

        return expenseService.saveExpense(expense);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() throws ExecutionException, InterruptedException {
        return expenseService.getAllExpenses();
    }
}
