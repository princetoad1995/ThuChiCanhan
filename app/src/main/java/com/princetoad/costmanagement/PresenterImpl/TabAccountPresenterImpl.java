package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.Presenter.TabAccountPresenter;
import com.princetoad.costmanagement.View.TabAccountView;

/**
 * Created by PRINCE D. TOAD on 4/21/2017.
 */

public class TabAccountPresenterImpl implements TabAccountPresenter{
    private TabAccountView view;
    private AccountDAO dao;

    public TabAccountPresenterImpl(TabAccountView view) {
        this.view = view;
        this.dao = new AccountDAOImpl();

        long total = 0;
        view.setListAccount(dao.getAllListAccounts());
        for (int i = 0; i < dao.getAllListAccounts().size(); i++)
            total += dao.getAllListAccounts().get(i).getMoney();
        view.setTotalMoney(total);
    }

    @Override
    public void reloadAccount() {
        long total = 0;
        view.setListAccount(dao.getAllListAccounts());
        for (int i = 0; i < dao.getAllListAccounts().size(); i++)
            total += dao.getAllListAccounts().get(i).getMoney();
        view.setTotalMoney(total);
    }
}
