package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.Presenter.EditAccountPresenter;
import com.princetoad.costmanagement.View.EditAccountView;

/**
 * Created by PRINCE D. TOAD on 5/11/2017.
 */

public class EditAccountPresenterImpl implements EditAccountPresenter{
    private EditAccountView view;
    private AccountDAO dao;

    public EditAccountPresenterImpl(EditAccountView view) {
        this.view = view;
        this.dao = new AccountDAOImpl();
    }

    @Override
    public void editAccount(AccountDTO account) {
        dao.editAccount(account);
        view.onSuccess();
    }
}
