package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.princetoad.costmanagement.Adapter.ListChooseAccountAdapter;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Presenter.ChooseAccountPresnter;
import com.princetoad.costmanagement.PresenterImpl.ChooseAccountPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ChooseAccountView;

import java.util.ArrayList;
import java.util.List;

public class ChooseAccountActivity extends BaseActivity implements ChooseAccountView{
    private ListView listView;
    private ListChooseAccountAdapter adapter;
    private ChooseAccountPresnter controller;
    private List<AccountDTO> accountDTOs;
    private String account = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);

        init();
        setToolbar("Chọn tài khoản");
        control();
    }

    private void init(){
        Intent i = getIntent();
        account = (String) i.getSerializableExtra("account");
        listView = (ListView) findViewById(R.id.listview_choose_account);
        accountDTOs = new ArrayList<>();
        controller = new ChooseAccountPresenterImpl(ChooseAccountActivity.this);
    }

    private void control(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ChooseAccountActivity.this, MainActivity.class);
                intent.putExtra("name_account", accountDTOs.get(position).getName());
                setResult(Constant.INTENT.RESULT_CODE_ACCOUNT, intent);
                finish();
            }
        });
    }

    @Override
    public void setListAccount(List<AccountDTO> list) {
        this.accountDTOs = list;
        for (AccountDTO a : list){
            if (a.getName().equals(account))
                a.setChecked(1);
        }
        adapter = new ListChooseAccountAdapter(ChooseAccountActivity.this, (ArrayList<AccountDTO>) accountDTOs);
        listView.setAdapter(adapter);
    }
}
