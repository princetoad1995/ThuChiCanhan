package com.princetoad.costmanagement.ViewImpl;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ViewBase;

/**
 * Created by PRINCE D. TOAD on 3/27/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewBase {

    private ProgressDialogImpl pDialog = null;
    protected Toolbar toolbar;

    public void showLoadingDialog(String title) {
        pDialog.showLoadingDialog(title);

    }

    public void hideLoadingDialog() {
        pDialog.hideLoadingDialog();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pDialog = new ProgressDialogImpl(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//        setToolbar("HQH");
    }

    public void showMessage(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Thông báo");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
