package com.princetoad.costmanagement.DAO;

import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.ServiceCallback.DataCallback;
import com.princetoad.costmanagement.ServiceCallback.InfoCallback;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public interface UserDAO {
    public void login(String username, String password, DataCallback<UserDTO> callback);
    public void register(UserDTO user, InfoCallback callback);
    public UserDTO getCurrentUser();
}
