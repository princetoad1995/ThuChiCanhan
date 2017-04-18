package com.princetoad.costmanagement.DAO;

import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public interface ExpenseDAO {
    public void addExpense(ExpenseDTO expense);

    public List<ExpenseDTO> getAllListExpenses(TypeExpenseDTO typeExpense);
}
