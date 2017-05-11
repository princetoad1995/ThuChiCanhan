package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/21/2017.
 */

public interface TabAccountView {
    public void setListAccount(List<AccountDTO> list);

    public void setTotalMoney(long total);
}
