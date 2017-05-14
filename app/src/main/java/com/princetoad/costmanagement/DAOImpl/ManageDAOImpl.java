package com.princetoad.costmanagement.DAOImpl;

import com.j256.ormlite.dao.Dao;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.Common.Domain.ManageDTO;
import com.princetoad.costmanagement.DAO.ManageDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/3/2017.
 */

public class ManageDAOImpl implements ManageDAO{
    private DatabaseHelper databaseHelper;
    private Dao<ManageDTO, Integer> manageDAO;

    public ManageDAOImpl() {
        try {
            databaseHelper = DatabaseHelper.getInstance();
            manageDAO = databaseHelper.getManageDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addManage(ManageDTO manageDTO) {
        try {
            manageDAO.create(manageDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ManageDTO> getAllList() {
        List<ManageDTO> list = new ArrayList<>();
        try {
            list = manageDAO.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ManageDTO> getAllListByTypeAndDate(int type) {
        List<ManageDTO> list = new ArrayList<>();
        try {
            list = manageDAO.queryBuilder()
            .where()
            .eq(Constant.TABLE_MANAGE.MANAGE_TYPE, type)
            .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ManageDTO> getAllListByDate(String date) {
        List<ManageDTO> list = new ArrayList<>();
        try {
            list = manageDAO.queryBuilder()
                    .where()
                    .eq(Constant.TABLE_MANAGE.MANAGE_DATE, date)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
