package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.princetoad.costmanagement.Presenter.LoginPresenter;
import com.princetoad.costmanagement.PresenterImpl.LoginPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.LoginView;

public class LoginActivity extends BaseActivity implements LoginView{
    private EditText username, password;
    private TextView txt_register;
    private Button btn_login;
    private LoginPresenter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        control();
    }

    public void init(){
        controller = new LoginPresenterImpl(LoginActivity.this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        txt_register = (TextView) findViewById(R.id.txt_register);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    public void control(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onLoginEvent(username.getText().toString(), password.getText().toString());
            }
        });
        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void loginSuccess() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
