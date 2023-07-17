package com.example.graphicalpassword;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;


public class DataBase extends SQLiteOpenHelper {
    public static final String db="Pass.db";
    public static final String table_name="grappass";
    public static final String col_1="Id";
    public static final String col_2="uname";
    public static final String col_3="email";
    public static final String col_4="mno";
    public DataBase(Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sq) {
        sq.execSQL(" create table " +table_name+" (Id INTEGER PRIMARY KEY AUTOINCREMENT,uname TEXT,email TEXT,mno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sq, int i, int i1) {
        sq.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sq);
    }
    public boolean insertdata(String uname,String email,String mno){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues co=new ContentValues();
        co.put(col_2,uname);
        co.put(col_3,email);
        co.put(col_4,mno);
        long re=sq.insert(table_name,null,co);
        if(re==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor check(String email){
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor c=sq.rawQuery("select * from "+table_name+" where email='"+email+"'",null);
        return c;
    }
}

