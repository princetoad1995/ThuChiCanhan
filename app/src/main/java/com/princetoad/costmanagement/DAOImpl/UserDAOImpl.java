package com.princetoad.costmanagement.DAOImpl;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.DAO.UserDAO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;
import com.princetoad.costmanagement.ServiceCallback.DataCallback;
import com.princetoad.costmanagement.ServiceCallback.InfoCallback;
import com.princetoad.costmanagement.ServiceImpl.SharedPreferencesServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class UserDAOImpl implements UserDAO{
    DatabaseHelper dbHelper;
    Dao<UserDTO, Integer> userDAO = null;

    public UserDAOImpl() {
        try {
            dbHelper = DatabaseHelper.getInstance();
            userDAO = dbHelper.getUserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void login(String username, String password, DataCallback<UserDTO> callback) {
        UserDTO user = new UserDTO();
        List<UserDTO> list = new ArrayList<>();
        try {
            list = userDAO.queryBuilder()
                    .where()
                    .eq(Constant.TABLE_USER.USER_NAME, username)
                    .and()
                    .eq(Constant.TABLE_USER.USER_PASS, password)
                    .query();
            Log.e("pass", password);
            if (list.size() != 0)
                user = list.get(0);
            else
                user = null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null){
            callback.onSuccess(user);
        } else
            callback.onFail("Tên tài khoản hoặc mật khẩu không đúng");
    }

    @Override
    public void register(UserDTO user, InfoCallback callback) {
        List<UserDTO> list = new ArrayList<>();
        try {
            list = userDAO.queryBuilder()
                    .where()
                    .eq(Constant.TABLE_USER.USER_NAME, user.getName())
                    .query();
            if (list.size() != 0){
                callback.onFail("Tên tài khoản đã tồn tại");
            } else{
                userDAO.create(user);
                callback.onSuccess("Đăng ký thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO getCurrentUser() {
        return (UserDTO) SharedPreferencesServiceImpl.getInstance().getObject(Constant.SHARED_PREFERENCE.REMEMBER, UserDTO.class);
    }

}
