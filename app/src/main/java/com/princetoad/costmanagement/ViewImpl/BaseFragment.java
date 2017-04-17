package com.princetoad.costmanagement.ViewImpl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.princetoad.costmanagement.View.ViewBase;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public abstract class BaseFragment extends Fragment implements ViewBase {
    private ProgressDialogImpl pDialog = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(setLayout(), container, false);
        pDialog = new ProgressDialogImpl(getContext());
        init(v);
        control();
        return v;
    }

    @Override
    public void showMessage(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
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

    @Override
    public void showLoadingDialog(String message) {
        pDialog.showLoadingDialog(message);
    }

    @Override
    public void hideLoadingDialog() {
        pDialog.hideLoadingDialog();
    }

    @Override
    public void toastMessage(String message) {

    }

    protected abstract void init(View v);

    protected abstract void control();

    protected abstract int setLayout();
}
