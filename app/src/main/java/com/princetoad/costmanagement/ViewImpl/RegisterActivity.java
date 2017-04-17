package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.princetoad.costmanagement.Domain.UserDTO;
import com.princetoad.costmanagement.Presenter.RegisterPresenter;
import com.princetoad.costmanagement.PresenterImpl.LoginPresenterImpl;
import com.princetoad.costmanagement.PresenterImpl.RegisterPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView{
    private EditText username, password;
    private Button btn_login;
    private RegisterPresenter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        control();
    }

    public void init(){
        controller = new RegisterPresenterImpl(RegisterActivity.this);
        username = (EditText) findViewById(R.id.username_register);
        password = (EditText) findViewById(R.id.password_register);
        btn_login = (Button) findViewById(R.id.btn_register);
    }

    public void control(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDTO user = new UserDTO();
                user.setName(username.getText().toString());
                user.setPassword(username.getText().toString());
                controller.onRegisterEvent(user);
            }
        });
    }

    @Override
    public void registerSuccess() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
