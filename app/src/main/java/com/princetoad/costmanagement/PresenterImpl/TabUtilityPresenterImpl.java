package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Presenter.TabUtilityPresenter;
import com.princetoad.costmanagement.ServiceImpl.SharedPreferencesServiceImpl;
import com.princetoad.costmanagement.View.TabUtilityView;

/**
 * Created by PRINCE D. TOAD on 6/26/2017.
 */

public class TabUtilityPresenterImpl implements TabUtilityPresenter {
    private TabUtilityView view;

    public TabUtilityPresenterImpl(TabUtilityView view) {
        this.view = view;
    }

    @Override
    public void onLogoutEvent() {
        SharedPreferencesServiceImpl.getInstance().remove(Constant.SHARED_PREFERENCE.REMEMBER);
        view.onSuccess();
    }
}
