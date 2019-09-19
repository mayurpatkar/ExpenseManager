package com.springboot.expencemanager.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.expencemanager.Entity.Expense;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDto;

public interface ExpenseService {

    public void addExpense(ExpenseDTO expenseDTO);

    public SummaryDto dashboard(int id);

    public List<Object> viewAllExpenses(int id);

    public void deleteExpense(int id);
}
