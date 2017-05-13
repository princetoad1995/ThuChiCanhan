package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;

import java.util.ArrayList;

/**
 * Created by PRINCE D. TOAD on 5/13/2017.
 */

public interface ChoosePayView {
    public void setTypeExpense(ArrayList<TypeExpenseDTO> listTypeExpense);
    public String getContentExpense();
}
