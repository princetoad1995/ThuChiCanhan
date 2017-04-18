package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.Presenter.TabNotePresenter;
import com.princetoad.costmanagement.PresenterImpl.TabNotePresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.TabNoteView;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabNoteFragment extends BaseFragment implements TabNoteView{
    private static Fragment instance;
    private RelativeLayout tab_note_expense, tab_note_description, tab_note_account, tab_note_date;
    private TextView txt_from_account, txt_hour, txt_date;
    private Button btn_tab_note;
    private TabNotePresenter controller;

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabNoteFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        controller = new TabNotePresenterImpl(TabNoteFragment.this);
        tab_note_expense = (RelativeLayout) v.findViewById(R.id.tab_note_expense);
        tab_note_description = (RelativeLayout) v.findViewById(R.id.tab_note_description);
        tab_note_account = (RelativeLayout) v.findViewById(R.id.tab_note_account);
        tab_note_date = (RelativeLayout) v.findViewById(R.id.tab_note_date);

        txt_from_account = (TextView) v.findViewById(R.id.txt_from_account);
        txt_hour = (TextView) v.findViewById(R.id.txt_hour);
        txt_date = (TextView) v.findViewById(R.id.txt_date);

        btn_tab_note = (Button) v.findViewById(R.id.btn_tab_note);
    }

    @Override
    protected void control() {
        tab_note_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onAccountEvent();
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_note;
    }

    @Override
    public void toastMessage(String message) {

    }
}
