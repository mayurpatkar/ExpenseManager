package com.springboot.expencemanager.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.expencemanager.Entity.Expense;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDto;
import com.springboot.expencemanager.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    /* Logger declaration */ 
    private Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseService expenseService;

    /*Add Expenses Button
     *Fill all attributes details 
     */
    @PostMapping("/addexpense")
    public void addExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.addExpense(expenseDTO);
        logger.info("Expense add Successfully");
    }

    /* 
     * In dashboard Month,Year and expenses will be show
     */
    
    /**
     * Dashboard View.
     *
     * @param id User id
     * @return summary info of expenses.
     */
    @GetMapping("/dashboard/{id}")
    public SummaryDto dashboard(@PathVariable(value = "id") int id) {
        return expenseService.dashboard(id);
    }

    /* Display all expenses on View All Button
     * Showing the expense with all attribute
     */
    @GetMapping("/allexpenses/{id}")
    public List<Object> viewAllExpenses(@PathVariable(value = "id") int id) {
        return expenseService.viewAllExpenses(id);
    }

    /* Delete particular expense after clicking Delete Expense Button 
     * Input: Expense Id 
     * */
    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable(value = "id") int id) {
        logger.info("Delete Expense {}",id);
        expenseService.deleteExpense(id);
    }
}
