package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.DAO.UserDAO;
import com.princetoad.costmanagement.DAOImpl.UserDAOImpl;
import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.Presenter.LoginPresenter;
import com.princetoad.costmanagement.Service.SharedPreferencesService;
import com.princetoad.costmanagement.ServiceCallback.DataCallback;
import com.princetoad.costmanagement.ServiceImpl.SharedPreferencesServiceImpl;
import com.princetoad.costmanagement.View.LoginView;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;
    private UserDAO dao;
    SharedPreferencesService sharedPreferencesService;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        dao = new UserDAOImpl();
        sharedPreferencesService = SharedPreferencesServiceImpl.getInstance();

        checkLoggedIn();
    }

    @Override
    public void onLoginEvent(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            view.showMessage("Không để trống thông tin");
        } else {
            view.showLoadingDialog("Đang đăng nhập");
            dao.login(username, password, new DataCallback<UserDTO>() {
                @Override
                public void onSuccess(UserDTO data) {
                    sharedPreferencesService.saveObject(Constant.SHARED_PREFERENCE.REMEMBER, data);
                    view.hideLoadingDialog();
                    view.loginSuccess();
                }

                @Override
                public void onFail(String error) {
                    view.hideLoadingDialog();
                    view.showMessage(error);
                }
            });

        }
    }

    private void checkLoggedIn() {
        if (dao.getCurrentUser() != null) {
            view.loginSuccess();
        }
    }
}
