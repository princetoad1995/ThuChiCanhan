package com.princetoad.costmanagement.DAO;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public interface AccountDAO {
    public void addAccount(AccountDTO account);

    public List<AccountDTO> getAllListAccounts();
}
