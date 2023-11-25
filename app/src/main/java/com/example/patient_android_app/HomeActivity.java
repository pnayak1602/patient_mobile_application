package com.example.patient_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    Button docavai_btn;
    DBHelper DB;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        docavai_btn = findViewById(R.id.avaiDoc);
        lv = findViewById(R.id.listView);
        DB = new DBHelper(this);
        docavai_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> docList = DB.getDoctors();
                ArrayAdapter docListAdap = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, docList);
                lv.setAdapter(docListAdap);
            }
        });
    }
}