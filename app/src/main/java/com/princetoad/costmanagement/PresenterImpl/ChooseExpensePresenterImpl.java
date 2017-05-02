package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.DAO.ExpenseDAO;
import com.princetoad.costmanagement.DAO.TypeExpenseDAO;
import com.princetoad.costmanagement.DAOImpl.ExpenseDAOImpl;
import com.princetoad.costmanagement.DAOImpl.TypeExpenseDAOImpl;
import com.princetoad.costmanagement.Presenter.ChooseExpensePresenter;
import com.princetoad.costmanagement.View.ChooseExpenseView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

public class ChooseExpensePresenterImpl implements ChooseExpensePresenter {
    private ChooseExpenseView view;
    private TypeExpenseDAO typeExpenseDAO;
    private ExpenseDAO expenseDAO;
    private List<TypeExpenseDTO> listTypeExpense;
    private HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpense;

    public ChooseExpensePresenterImpl(ChooseExpenseView view) {
        this.view = view;
        this.typeExpenseDAO = new TypeExpenseDAOImpl();
        this.expenseDAO = new ExpenseDAOImpl();
        this.listTypeExpense = new ArrayList<>();
        this.listExpense = new HashMap<>();

        listTypeExpense = typeExpenseDAO.getAllListTypeExpense();
        for (TypeExpenseDTO type : listTypeExpense) {
            if (type.getName().equals(view.getContentExpense())) {
                type.setCheck(1);
                break;
            }
        }
        view.setTypeExpense((ArrayList<TypeExpenseDTO>) listTypeExpense);
        for (TypeExpenseDTO type : listTypeExpense) {
            ArrayList<ExpenseDTO> listChild = (ArrayList<ExpenseDTO>) expenseDAO.getAllListExpenses(type);
            for (ExpenseDTO expenseDTO : listChild){
                if (expenseDTO.getName().equals(view.getContentExpense())){
                    expenseDTO.setCheck(1);
                    break;
                }
            }
            listExpense.put(type, listChild);
        }
        view.setListExpanable(listExpense);
    }

    @Override
    public void resetCheck() {
        int kt = 0;
        if (!view.getContentExpense().isEmpty()){
            for (TypeExpenseDTO type : listTypeExpense){
                if (type.getName().equals(view.getContentExpense())){
                    type.setCheck(0);
                    break;
                } else {
                    ArrayList<ExpenseDTO> listExpense = (ArrayList<ExpenseDTO>) expenseDAO.getAllListExpenses(type);
                    for (ExpenseDTO expenseDTO : listExpense){
                        if (expenseDTO.getName().equals(view.getContentExpense())){
                            expenseDTO.setCheck(0);
                            kt = 1;
                            break;
                        }
                    }
                    if (kt == 1)
                        break;
                }
            }
        }
    }
}
