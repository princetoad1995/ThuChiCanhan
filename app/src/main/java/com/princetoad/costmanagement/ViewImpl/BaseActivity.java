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

    private ProgressDialog pDialog = null;
    protected Toolbar toolbar;

    public void showLoadingDialog(String title) {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage(title);
        pDialog.show();
        pDialog.setCancelable(false);
    }

    public void hideLoadingDialog() {
        if (pDialog != null) {
            pDialog.hide();
            pDialog.cancel();
        }
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

//    public void showConfirm(String title, String message, final ConfirmAction action) {
//        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
//        builder.setTitle(title);
//        builder.setMessage(message)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                        action.onPositiveButtonClicked();
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                        action.onNegativeButtonClicked();
//                    }
//                });
//        android.app.AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
//
//    protected void setToolbar(String title) {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle(title);
//            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onBackPressed();
//                }
//            });
//        }
//    }

//    protected void hideKeyboard() {
//        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(this);
//        }
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
}
