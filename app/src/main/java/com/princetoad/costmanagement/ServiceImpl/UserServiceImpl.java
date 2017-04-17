package com.princetoad.costmanagement.ServiceImpl;

import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.Service.UserService;
import com.princetoad.costmanagement.ServiceCallback.DataCallback;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class UserServiceImpl implements UserService{

    @Override
    public void login(String username, String password, DataCallback<UserDTO> callback) {

    }

    @Override
    public void register(UserDTO user, DataCallback<UserDTO> callback) {

    }
}
