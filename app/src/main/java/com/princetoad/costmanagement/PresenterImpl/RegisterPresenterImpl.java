package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.DAO.UserDAO;
import com.princetoad.costmanagement.DAOImpl.UserDAOImpl;
import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.Presenter.RegisterPresenter;
import com.princetoad.costmanagement.ServiceCallback.InfoCallback;
import com.princetoad.costmanagement.View.RegisterView;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class RegisterPresenterImpl implements RegisterPresenter {
    private RegisterView view;
    private UserDAO dao;

    public RegisterPresenterImpl(RegisterView view) {
        this.view = view;
        dao = new UserDAOImpl();
    }

    @Override
    public void onRegisterEvent(UserDTO user) {
        if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
            view.showMessage("Không để trống thông tin");
        } else {
            dao.register(user, new InfoCallback() {
                @Override
                public void onSuccess(String success) {
                    view.toastMessage(success);
                    view.registerSuccess();
                }

                @Override
                public void onFail(String error) {
                    view.showMessage(error);
                }
            });
        }
    }
}
