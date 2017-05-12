package com.princetoad.costmanagement.Presenter;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public interface TabNotePresenter {
    public void onSaveEvent(UserDTO userDTO, long money, ExpenseDTO expenseDTO, TypeExpenseDTO typeExpenseDTO, String description, AccountDTO accountDTO, String date, int type);
}
