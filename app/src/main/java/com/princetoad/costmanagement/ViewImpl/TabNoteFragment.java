package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;
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

public class TabNoteFragment extends BaseFragment implements TabNoteView {
    private static Fragment instance;
    private RelativeLayout tab_note_expense, tab_note_description, tab_note_account, tab_note_date;
    private Spinner sp_type;
    private TextView txt_from_account, txt_hour, txt_date, txt_content_des, txt_content_expense, txt_title1;
    private EditText txt_input_money;
    private Button btn_tab_note;
    private ImageView btn_history_noted;
    private TabNotePresenter controller;
    private AccountDTO accountDTO;
    private TypeExpenseDTO typeExpenseDTO;
    private ExpenseDTO expenseDTO;
    private UserDTO userDTO;
    private String date_manager = DateTimeUtils.getCurrentTimeStamp();
    private boolean isEditable = true;
    private String money = "";
    private int type = Constant.TYPE.PAY;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("hh:mm dd/MM/yyyy");
    private SlideDateTimeListener listener = new SlideDateTimeListener() {

        @Override
        public void onDateTimeSet(Date date) {

            txt_hour.setText(mFormatter.format(date));
            txt_date.setVisibility(View.GONE);
            date_manager = mFormatter.format(date);
        }

        // Optional cancel listener
        @Override
        public void onDateTimeCancel() {
        }
    };

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabNoteFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        accountDTO = new AccountDTO();
        typeExpenseDTO = new TypeExpenseDTO();
        expenseDTO = new ExpenseDTO();
        userDTO = new UserDTO();

        controller = new TabNotePresenterImpl(TabNoteFragment.this);
        sp_type = (Spinner) v.findViewById(R.id.sp_type);
        btn_history_noted = (ImageView) v.findViewById(R.id.btn_history_noted);
        tab_note_expense = (RelativeLayout) v.findViewById(R.id.tab_note_expense);
        tab_note_description = (RelativeLayout) v.findViewById(R.id.tab_note_description);
        tab_note_account = (RelativeLayout) v.findViewById(R.id.tab_note_account);
        tab_note_date = (RelativeLayout) v.findViewById(R.id.tab_note_date);
        txt_content_expense = (TextView) v.findViewById(R.id.txt_content_expense);
        txt_from_account = (TextView) v.findViewById(R.id.txt_from_account);
        txt_content_des = (TextView) v.findViewById(R.id.txt_content_des);
        txt_hour = (TextView) v.findViewById(R.id.txt_hour);
        txt_date = (TextView) v.findViewById(R.id.txt_date);
        txt_input_money = (EditText) v.findViewById(R.id.txt_input_money);
        txt_title1 = (TextView) v.findViewById(R.id.txt_title_1);

        btn_tab_note = (Button) v.findViewById(R.id.btn_tab_note);


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
        txt_hour.setText(DateTimeUtils.getCurrentTimeStamp().split("\\s")[1]);
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

        btn_history_noted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ListNoteActivity.class);
                startActivity(i);
            }
        });

        txt_input_money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isEditable) {
                    isEditable = false;
                    styleText(s.toString());

                } else {
                    isEditable = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        sp_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position + 1 == Constant.TYPE.EARN) {
                    type = Constant.TYPE.EARN;
                    txt_title1.setText("Mục thu");
                } else if (position + 1 == Constant.TYPE.PAY) {
                    type = Constant.TYPE.PAY;
                    txt_title1.setText("Mục chi");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_tab_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onSaveEvent(userDTO, Long.parseLong(money), expenseDTO, typeExpenseDTO, txt_content_des.getText().toString(), accountDTO, date_manager, type);
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
        if (requestCode == Constant.INTENT.REQUEST_CODE_DESCRIPTION && resultCode == Constant.INTENT.RESULT_CODE_DESCRIPTION && data != null) {
            txt_content_des.setText(data.getSerializableExtra("des") + "");
        } else if (requestCode == Constant.INTENT.REQUEST_CODE_ACCOUNT && resultCode == Constant.INTENT.RESULT_CODE_ACCOUNT && data != null) {
            accountDTO = (AccountDTO) data.getSerializableExtra("account");
            txt_from_account.setText(accountDTO.getName());
        } else if (requestCode == Constant.INTENT.REQUEST_CODE_EXPENSE && resultCode == Constant.INTENT.RESULT_CODE_EXPENSE && data != null) {
            if ((int) data.getSerializableExtra("type") == 1) {
                typeExpenseDTO = (TypeExpenseDTO) data.getSerializableExtra("expense");
                txt_content_expense.setText(typeExpenseDTO.getName());
            } else if ((int) data.getSerializableExtra("type") == 2) {
                expenseDTO = (ExpenseDTO) data.getSerializableExtra("expense");
                txt_content_expense.setText(expenseDTO.getName());
            }

        }
    }

    private void styleText(String s) {
        if (!s.toString().matches("^\\$(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$")) {
            String userInput = "" + s.toString().replaceAll("[^\\d]", "");
            money = userInput;
            StringBuffer cashAmountBuilder = new StringBuffer(userInput);

            if (cashAmountBuilder.length() > 3) {
                for (int i = 0; i < cashAmountBuilder.length(); i = i + 4) {
                    cashAmountBuilder.insert(cashAmountBuilder.length() - i, '.');
                }
                String tien = cashAmountBuilder.substring(0, cashAmountBuilder.length() - 1);

                txt_input_money.setText(tien);
                txt_input_money.setSelection(txt_input_money.getText().length());
            }
        }

    }


    @Override
    public void onSuccess() {
        Toast.makeText(getContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setAccount(AccountDTO account) {
        this.accountDTO = account;
    }
}
