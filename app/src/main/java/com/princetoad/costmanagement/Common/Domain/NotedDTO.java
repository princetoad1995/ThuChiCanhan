package com.princetoad.costmanagement.Common.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.princetoad.costmanagement.Common.Constant;

/**
 * Created by PRINCE D. TOAD on 5/12/2017.
 */

@DatabaseTable(tableName = Constant.TABLE_NOTED.TABLE_NOTED_NAME)
public class NotedDTO {
    @DatabaseField(generatedId = true, columnName = Constant.TABLE_NOTED.NOTED_ID)
    private int id;
    @DatabaseField(columnName = Constant.TABLE_NOTED.NOTED_DATE)
    private String date;
    @DatabaseField(columnName = Constant.TABLE_NOTED.NOTED_EARN_MONEY)
    private long earn_money;
    @DatabaseField(columnName = Constant.TABLE_NOTED.NOTED_PAY_MONEY)
    private long pay_money;

    public NotedDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getEarn_money() {
        return earn_money;
    }

    public void setEarn_money(long earn_money) {
        this.earn_money = earn_money;
    }

    public long getPay_money() {
        return pay_money;
    }

    public void setPay_money(long pay_money) {
        this.pay_money = pay_money;
    }
}
