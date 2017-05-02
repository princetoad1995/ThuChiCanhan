package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

import java.io.Serializable;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_ACCOUNT.TABLE_ACCOUNT_NAME)
public class AccountDTO extends BaseDTO{

    @DatabaseField(generatedId = true, columnName = Constant.TABLE_ACCOUNT.ACCOUNT_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_NAME)
    private String name;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_MONEY)
    private long money;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_CHECK)
    private int checked;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_USER, foreign = true, foreignAutoRefresh = true)
    private UserDTO userDTO;

    public AccountDTO() {
    }

    public AccountDTO(String name, long money, int checked, UserDTO userDTO) {
        this.name = name;
        this.money = money;
        this.checked = checked;
        this.userDTO = userDTO;
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

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
