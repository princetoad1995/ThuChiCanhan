package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

public interface ChooseExpenseView extends ViewBase{
    public void setTypeExpense(ArrayList<TypeExpenseDTO> listTypeExpense);
    public void setListExpanable(HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpanable);
    public String getContentExpense();
}
