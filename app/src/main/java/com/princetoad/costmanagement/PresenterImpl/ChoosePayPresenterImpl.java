package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.DAO.TypeExpenseDAO;
import com.princetoad.costmanagement.DAOImpl.TypeExpenseDAOImpl;
import com.princetoad.costmanagement.Presenter.ChoosePayPresenter;
import com.princetoad.costmanagement.View.ChoosePayView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/13/2017.
 */

public class ChoosePayPresenterImpl implements ChoosePayPresenter{
    private ChoosePayView view;
    private List<TypeExpenseDTO> listTypeExpense;
    private TypeExpenseDAO typeExpenseDAO;

    public ChoosePayPresenterImpl(ChoosePayView view) {
        this.view = view;
        this.typeExpenseDAO = new TypeExpenseDAOImpl();
        this.listTypeExpense = new ArrayList<>();

        listTypeExpense = typeExpenseDAO.getAllListTypeExpenseByType(Constant.TYPE.PAY);
        for (TypeExpenseDTO type : listTypeExpense) {
            if (type.getName().equals(view.getContentExpense())) {
                type.setCheck(1);
                break;
            }
        }
        view.setTypeExpense((ArrayList<TypeExpenseDTO>) listTypeExpense);
    }

    @Override
    public void resetCheck() {
        int kt = 0;
        if (!view.getContentExpense().isEmpty()){
            for (TypeExpenseDTO type : listTypeExpense){
                if (type.getName().equals(view.getContentExpense())){
                    type.setCheck(0);
                    break;
                }
            }
        }
    }
}
