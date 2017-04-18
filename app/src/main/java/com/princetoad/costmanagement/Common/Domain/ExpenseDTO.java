package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_EXPENSE.TABLE_EXPENSE_NAME)
public class ExpenseDTO {
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_EXPENSE.EXPENSE_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_EXPENSE.EXPENSE_NAME)
    private String name;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_EXPENSE.EXPENSE_TYPE_EXPENSE, foreign = true, foreignAutoRefresh = true)
    private TypeExpenseDTO typeExpenseDTO;

    public ExpenseDTO() {
    }

    public ExpenseDTO(String name, TypeExpenseDTO typeExpenseDTO) {
        this.name = name;
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

    public TypeExpenseDTO getTypeExpenseDTO() {
        return typeExpenseDTO;
    }

    public void setTypeExpenseDTO(TypeExpenseDTO typeExpenseDTO) {
        this.typeExpenseDTO = typeExpenseDTO;
    }
}
