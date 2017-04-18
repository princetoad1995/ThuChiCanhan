package com.princetoad.costmanagement.Common.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;

import java.sql.SQLException;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "costmanage.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;
    private Dao<UserDTO, Integer> mUserDao = null;
    private Dao<AccountDTO, Integer> mAccountDao = null;
    private Dao<TypeExpenseDTO, Integer> mTypeExpense = null;
    private Dao<ExpenseDTO, Integer> mExpense = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static void init(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);
    }

    public static DatabaseHelper getInstance() {
        if (instance == null)
            throw new RuntimeException();
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserDTO.class);
            TableUtils.createTable(connectionSource, AccountDTO.class);
            TableUtils.createTable(connectionSource, TypeExpenseDTO.class);
            TableUtils.createTable(connectionSource, ExpenseDTO.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, UserDTO.class, true);
            TableUtils.dropTable(connectionSource, AccountDTO.class, true);
            TableUtils.dropTable(connectionSource, TypeExpenseDTO.class, true);
            TableUtils.dropTable(connectionSource, ExpenseDTO.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* User */

    public Dao<UserDTO, Integer> getUserDao() throws SQLException {
        if (mUserDao == null) {
            mUserDao = getDao(UserDTO.class);
        }

        return mUserDao;
    }

    /* Account */

    public Dao<AccountDTO, Integer> getAccountDao() throws SQLException {
        if (mAccountDao == null) {
            mAccountDao = getDao(AccountDTO.class);
        }

        return mAccountDao;
    }

    /* TypeExpense */

    public Dao<TypeExpenseDTO, Integer> getTypeExpenseDao() throws SQLException {
        if (mTypeExpense == null) {
            mTypeExpense = getDao(TypeExpenseDTO.class);
        }

        return mTypeExpense;
    }

    /* Expense */

    public Dao<ExpenseDTO, Integer> getExpenseDao() throws SQLException {
        if (mExpense == null) {
            mExpense = getDao(ExpenseDTO.class);
        }

        return mExpense;
    }

    @Override
    public void close() {
        mUserDao = null;
        mAccountDao = null;
        mTypeExpense = null;
        mExpense = null;
        super.close();
    }
}
