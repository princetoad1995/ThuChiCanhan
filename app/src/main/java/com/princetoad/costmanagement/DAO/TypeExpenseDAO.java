package com.princetoad.costmanagement.DAO;

import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public interface TypeExpenseDAO {
    public void addTypeExpense(TypeExpenseDTO typeExpense);

    public List<TypeExpenseDTO> getAllListTypeExpense();
}
