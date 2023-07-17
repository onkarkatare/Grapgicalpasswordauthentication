package com.example.graphicalpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Regpass extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpass);
        e1=(EditText) findViewById(R.id.uname);
        e2=(EditText) findViewById(R.id.email);
        e3=(EditText) findViewById(R.id.mno);
        b1=(Button) findViewById(R.id.checkpass);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllData g=new getAllData(e1.getText().toString(),e2.getText().toString());
                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference root=db.getReference("Data");

                if(e1.getText().toString().equals("") || e2.getText().toString().equals("") || e3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Fill All the Edit Text", Toast.LENGTH_SHORT).show();
                }else{
                    root.child(e3.getText().toString()).setValue(g);
                    Toast.makeText(getApplicationContext(), "Data Insertd", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}