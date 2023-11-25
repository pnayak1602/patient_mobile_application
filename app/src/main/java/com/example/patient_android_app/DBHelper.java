package com.example.patient_android_app;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, firstname TEXT, lastname TEXT, age TEXT, medicalhistory TEXT)");
        MyDB.execSQL("create Table doctors(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, isavailable INT DEFAULT 1)");
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", "Dr. Hariprasad");
        MyDB.insert("doctors", null, contentValues);
        contentValues.put("name", "Dr. Nellai");
        MyDB.insert("doctors", null, contentValues);
        contentValues.put("name", "Dr. Dey");
        MyDB.insert("doctors", null, contentValues);
        contentValues.put("name", "Dr. Sharma");
        MyDB.insert("doctors", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password, String firstname, String lastname, String age, String medicalHistory){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("firstname", firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("age", age);
        contentValues.put("medicalhistory", medicalHistory);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public ArrayList getDoctors(){

        ArrayList<String> DoctorsList = new ArrayList<>();
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from doctors where isavailable = ?", new String[]{String.valueOf(1)});
        if(cursor.moveToFirst())
        {
            do{
                DoctorsList.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
    else{

        }
        cursor.close();
        MyDB.close();
        return DoctorsList;
    }
}