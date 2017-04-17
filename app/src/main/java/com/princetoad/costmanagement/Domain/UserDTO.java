package com.princetoad.costmanagement.Domain;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.princetoad.costmanagement.Common.Constant;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class UserDTO extends BaseDTO {
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_USER.USER_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_USER.USER_NAME)
    private String name;

    @DatabaseField(columnName = Constant.TABLE_USER.USER_PASS)
    private String password;

    // One-to-many
    @ForeignCollectionField(columnName = Constant.TABLE_USER.USER_ACCOUNT, eager = true)
    private ForeignCollection<AccountDTO> expenses;

    public UserDTO() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ForeignCollection<AccountDTO> getExpenses() {
        return expenses;
    }

    public void setExpenses(ForeignCollection<AccountDTO> expenses) {
        this.expenses = expenses;
    }
}
