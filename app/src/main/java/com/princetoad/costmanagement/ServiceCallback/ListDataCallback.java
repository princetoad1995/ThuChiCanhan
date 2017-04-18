package com.princetoad.costmanagement.ServiceCallback;

import com.princetoad.costmanagement.Common.Domain.BaseDTO;

import java.util.ArrayList;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public interface ListDataCallback <T extends BaseDTO>{
    public void onSuccess(ArrayList<T> data);

    public void onFail (String error);
}
