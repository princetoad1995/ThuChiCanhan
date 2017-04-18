package com.princetoad.costmanagement.DAOImpl;

import com.j256.ormlite.dao.Dao;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.DAO.ExpenseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class ExpenseDAOImpl implements ExpenseDAO{
    private DatabaseHelper databaseHelper;
    private Dao<ExpenseDTO, Integer> dao;

    public ExpenseDAOImpl() {
        try {
            databaseHelper = DatabaseHelper.getInstance();
            dao = databaseHelper.getExpenseDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addExpense(ExpenseDTO expense) {
        try {
            dao.create(expense);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ExpenseDTO> getAllListExpenses(TypeExpenseDTO typeExpense) {
        List<ExpenseDTO> list = new ArrayList<>();
        try {
            list = dao.queryBuilder()
            .where()
            .eq(Constant.TABLE_EXPENSE.EXPENSE_TYPE_EXPENSE, typeExpense)
            .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
