package com.medeline.poultryfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public static boolean isChecked;
    public TextView login;
    public EditText emailaddress;
    public EditText password;
    public Button  submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.tv_login_id);
        emailaddress=findViewById(R.id.et_emailaddress_id);
        password=findViewById(R.id.et_password_id);
        submit=findViewById(R.id.btn_submit_id);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=(new Intent(LoginActivity.this, MainActivity.class));
                startActivity(intent);






            }
        });
    }
}