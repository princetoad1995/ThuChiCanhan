package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_MANAGE.TABLE_MANAGE_NAME)
public class ManageDTO extends BaseDTO{
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_MANAGE.MANAGE_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_TYPE)
    private int type;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_USER, foreign = true, foreignAutoRefresh = true)
    private UserDTO userDTO;

    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_MONEY)
    private long money;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_TYPE_EXPENSE, foreign = true, foreignAutoRefresh = true)
    private TypeExpenseDTO typeExpenseDTO;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_EXPENSE, foreign = true, foreignAutoRefresh = true)
    private ExpenseDTO expenseDTO;

    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_DESCRIPTION)
    private String description;

    // One-to-many
    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_ACCOUNT, foreign = true, foreignAutoRefresh = true)
    private AccountDTO accountDTO;

    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_DATE)
    private String date;

    @DatabaseField(columnName = Constant.TABLE_MANAGE.MANAGE_HOUR)
    private String hour;

    public ManageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public TypeExpenseDTO getTypeExpenseDTO() {
        return typeExpenseDTO;
    }

    public void setTypeExpenseDTO(TypeExpenseDTO typeExpenseDTO) {
        this.typeExpenseDTO = typeExpenseDTO;
    }

    public ExpenseDTO getExpenseDTO() {
        return expenseDTO;
    }

    public void setExpenseDTO(ExpenseDTO expenseDTO) {
        this.expenseDTO = expenseDTO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
