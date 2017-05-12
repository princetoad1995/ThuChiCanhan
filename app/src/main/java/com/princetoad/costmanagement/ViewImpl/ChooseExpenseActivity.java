package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.princetoad.costmanagement.Adapter.ListChooseExpenseAdapter;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Presenter.ChooseAccountPresnter;
import com.princetoad.costmanagement.Presenter.ChooseExpensePresenter;
import com.princetoad.costmanagement.PresenterImpl.ChooseExpensePresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ChooseExpenseView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseExpenseActivity extends BaseActivity implements ChooseExpenseView{
    private ExpandableListView list_exp_expense;
    private ListChooseExpenseAdapter adapter;
    private ArrayList<TypeExpenseDTO> listTypeExpense;
    private HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpense;
    private ChooseExpensePresenter controller;
    private String content_expense = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_expense);

        setToolbar("Hạng mục thu");
        init();
        control();
    }

    public void init(){
        Intent i = getIntent();
        content_expense = (String) i.getSerializableExtra("content_expense");
        list_exp_expense = (ExpandableListView) findViewById(R.id.list_exp_expense);
        listTypeExpense = new ArrayList<>();
        listExpense = new HashMap<>();

        controller = new ChooseExpensePresenterImpl(ChooseExpenseActivity.this);
    }

    public void control(){
        list_exp_expense.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Intent i = new Intent(ChooseExpenseActivity.this, MainActivity.class);
                i.putExtra("expense", listTypeExpense.get(groupPosition));
                i.putExtra("type", 1);
                setResult(Constant.INTENT.RESULT_CODE_EXPENSE, i);
                finish();
                controller.resetCheck();
                return true;
            }
        });

        list_exp_expense.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent i = new Intent(ChooseExpenseActivity.this, MainActivity.class);
                i.putExtra("expense", listExpense.get(listTypeExpense.get(groupPosition)).get(childPosition));
                i.putExtra("type", 2);
                setResult(Constant.INTENT.RESULT_CODE_EXPENSE, i);
                finish();
                controller.resetCheck();
                return false;
            }
        });

    }

    @Override
    public void setTypeExpense(ArrayList<TypeExpenseDTO> listTypeExpense) {
        this.listTypeExpense = listTypeExpense;
    }

    @Override
    public void setListExpanable(HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpanable) {
        this.listExpense = listExpanable;
        adapter = new ListChooseExpenseAdapter(ChooseExpenseActivity.this, listTypeExpense, listExpanable);
        list_exp_expense.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++)
            list_exp_expense.expandGroup(i);
    }

    @Override
    public String getContentExpense() {
        return content_expense;
    }


}
