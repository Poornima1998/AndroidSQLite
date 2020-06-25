package com.example.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText et_name, et_email, et_mobile;
    Button btn_submit;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(this);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_mobile = findViewById(R.id.et_mobile);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
    }

    private void AddData(){
        if (et_name.getText().toString().isEmpty())
        {
            et_name.setError("Name is required");
            et_name.requestFocus();
        }
        if (et_email.getText().toString().isEmpty())
        {
            et_email.setError("Email is required");
            et_email.requestFocus();
        }
        if (et_mobile.getText().toString().isEmpty())
        {
            et_mobile.setError("Phone is required");
            et_mobile.requestFocus();
        }
        else
        {
            boolean isInserted = dbHandler.addData(et_name.getText().toString(), et_email.getText().toString(), et_mobile.getText().toString());

            if (isInserted)
            {
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT).show();
            }
        }
    }
}