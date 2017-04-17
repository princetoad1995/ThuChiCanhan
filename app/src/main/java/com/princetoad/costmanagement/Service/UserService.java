package com.princetoad.costmanagement.Service;

import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.ServiceCallback.DataCallback;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public interface UserService {
    public void login(String username, String password, DataCallback<UserDTO> callback);

    public void register(UserDTO user, DataCallback<UserDTO> callback);
}
