package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.R;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabNoteFragment extends BaseFragment {
    private static Fragment instance;

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabNoteFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
    }

    @Override
    protected void control() {
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_note;
    }

    @Override
    public void toastMessage(String message) {

    }
}
