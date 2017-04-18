package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.princetoad.costmanagement.Common.Constant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private Collection<AccountDTO> account = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
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

    public List<AccountDTO> getAccount() {
        return new ArrayList<>(account) ;
    }

    public void setAccount(List<AccountDTO> account) {
        this.account = account;
    }
}
