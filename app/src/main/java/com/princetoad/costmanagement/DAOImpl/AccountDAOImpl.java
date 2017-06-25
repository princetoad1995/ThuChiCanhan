package com.princetoad.costmanagement.DAOImpl;

import com.j256.ormlite.dao.Dao;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.DAO.AccountDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class AccountDAOImpl implements AccountDAO{
    DatabaseHelper dbHelper;
    Dao<AccountDTO, Integer> accountDAO = null;

    public AccountDAOImpl() {
        try {
            dbHelper = DatabaseHelper.getInstance();
            accountDAO = dbHelper.getAccountDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(AccountDTO account) {
        try {
            accountDAO.create(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editAccount(AccountDTO account) {
        try {
            accountDAO.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AccountDTO> getAllListAccounts() {
        List<AccountDTO> list = new ArrayList<>();
        try {
            list = accountDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public AccountDTO getAccount(String name) {
        List<AccountDTO> list = new ArrayList<>();
        try {
            list = accountDAO.queryBuilder()
                    .where()
                    .eq(Constant.TABLE_ACCOUNT.ACCOUNT_NAME, name)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }
}
