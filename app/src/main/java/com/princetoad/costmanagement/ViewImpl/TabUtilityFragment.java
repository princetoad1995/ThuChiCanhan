package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.princetoad.costmanagement.Presenter.TabUtilityPresenter;
import com.princetoad.costmanagement.PresenterImpl.TabUtilityPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.TabUtilityView;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabUtilityFragment extends BaseFragment implements TabUtilityView{
    private static Fragment instance;
    private LinearLayout btn_logout;
    private TabUtilityPresenter controller;

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabUtilityFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        setToolbar("Tiện ích", v);
        btn_logout = (LinearLayout) v.findViewById(R.id.btn_logout);
        controller = new TabUtilityPresenterImpl(TabUtilityFragment.this);
    }

    @Override
    protected void control() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onLogoutEvent();
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_utility;
    }

    @Override
    public void toastMessage(String message) {

    }

    @Override
    public void onSuccess() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }
}
