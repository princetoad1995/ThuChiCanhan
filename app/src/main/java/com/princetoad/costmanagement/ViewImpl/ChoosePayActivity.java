package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.princetoad.costmanagement.Adapter.ListChooseExpenseAdapter;
import com.princetoad.costmanagement.Adapter.ListChoosePayAdapter;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Presenter.ChooseExpensePresenter;
import com.princetoad.costmanagement.PresenterImpl.ChooseExpensePresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ChooseExpenseView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoosePayActivity extends BaseActivity implements ChooseExpenseView{
    private ListView list_pay;
    private ListChoosePayAdapter adapter;
    private ArrayList<TypeExpenseDTO> listTypeExpense;
    private HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpense;
    private ChooseExpensePresenter controller;
    private String content_expense = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_pay);

        setToolbar("Hạng mục chi");
        init();
        control();
    }

    public void init(){
        Intent i = getIntent();
        content_expense = (String) i.getSerializableExtra("content_expense");
        list_pay = (ListView) findViewById(R.id.list_pay);
        listTypeExpense = new ArrayList<>();
        listExpense = new HashMap<>();

        controller = new ChooseExpensePresenterImpl(ChoosePayActivity.this);
    }

    public void control(){


    }

    @Override
    public void setTypeExpense(ArrayList<TypeExpenseDTO> listTypeExpense) {
        this.listTypeExpense = listTypeExpense;
    }

    @Override
    public void setListExpanable(HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpanable) {
        this.listExpense = listExpanable;
//        adapter = new ListChoosePayAdapter(ChoosePayActivity.this, );

    }

    @Override
    public String getContentExpense() {
        return content_expense;
    }


}
