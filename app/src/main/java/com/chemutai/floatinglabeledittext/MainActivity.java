package com.chemutai.floatinglabeledittext;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etFullName, etEmail, etPassword;
    private TextInputLayout inputLayoutFullName, inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeWidgets();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }

    private void initializeWidgets() {

        inputLayoutFullName = findViewById(R.id.inputLayoutFullName);
        inputLayoutEmail = findViewById(R.id.inputLayoutEmail);
        inputLayoutPassword = findViewById(R.id.inputLayoutPassword);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        //validate input fields
        boolean isValid = true;
        if (etFullName.getText().toString().isEmpty()){
            inputLayoutFullName.setError(getString(R.string.username_validation_msg));
            isValid = false;
        } else {
            inputLayoutFullName.setErrorEnabled(false);
        }


        //Email Validation
        if (etEmail.getText().toString().isEmpty()){
            inputLayoutEmail.setError(getString(R.string.email_validation_msg));
            isValid = false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        //Password Validation
        if (etPassword.getText().toString().trim().length() < 8){
            inputLayoutPassword.setError(getString(R.string.pwd_validation_msg));
            isValid = false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        if (isValid){
            Toast.makeText(MainActivity.this, R.string.signup_success, Toast.LENGTH_SHORT).show();
        }
    }
}
