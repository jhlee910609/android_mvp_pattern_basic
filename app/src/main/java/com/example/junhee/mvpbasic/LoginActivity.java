package com.example.junhee.mvpbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.junhee.mvpbasic.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    // Activity, Fragment, custom view 모두 MVP에서 view에 속함
    // Daager2의 @Inject annotation을 활용하여 presenter를 주입한다.
    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstName;
    private EditText lastName;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        firstName = (EditText) findViewById(R.id.loginActivity_firstName_editText);
        lastName = (EditText) findViewById(R.id.loginActivity_lastName_editText);
        login = (Button) findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();

    }

    @Override
    public String getFirstName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "input Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "saved success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);

    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }
}
