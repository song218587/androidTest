package com.hanbit.app.week161105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.app.week161105.globel.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper{
    //3. MemberServiceImpl에서 생성

    //이것은.. 생성자:)
    //SQLiteOpenHelper 안에 있는 것 구현(Alt+insert: MemberDAO,onCreate,onUpgrade선택)
    public MemberDAO(Context context) {
        super(context, "hanbit.db", null, 1);
        // (context, "의미는 없지만;;; db이름 넣음",null(자바가아 아닌 우리가 만든거 쓰겠다는 뜻),버전);
        this.getWritableDatabase();
        Log.d("DB생성","=====================SUCCESS2=======================");
        // DB만들기
    }

    // DB만들면 테이블을 자동으로 만들어라
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MEMBER 진입","=====================진입=======================");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Member.TABLE+"\n" +
                "(\n" +
                Member.ID+" text primary key,\n" +
                Member.PW +" text,\n" +
                Member.NAME + " text,\n" +
                Member.EMAIL + " text,\n" +
                Member.PHONE + " text,\n" +
                Member.PHOTO + " text,\n" +
                Member.ADDR + " text" +
                ");");
        db.execSQL("INSERT INTO " + Member.TABLE+"("+ Member.ID+","+Member.PW
                +","+Member.NAME
                +","+ Member.EMAIL
                +","+ Member.PHONE
                +","+Member.PHOTO
                +","+Member.ADDR +")\n" +
                "VALUES ('hong', 1, 'Gildong','hong@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        Log.d("MEMBER TABE 생성","=====================SUCCESS=======================");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // 서비스에서 복붙. 데이터 베이스를 위해 존재
    public void insert(MemberDTO param){
        String sql ="";

        Log.d("DAO JOIN : ID", param.getId());
        Log.d("DAO JOIN : PW", param.getPw());
        Log.d("DAO JOIN : NAME", param.getName());
        Log.d("DAO JOIN : Email", param.getEmail());
        Log.d("DAO JOIN : Phone", param.getPhone());
        Log.d("DAO JOIN : Addr", param.getAddr());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public int selectCount(){
        int count = 0;
        return count;
    }
    public MemberDTO  detail(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }
    public MemberDTO login(MemberDTO param){
        Log.d("DAO JOIN : ID", param.getId());
        Log.d("DAO JOIN : PW", param.getPw());

        String sql = "SELECT "+ Member.PW+
                " FROM "+Member.TABLE+"WHERE id ='" + param.getId()+"';";

        MemberDTO member = new MemberDTO();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToNext()){
           //cursor.getString 배열로 받는다. 여러개 있으면 배열로 받아 인덱스 부여, 여기서는 패스워드 하나니까 0
            member.setPw(cursor.getString(0));
        }

        Log.d("PW", member.getPw());

        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
