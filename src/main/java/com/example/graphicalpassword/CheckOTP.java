package com.example.graphicalpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckOTP extends AppCompatActivity {
    boolean f1=false,f2=false,f3=false,f4=false,f5=false,f6=false,f7=false,f8=false,f9=false;
    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0;

    Button b;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_otp);
        b1=(ImageButton) findViewById(R.id.b1);
        b2=(ImageButton) findViewById(R.id.b2);
        b3=(ImageButton) findViewById(R.id.b3);
        b4=(ImageButton) findViewById(R.id.b4);
        b5=(ImageButton) findViewById(R.id.b5);
        b6=(ImageButton) findViewById(R.id.b6);
        b7=(ImageButton) findViewById(R.id.b7);
        b8=(ImageButton) findViewById(R.id.b8);
        b9=(ImageButton) findViewById(R.id.b9);
        b=(Button) findViewById(R.id.chk);
    }
    public void b1(View v){
        if(c1==0){
            c1++;
            b1.setBackgroundColor(getResources().getColor(R.color.silver));
            f1=true;
        }else{
            c1--;
            f1=false;
            b1.setBackgroundColor(getResources().getColor(R.color.Red));
        }
    }

    public void b2(View v){
        if(c2==0){
            c2++;
            b2.setBackgroundColor(getResources().getColor(R.color.silver));
            f2=true;
        }else{
            c2--;
            f2=false;
            b2.setBackgroundColor(getResources().getColor(R.color.Green));
        }
    }

    public void b3(View v){
        if(c3==0){
            c3++;
            b3.setBackgroundColor(getResources().getColor(R.color.silver));
            f3=true;
        }else{
            c3--;
            f3=false;
            b3.setBackgroundColor(getResources().getColor(R.color.Blue));
        }
    }

    public void b4(View v){
        if(c4==0){
            c4++;
            b4.setBackgroundColor(getResources().getColor(R.color.silver));
            f4=true;
        }else{
            c4--;
            f4=false;
            b4.setBackgroundColor(getResources().getColor(R.color.brown));
        }
    }

    public void b5(View v){
        if(c5==0){
            c5++;
            b5.setBackgroundColor(getResources().getColor(R.color.silver));
            f5=true;
        }else{
            c5--;
            f5=false;
            b5.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
    }

    public void b6(View v){
        if(c6==0){
            c6++;
            b6.setBackgroundColor(getResources().getColor(R.color.silver));
            f6=true;
        }else{
            c6--;
            f6=false;
            b6.setBackgroundColor(getResources().getColor(R.color.orange));
        }
    }

    public void b7(View v){
        if(c7==0){
            c7++;
            b7.setBackgroundColor(getResources().getColor(R.color.silver));
            f7=true;
        }else{
            c7--;
            f7=false;
            b7.setBackgroundColor(getResources().getColor(R.color.Pink));
        }
    }

    public void b8(View v){
        if(c8==0){
            c8++;
            b8.setBackgroundColor(getResources().getColor(R.color.silver));
            f8=true;
        }else{
            c8--;
            f8=false;
            b8.setBackgroundColor(getResources().getColor(R.color.Black));
        }
    }

    public void b9(View v){
        if(c9==0){
            c9++;
            b9.setBackgroundColor(getResources().getColor(R.color.silver));
            f9=true;
        }else{
            c9--;
            f9=false;
            b9.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    public void chk(View v){
        ArrayList<String> li=new ArrayList<String>();
        String st="";
        if(f1){
            st+="1";
        }if(f2){
            st+="2";
        }if(f3){
            st+="3";
        }if(f4){
            st+="4";
        }if(f5){
            st+="5";
        }if(f6){
            st+="6";
        }if(f7){
            st+="7";
        }if(f8){
            st+="8";
        }if(f9){
            st+="9";
        }

        String otp=getIntent().getExtras().getString("otp");
        String ok=otp;
        char arr[]=otp.toCharArray();
        Arrays.sort(arr);
        otp=new String(arr);
///       Toast.makeText(this, otp, Toast.LENGTH_SHORT).show();
        //b.setText(otp+"    "+ok);
        if(otp.equals(st)){
            Intent i=new Intent(getApplicationContext(),Loginok.class);
            startActivity(i);
            finish();
            //Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "OTP Incorrect !!!", Toast.LENGTH_SHORT).show();
            Intent k=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(k);
            finish();

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent ii=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ii);
        finish();
    }

}