package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.Presenter.TabNotePresenter;
import com.princetoad.costmanagement.View.TabNoteView;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class TabNotePresenterImpl implements TabNotePresenter{
    private TabNoteView view;
    private AccountDAO accountDAO;

    public TabNotePresenterImpl(TabNoteView view) {
        this.view = view;
        this.accountDAO = new AccountDAOImpl();
    }

    @Override
    public void onAccountEvent() {
        Log.e("size", accountDAO.getAllListAccounts().size() + "");
    }
}
