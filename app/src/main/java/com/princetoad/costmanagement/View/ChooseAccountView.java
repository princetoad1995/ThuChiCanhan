package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/20/2017.
 */

public interface ChooseAccountView extends ViewBase{
    public void setListAccount(List<AccountDTO> list);
}
