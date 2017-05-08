package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;
import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAO.ManageDAO;
import com.princetoad.costmanagement.DAO.UserDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.DAOImpl.ManageDAOImpl;
import com.princetoad.costmanagement.DAOImpl.UserDAOImpl;
import com.princetoad.costmanagement.Presenter.TabNotePresenter;
import com.princetoad.costmanagement.View.TabNoteView;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class TabNotePresenterImpl implements TabNotePresenter{
    private TabNoteView view;
    private ManageDAO manageDAO;
    private UserDAO userDAO;

    public TabNotePresenterImpl(TabNoteView view) {
        this.view = view;
        this.manageDAO = new ManageDAOImpl();
        this.userDAO = new UserDAOImpl();

        view.setUser(userDAO.getCurrentUser());
        Log.e("size manage", manageDAO.getAllList().size() + "");
    }

    @Override
    public void onSaveEvent(UserDTO userDTO, String money, ExpenseDTO expenseDTO, TypeExpenseDTO typeExpenseDTO, String description, AccountDTO accountDTO, String date) {
        if (expenseDTO.getName().equals("") || money.equals("")){
            view.showMessage("Không được để trống thông tin");
        } else
            view.onSuccess();
    }
}
