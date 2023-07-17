package com.example.graphicalpassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button checkpass,regpass;
    EditText e1;
    TextView txt;
    String f="false";
    getAllData g;
    String data;
    String user= "passgraphical@gmail.com",c="",pp="";
    String password = "uewwxbqowraqmwzo";
    String sb, bd, rp;
    GMailSender sender;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkpass=(Button) findViewById(R.id.btn);
        regpass=(Button) findViewById(R.id.setpass);
        e1=(EditText) findViewById(R.id.email);
        txt=(TextView) findViewById(R.id.ee);

        sender = new GMailSender(user, password);
        checkpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pp=e1.getText().toString();

                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference root=db.getReference("Data");

                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        ArrayList<Integer> ar=new ArrayList<Integer>();
                        ar.add(1);ar.add(2);ar.add(3);ar.add(4);ar.add(5);ar.add(6);ar.add(7);ar.add(8);ar.add(9);
                        Collections.shuffle(ar);
                        data="";

                        for(int i=0;i<ar.size()-4;i++){
                            //ar2.add(ar.get(i));
                            data+=String.valueOf(ar.get(i));
                        }
                        String re="";
                        for(int k=0;k<data.length();k++){

                            if(String.valueOf(data.charAt(k)).equals("1")){
                                re+="Red  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("2")){
                                re+="Green  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("3")){
                                re+="Blue  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("4")){
                                re+="Brown  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("5")){
                                re+="Yellow  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("6")){
                                re+="Orange  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("7")){
                                re+="Pink  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("8")){
                                re+="Black  ";
                            }
                            if(String.valueOf(data.charAt(k)).equals("9")){
                                re+="White  ";
                            }
                        }

                        for(DataSnapshot snapshot1:snapshot.getChildren()){
                            g=new getAllData();
                            g=snapshot1.getValue(getAllData.class);
                            c=g.getEmail();
                            String p=pp;
                            if(c.equals(p)){
                                f="true";
                            }

                        }
                        if(f.equals("true")){
                            Intent i=new Intent(getApplicationContext(),CheckOTP.class);
                            i.putExtra("otp",data);
                            startActivity(i);
                            finish();
                            rp=e1.getText().toString();
                            sb="Graphical Password Authentication!!";
                            bd=re;
                            new MyAsyncClass().execute();
                            //Toast.makeText(getApplicationContext(),"okok",Toast.LENGTH_LONG).show();
                        }else if(pp.isEmpty()){
                            Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Details Not Found", Toast.LENGTH_SHORT).show();
                        }

                        f="false";
                        data="";
                        re="";

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                data="";

            }
        });

        regpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Regpass.class);
                startActivity(i);
                finish();
            }
        });
    }
    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }

        @Override

        protected Void doInBackground(Void... mApi) {
            try {

                // Add subject, Body, your mail Id, and receiver mail Id.
                sender.sendMail(sb, bd, user, rp);
                Log.d("send", "done");
            }
            catch (Exception ex) {
                Log.d("exceptionsending", ex.toString());
            }
            return null;
        }

        @Override

        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            pDialog.cancel();

            //Toast.makeText(MainActivity.this, "mail send", Toast.LENGTH_SHORT).show();

        }
    }
}