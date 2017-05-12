package com.princetoad.costmanagement.ViewImpl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Utils.StringUtil;
import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.Presenter.EditAccountPresenter;
import com.princetoad.costmanagement.PresenterImpl.EditAccountPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.EditAccountView;

public class EditAccountActivity extends BaseActivity implements EditAccountView{
    private AccountDTO accountDTO;
    private EditText txt_edit_account, txt_edit_money;
    private ImageView img_del;
    private Button btn_edit_save;
    private EditAccountPresenter controller;
    private boolean isEditable = true;
    private String money = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        setToolbar("Sửa tài khoản");
        init();
        Intent i = getIntent();
        accountDTO = (AccountDTO) i.getSerializableExtra("account");
        control();
    }

    public void init(){
        accountDTO = new AccountDTO();
        txt_edit_account = (EditText) findViewById(R.id.txt_edit_account);
        img_del = (ImageView) findViewById(R.id.img_del);
        txt_edit_money = (EditText) findViewById(R.id.txt_edit_money);
        btn_edit_save = (Button) findViewById(R.id.btn_edit_save);

        controller = new EditAccountPresenterImpl(EditAccountActivity.this);
    }

    public void control(){
        txt_edit_account.setText(accountDTO.getName());
        if (accountDTO.getMoney() == 0){
            txt_edit_money.setHint(R.string.money_account);
        } else {
            txt_edit_money.setText(accountDTO.getMoney() + "");
        }
        img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_edit_account.setText("");
                txt_edit_account.setHint(R.string.name_account);
            }
        });

        txt_edit_money.addTextChangedListener(new TextWatcher() {
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

        btn_edit_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_edit_account.getText().toString().isEmpty() || txt_edit_money.getText().toString().isEmpty()){
                    showMessage("Điền thiếu thông tin");
                } else {
                    accountDTO.setName(txt_edit_account.getText().toString());
                    accountDTO.setMoney(Long.parseLong(money));
                    controller.editAccount(accountDTO);

                }
            }
        });
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

                txt_edit_money.setText(tien);
                txt_edit_money.setSelection(txt_edit_money.getText().length());
            }
        }

    }

    @Override
    public void onSuccess() {
        Intent i = new Intent(EditAccountActivity.this, MainActivity.class);
        i.putExtra("ok", "ok");
        setResult(Constant.INTENT.RESULT_CODE_EDIT_ACCOUNT, i);
        finish();
        InputMethodManager inputMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMgr.hideSoftInputFromWindow(txt_edit_account.getWindowToken(), 0);
        inputMgr.hideSoftInputFromWindow(txt_edit_money.getWindowToken(), 0);
    }
}
