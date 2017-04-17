package com.princetoad.costmanagement.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

import java.io.Serializable;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_ACCOUNT.TABLE_ACCOUNT_NAME)
public class AccountDTO implements Serializable{

    @DatabaseField(generatedId = true, columnName = Constant.TABLE_ACCOUNT.ACCOUNT_ID)
    private int id;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_NAME)
    private String name;

    @DatabaseField(columnName = Constant.TABLE_ACCOUNT.ACCOUNT_USER, foreign = true, foreignAutoRefresh = true)
    private UserDTO userDTO;

    public AccountDTO() {
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
}
