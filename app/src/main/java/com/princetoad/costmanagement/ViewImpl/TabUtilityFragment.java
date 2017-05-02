package com.princetoad.costmanagement.ViewImpl;

import android.support.v4.app.Fragment;
import android.view.View;

import com.princetoad.costmanagement.R;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabUtilityFragment extends BaseFragment {
    private static Fragment instance;

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabUtilityFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        setToolbar("Tiện ích", v);
    }

    @Override
    protected void control() {
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_utility;
    }

    @Override
    public void toastMessage(String message) {

    }
}
