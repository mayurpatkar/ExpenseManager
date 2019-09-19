package com.springboot.expencemanager.dao;

import java.util.List;
import com.springboot.expencemanager.dto.ExpenseDTO;
import com.springboot.expencemanager.dto.SummaryDto;

public interface ExpenseDAO {

    public void addExpense(ExpenseDTO expenseDTO);

    public SummaryDto showExpense(int id);

    public List<Object> showAllExpense(int id);

    public void delete(int id);
}
