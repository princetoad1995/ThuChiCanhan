package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.Presenter.ChooseAccountPresnter;
import com.princetoad.costmanagement.View.ChooseAccountView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/20/2017.
 */

public class ChooseAccountPresenterImpl implements ChooseAccountPresnter{
    private ChooseAccountView view;
    private AccountDAO dao;
    private List<AccountDTO> list;

    public ChooseAccountPresenterImpl(ChooseAccountView view) {
        this.view = view;
        this.dao = new AccountDAOImpl();
        this.list = new ArrayList<>();

        list = dao.getAllListAccounts();
        resetChecked();
        view.setListAccount(dao.getAllListAccounts());
    }

    @Override
    public void onChooseAccount() {

    }

    public void resetChecked() {
        for (AccountDTO a : list){
            a.setChecked(0);
        }
    }
}
