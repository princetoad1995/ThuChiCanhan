package com.princetoad.costmanagement.ViewImpl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.R;

public class NoteDescriptionActivity extends BaseActivity {
    private EditText txt_note_description;
    private Button btn_save_des_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_description);

        setToolbar("Diễn giải");
        init();
        control();
    }

    public void init(){
        txt_note_description = (EditText) findViewById(R.id.txt_note_description);
        btn_save_des_note = (Button) findViewById(R.id.btn_save_des_note);

        Intent i = getIntent();
        if (i.getSerializableExtra("content_des") != null){
            txt_note_description.setText(i.getSerializableExtra("content_des") + "");
            txt_note_description.setSelection(txt_note_description.getText().toString().length());
        }
    }

    public void control(){
        btn_save_des_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NoteDescriptionActivity.this, MainActivity.class);
                i.putExtra("des", txt_note_description.getText().toString());
                setResult(Constant.INTENT.RESULT_CODE_DESCRIPTION, i);
                finish();
                InputMethodManager inputMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMgr.hideSoftInputFromWindow(txt_note_description.getWindowToken(), 0);
            }
        });
        btn_info_back_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMgr.hideSoftInputFromWindow(txt_note_description.getWindowToken(), 0);
                finish();
            }
        });
    }
}
