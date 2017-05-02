package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_EXPENSE.TABLE_EXPENSE_NAME)
public class ExpenseDTO extends BaseDTO{
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_EXPENSE.EXPENSE_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_EXPENSE.EXPENSE_NAME)
    private String name;

    @DatabaseField(columnName = Constant.TABLE_EXPENSE.EXPENSE_CHECK)
    private int check;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_EXPENSE.EXPENSE_TYPE_EXPENSE, foreign = true, foreignAutoRefresh = true)
    private TypeExpenseDTO typeExpenseDTO;

    // One-to-many
    @ForeignCollectionField(columnName = Constant.TABLE_EXPENSE.EXPENSE_MANAGE, eager = true)
    private Collection<ManageDTO> manage = new ArrayList<>();

    public ExpenseDTO() {
    }

    public ExpenseDTO(String name, int check, TypeExpenseDTO typeExpenseDTO) {
        this.name = name;
        this.check = check;
        this.typeExpenseDTO = typeExpenseDTO;
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

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public TypeExpenseDTO getTypeExpenseDTO() {
        return typeExpenseDTO;
    }

    public void setTypeExpenseDTO(TypeExpenseDTO typeExpenseDTO) {
        this.typeExpenseDTO = typeExpenseDTO;
    }
}
