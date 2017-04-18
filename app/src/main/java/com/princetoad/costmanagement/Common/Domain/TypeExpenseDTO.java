package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_TYPE_EXPENSE.TABLE_TYPE_EXPENSE_NAME)
public class TypeExpenseDTO {
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_TYPE_EXPENSE.TYPE_EXPENSE_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_TYPE_EXPENSE.TYPE_EXPENSE_NAME)
    private String name;

    // One-to-many
    @ForeignCollectionField(columnName = Constant.TABLE_TYPE_EXPENSE.TYPE_EXPENSE_EXPENSE, eager = true)
    private Collection<ExpenseDTO> expenseDTOs = new ArrayList<>();

    public TypeExpenseDTO() {
    }

    public TypeExpenseDTO(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExpenseDTO> getExpenseDTOs() {
        return new ArrayList<>(expenseDTOs);
    }

    public void setExpenseDTOs(List<ExpenseDTO> expenseDTOs) {
        this.expenseDTOs = expenseDTOs;
    }
}
