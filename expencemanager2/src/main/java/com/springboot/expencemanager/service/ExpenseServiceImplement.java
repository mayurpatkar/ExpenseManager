package com.springboot.expencemanager.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.expencemanager.Entity.Expense;
import com.springboot.expencemanager.dao.ExpenseDAO;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDto;

@Service
public class ExpenseServiceImplement implements ExpenseService {

    private Logger logger = LoggerFactory.getLogger(ExpenseServiceImplement.class);
    @Autowired
    private ExpenseDAO expenseDAO;

    /* Call addExpense method for adding new expenses */
    @Override
    public void addExpense(ExpenseDTO expenseDTO) {
        expenseDAO.addExpense(expenseDTO);
    }

    /* Calling showExpense in expenseDAO for showing summary on Dashboard UI*/
    public SummaryDto dashboard(int id) {
        logger.info("Id is {}", id);
        return expenseDAO.showExpense(id);
    }

    /* Show all Expenses with all attributes */
    public List<Object> viewAllExpenses(int id) {
        return expenseDAO.showAllExpense(id);
    }

    /* Delete Expense */
    public void deleteExpense(int id) {
        expenseDAO.delete(id);
    }
}
