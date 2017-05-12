package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public interface TabNoteView extends ViewBase{
    public void onSuccess();
    public void setUser(UserDTO userDTO);
    public int getType();
    public void setAccount(AccountDTO account);
}
