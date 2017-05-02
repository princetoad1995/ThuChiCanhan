package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Utils.DateTimeUtils;
import com.princetoad.costmanagement.Presenter.TabNotePresenter;
import com.princetoad.costmanagement.PresenterImpl.TabNotePresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.TabNoteView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabNoteFragment extends BaseFragment implements TabNoteView{
    private static Fragment instance;
    private RelativeLayout tab_note_expense, tab_note_description, tab_note_account, tab_note_date;
    private TextView txt_from_account, txt_hour, txt_date, txt_content_des, txt_content_expense;
    private Button btn_tab_note;
    private TabNotePresenter controller;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date)
        {
            Toast.makeText(getContext(),
                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel()
        {
            Toast.makeText(getContext(),
                    "Canceled", Toast.LENGTH_SHORT).show();
        }
    };

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
        txt_content_expense = (TextView) v.findViewById(R.id.txt_content_expense);
        txt_from_account = (TextView) v.findViewById(R.id.txt_from_account);
        txt_content_des = (TextView) v.findViewById(R.id.txt_content_des);
        txt_hour = (TextView) v.findViewById(R.id.txt_hour);
        txt_date = (TextView) v.findViewById(R.id.txt_date);

        btn_tab_note = (Button) v.findViewById(R.id.btn_tab_note);

        setToolbar("Ghi chú", v);
    }

    @Override
    protected void control() {
        tab_note_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ChooseAccountActivity.class);
                i.putExtra("account", txt_from_account.getText().toString());
                startActivityForResult(i, Constant.INTENT.REQUEST_CODE_ACCOUNT);
            }
        });
        txt_hour.setText(DateTimeUtils.getCurrentTimeStamp());
        tab_note_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), NoteDescriptionActivity.class);
                i.putExtra("content_des", txt_content_des.getText().toString());
                startActivityForResult(i, Constant.INTENT.REQUEST_CODE_DESCRIPTION);
            }
        });
        tab_note_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ChooseExpenseActivity.class);
                i.putExtra("content_expense", txt_content_expense.getText().toString());
                startActivityForResult(i, Constant.INTENT.REQUEST_CODE_EXPENSE);
            }
        });
        tab_note_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getChildFragmentManager())
                        .setListener(listener)
                        .setInitialDate(new Date())
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        .setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        //.setIndicatorColor(Color.parseColor("#990000"))
                        .build()
                        .show();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.INTENT.REQUEST_CODE_DESCRIPTION && resultCode == Constant.INTENT.RESULT_CODE_DESCRIPTION && data != null){
            txt_content_des.setText(data.getSerializableExtra("des") + "");
        } else if (requestCode == Constant.INTENT.REQUEST_CODE_ACCOUNT && resultCode == Constant.INTENT.RESULT_CODE_ACCOUNT && data != null){
            txt_from_account.setText(data.getSerializableExtra("name_account") + "");
        } else if (requestCode == Constant.INTENT.REQUEST_CODE_EXPENSE && resultCode == Constant.INTENT.RESULT_CODE_EXPENSE && data != null){
            txt_content_expense.setText(data.getSerializableExtra("expense") + "");
        }
    }
}
