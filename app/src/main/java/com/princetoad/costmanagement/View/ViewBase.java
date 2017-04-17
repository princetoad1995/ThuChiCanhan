package com.princetoad.costmanagement.View;

/**
 * Created by PRINCE D. TOAD on 3/27/2017.
 */

public interface ViewBase {
    public void showMessage(String message);

    public void showLoadingDialog(String message);

    public void hideLoadingDialog();

    public void toastMessage(String message);
}
