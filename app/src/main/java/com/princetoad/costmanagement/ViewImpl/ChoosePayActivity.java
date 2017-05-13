package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.princetoad.costmanagement.Adapter.ListChooseExpenseAdapter;
import com.princetoad.costmanagement.Adapter.ListChoosePayAdapter;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Presenter.ChooseExpensePresenter;
import com.princetoad.costmanagement.Presenter.ChoosePayPresenter;
import com.princetoad.costmanagement.PresenterImpl.ChooseExpensePresenterImpl;
import com.princetoad.costmanagement.PresenterImpl.ChoosePayPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ChooseExpenseView;
import com.princetoad.costmanagement.View.ChoosePayView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoosePayActivity extends BaseActivity implements ChoosePayView{
    private ListView list_pay;
    private ListChoosePayAdapter adapter;
    private ArrayList<TypeExpenseDTO> listTypeExpense;
    private ChoosePayPresenter controller;
    private String content_expense = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pay);

        setToolbar("Hạng mục thu");
        init();
        control();
    }

    public void init(){
        Intent i = getIntent();
        content_expense = (String) i.getSerializableExtra("content_expense");
        list_pay = (ListView) findViewById(R.id.list_pay);
        listTypeExpense = new ArrayList<>();

        controller = new ChoosePayPresenterImpl(ChoosePayActivity.this);
    }

    public void control(){
        list_pay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ChoosePayActivity.this, MainActivity.class);
                i.putExtra("expense", listTypeExpense.get(position));
                i.putExtra("type", 1);
                setResult(Constant.INTENT.RESULT_CODE_EXPENSE, i);
                finish();
                controller.resetCheck();
            }
        });
    }

    @Override
    public void setTypeExpense(ArrayList<TypeExpenseDTO> listTypeExpense) {
        this.listTypeExpense = listTypeExpense;
        adapter = new ListChoosePayAdapter(ChoosePayActivity.this, listTypeExpense);
        list_pay.setAdapter(adapter);
    }

    @Override
    public String getContentExpense() {
        return content_expense;
    }

}
