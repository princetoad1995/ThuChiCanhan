package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.ManageDTO;
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
    private AccountDAO accountDAO;

    public TabNotePresenterImpl(TabNoteView view) {
        this.view = view;
        this.manageDAO = new ManageDAOImpl();
        this.userDAO = new UserDAOImpl();
        this.accountDAO = new AccountDAOImpl();

        view.setUser(userDAO.getCurrentUser());
        view.setAccount(accountDAO.getAllListAccounts().get(0));
        Log.e("size manage", manageDAO.getAllList().size() + "");
    }

    @Override
    public void onSaveEvent(UserDTO userDTO, long money, ExpenseDTO expenseDTO, TypeExpenseDTO typeExpenseDTO, String description, AccountDTO accountDTO, String date, int type) {
        if (expenseDTO.getName().equals("") || String.valueOf(money) == null){
            view.showMessage("Không được để trống thông tin");
        } else{
            ManageDTO manageDTO = new ManageDTO();
            manageDTO.setType(view.getType());
            manageDTO.setUserDTO(userDAO.getCurrentUser());
            manageDTO.setMoney(money);
            manageDTO.setTypeExpenseDTO(typeExpenseDTO);
            manageDTO.setExpenseDTO(expenseDTO);
            manageDTO.setDescription(description);
            manageDTO.setAccountDTO(accountDTO);
            manageDTO.setDate(date);

            manageDAO.addManage(manageDTO);
            view.onSuccess();
        }
    }
}
