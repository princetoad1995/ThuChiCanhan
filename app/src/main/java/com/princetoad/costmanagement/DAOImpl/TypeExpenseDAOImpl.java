package com.princetoad.costmanagement.DAOImpl;

import com.j256.ormlite.dao.Dao;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.DAO.TypeExpenseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class TypeExpenseDAOImpl implements TypeExpenseDAO{
    private DatabaseHelper databaseHelper;
    private Dao<TypeExpenseDTO, Integer> typeExpenseDAO;

    public TypeExpenseDAOImpl() {
        try {
            databaseHelper = DatabaseHelper.getInstance();
            typeExpenseDAO = databaseHelper.getTypeExpenseDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTypeExpense(TypeExpenseDTO typeExpense) {
        try {
            typeExpenseDAO.create(typeExpense);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeExpenseDTO> getAllListTypeExpense() {
        List<TypeExpenseDTO> list = new ArrayList<>();
        try {
            list = typeExpenseDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TypeExpenseDTO> getAllListTypeExpenseByType(int type) {
        List<TypeExpenseDTO> list = new ArrayList<>();
        try {
            list = typeExpenseDAO.queryBuilder()
            .where()
            .eq(Constant.TABLE_TYPE_EXPENSE.TYPE_EXPENSE_TYPE, type)
            .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
