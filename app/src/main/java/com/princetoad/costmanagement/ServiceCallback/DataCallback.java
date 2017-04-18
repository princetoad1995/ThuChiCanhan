package com.princetoad.costmanagement.ServiceCallback;

import com.princetoad.costmanagement.Common.Domain.BaseDTO;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public interface DataCallback<T extends BaseDTO> {
    public void onSuccess(T data);
    public void onFail(String error);
}
