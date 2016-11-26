package com.hanbit.app.week161105.movie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public class MovieDAO extends SQLiteOpenHelper {
    public MovieDAO(Context context) {
        super(context, "", null, 1);
    }
    //DB 생성은 딱 한군데에서 해야해서 그냥 만들어 두기만..
    // 처음 생성된 곳에서
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void add(MovieDTO param){
        String sql = "INSTER INTO aaa() VALUES()";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public int count(){
        String sql = "SELECT COUNT(*) FROM aaa";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return 0;
    }
    public MovieDTO findOne(String key){
        String sql = "SELECT * FROM aaa WHERE column = 'key';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;
    }
    public ArrayList<MovieDTO> findBy(MovieDTO param){
        String sql = "SELECT * FROM aaa WHERE colum = 'search word'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;}
    public ArrayList<MovieDTO> list(){
        String sql = "SELECT * FROM aaa";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return null;}
    public void update(MovieDTO param){
        String sql = "UPDATE aaa SET colume1 = 'vlaue', colume1 = 'vlaue' WHERE column='key'";//스트링도 객체1
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void delete(String key){
        String sql = "DELETE FROM aaa where colume='key';";//스트링도 객체1
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }





}
