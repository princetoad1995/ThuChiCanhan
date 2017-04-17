package com.princetoad.costmanagement.ViewImpl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.R;

public class MainActivity extends BaseActivity {
    private FragmentTransaction transaction;
    private LinearLayout tab_note, tab_account, tab_report, tab_utility;
    private ImageView icon_note, icon_account, icon_report, icon_utility;
    private TextView txt_note, txt_account, txt_report, txt_utility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();
    }

    private void init(){
        tab_note = (LinearLayout) findViewById(R.id.tab_note);
        tab_account = (LinearLayout) findViewById(R.id.tab_account);
        tab_report = (LinearLayout) findViewById(R.id.tab_report);
        tab_utility = (LinearLayout) findViewById(R.id.tab_utility);
        icon_note = (ImageView) findViewById(R.id.icon_note);
        icon_account = (ImageView) findViewById(R.id.icon_account);
        icon_report = (ImageView) findViewById(R.id.icon_report);
        icon_utility = (ImageView) findViewById(R.id.icon_utility);
        txt_note = (TextView) findViewById(R.id.txt_note);
        txt_account = (TextView) findViewById(R.id.txt_account);
        txt_report = (TextView) findViewById(R.id.txt_report);
        txt_utility = (TextView) findViewById(R.id.txt_utility);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, TabNoteFragment.getInstance());
        transaction.commit();
    }

    private void control(){
        Fragment selectedFragment = null;
        tab_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon_note.setImageResource(R.drawable.ic_note_blue);
                txt_note.setTextColor(getResources().getColor(R.color.colorPrimary));
                icon_account.setImageResource(R.drawable.ic_account_gray);
                txt_account.setTextColor(getResources().getColor(R.color.colorGray));
                icon_report.setImageResource(R.drawable.ic_report_gray);
                txt_report.setTextColor(getResources().getColor(R.color.colorGray));
                icon_utility.setImageResource(R.drawable.ic_utility_gray);
                txt_utility.setTextColor(getResources().getColor(R.color.colorGray));
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, TabNoteFragment.getInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        tab_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon_note.setImageResource(R.drawable.ic_note_gray);
                txt_note.setTextColor(getResources().getColor(R.color.colorGray));
                icon_account.setImageResource(R.drawable.ic_account_blue);
                txt_account.setTextColor(getResources().getColor(R.color.colorPrimary));
                icon_report.setImageResource(R.drawable.ic_report_gray);
                txt_report.setTextColor(getResources().getColor(R.color.colorGray));
                icon_utility.setImageResource(R.drawable.ic_utility_gray);
                txt_utility.setTextColor(getResources().getColor(R.color.colorGray));
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, TabAccountFragment.getInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        tab_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon_note.setImageResource(R.drawable.ic_note_gray);
                txt_note.setTextColor(getResources().getColor(R.color.colorGray));
                icon_account.setImageResource(R.drawable.ic_account_gray);
                txt_account.setTextColor(getResources().getColor(R.color.colorGray));
                icon_report.setImageResource(R.drawable.ic_report_blue);
                txt_report.setTextColor(getResources().getColor(R.color.colorPrimary));
                icon_utility.setImageResource(R.drawable.ic_utility_gray);
                txt_utility.setTextColor(getResources().getColor(R.color.colorGray));

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, TabReportFragment.getInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        tab_utility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon_note.setImageResource(R.drawable.ic_note_gray);
                txt_note.setTextColor(getResources().getColor(R.color.colorGray));
                icon_account.setImageResource(R.drawable.ic_account_gray);
                txt_account.setTextColor(getResources().getColor(R.color.colorGray));
                icon_report.setImageResource(R.drawable.ic_report_gray);
                txt_report.setTextColor(getResources().getColor(R.color.colorGray));
                icon_utility.setImageResource(R.drawable.ic_utility_blue);
                txt_utility.setTextColor(getResources().getColor(R.color.colorPrimary));

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, TabUtilityFragment.getInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
}
