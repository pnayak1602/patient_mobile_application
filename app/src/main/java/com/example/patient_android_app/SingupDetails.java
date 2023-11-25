package com.example.patient_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
interface def{
    void define_items();
}
public class SingupDetails extends AppCompatActivity {

    EditText firstname, lastname, age, medhis;
    Button reg;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String user = intent.getExtras().getString("user","");
        String pass = intent.getExtras().getString("pass","");
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
        medhis = (EditText) findViewById(R.id.medhis);
        reg = (Button) findViewById(R.id.registerbutton);
        DB = new DBHelper(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = firstname.getText().toString();
                String ln = lastname.getText().toString();
                String a = age.getText().toString();
                String md = medhis.getText().toString();

                    Boolean insert = DB.insertData(user, pass, fn, ln, a, md);
                    if(insert==true){
                        Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }
}