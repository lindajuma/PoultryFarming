package com.medeline.poultryfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    public TextView registration;
    public EditText firstname;
    public EditText secondname;
    public EditText username;
    public EditText emailaddress;
    public Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registration=findViewById(R.id.tv_register_id);
        firstname=findViewById(R.id.et_firstname_id);
        secondname=findViewById(R.id.et_secondname_id);
        username=findViewById(R.id.et_username_id);
        emailaddress=findViewById(R.id.et_emailaddress_id);
        register=findViewById(R.id.btn_register_id);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=(new Intent(RegistrationActivity.this, LoginActivity.class));
                startActivity(intent);

            }


        });


    }


}