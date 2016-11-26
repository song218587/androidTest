package com.hanbit.app.week161105.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.hanbit.app.week161105.globel.Member.ADDR;
import static com.hanbit.app.week161105.globel.Member.EMAIL;
import static com.hanbit.app.week161105.globel.Member.ID;
import static com.hanbit.app.week161105.globel.Member.NAME;
import static com.hanbit.app.week161105.globel.Member.PHONE;
import static com.hanbit.app.week161105.globel.Member.PHOTO;
import static com.hanbit.app.week161105.globel.Member.PW;
import static com.hanbit.app.week161105.globel.Member.TABLE;
import static com.hanbit.app.week161105.globel.Message.CONTENT;
import static com.hanbit.app.week161105.globel.Message.MESSAGE;
import static com.hanbit.app.week161105.globel.Message.RECEIVER;
import static com.hanbit.app.week161105.globel.Message.SENDER;
import static com.hanbit.app.week161105.globel.Message.WRITE_TIME;


/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper{
    //3. MemberServiceImpl에서 생성

    //이것은.. 생성자:)
    //SQLiteOpenHelper 안에 있는 것 구현(Alt+insert: MemberDAO,onCreate,onUpgrade선택)
    public MemberDAO(Context context) {
        super(context,"hanbit7.db", null, 1);
        // (context, "의미는 없지만;;; db이름 넣음",null(자바가아 아닌 우리가 만든거 쓰겠다는 뜻),버전);
        this.getWritableDatabase();
        Log.d("DB생성","=====================SUCCESS7=======================");
        // DB만들기
    }

    // DB만들면 테이블을 자동으로 만들어라
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MEMBER5 진입","=====================진입=======================");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE+"\n" +
                "(\n" +
                ID+" text primary key,\n" +
                PW +" text,\n" +
                NAME + " text,\n" +
                EMAIL + " text,\n" +
                PHONE + " text,\n" +
                PHOTO + " text,\n" +
                ADDR + " text" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS "+MESSAGE+" (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SENDER+" TEXT," +
                RECEIVER+" TEXT," +
                WRITE_TIME+" TEXT," +
                CONTENT+" TEXT," +
                ID+" TEXT, CONSTRAINT message_fk FOREIGN KEY(id) REFERENCES "
                +TABLE+"("+ID+"));");

        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+NAME
                +","+ EMAIL
                +","+ PHONE
                +","+ PHOTO
                +","+ ADDR +")\n" +
                "VALUES ('hong01', 1, 'Aname','6@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+ NAME
                +","+ EMAIL
                +","+ PHONE
                +","+ PHOTO
                +","+ ADDR +")\n" +
                "VALUES ('hong02', 1, 'Bname','5@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+ NAME
                +","+ EMAIL
                +","+ PHONE
                +","+PHOTO
                +","+ADDR +")\n" +
                "VALUES ('hong03', 1, 'Cname','4@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+NAME
                +","+ EMAIL
                +","+ PHONE
                +","+ PHOTO
                +","+ ADDR +")\n" +
                "VALUES ('hong04', 1, 'Dname','3@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+ NAME
                +","+ EMAIL
                +","+  PHONE
                +","+ PHOTO
                +","+ ADDR +")\n" +
                "VALUES ('hong05', 1, 'Ename','2@naver.com','010-1111-1111','defualt.jpg','SEOUL');");
        db.execSQL("INSERT INTO " + TABLE+"("+ ID+","+ PW
                +","+ NAME
                +","+  EMAIL
                +","+  PHONE
                +","+ PHOTO
                +","+ ADDR +")\n" +
                "VALUES ('hong06', 1, 'Fname','1@naver.com','010-1111-1111','defualt.jpg','SEOUL');");

        db.execSQL("INSERT INTO " + MESSAGE+"("+ SENDER+","+ RECEIVER
                +","+ WRITE_TIME
                +","+  CONTENT
                +","+ ID +")\n" +
                "VALUES ('KIM', 'HONG', '2016-11-26 12:40','HELLO~~HONGHONG','hong01');");
        db.execSQL("INSERT INTO " + MESSAGE+"("+ SENDER+","+ RECEIVER
                +","+ WRITE_TIME
                +","+  CONTENT
                +","+ ID +")\n" +
                "VALUES ('KIM', 'HONG', '2016-11-26 12:45','Hi','hong01');");
        db.execSQL("INSERT INTO " + MESSAGE+"("+ SENDER+","+ RECEIVER
                +","+ WRITE_TIME
                +","+  CONTENT
                +","+ ID +")\n" +
                "VALUES ('KIM', 'HONG', '2016-11-26 12:50','THANKYOU','hong01');");

        Log.d("MEMBER TABLE 생성","=====================SUCCESS=======================");
        Log.d("MASSAGE TABLE 생성","=====================SUCCESS=======================");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // 서비스에서 복붙. 데이터 베이스를 위해 존재
    public void insert(MemberDTO param){
        Log.d("DAO JOIN : ID", param.getId());
        Log.d("DAO JOIN : PW", param.getPw());
        Log.d("DAO JOIN : NAME", param.getName());
        Log.d("DAO JOIN : Email", param.getEmail());
        Log.d("DAO JOIN : Phone", param.getPhone());
        Log.d("DAO JOIN : Addr", param.getAddr());

        String sql = "INSTER INTO "+TABLE+"("+ADDR+","+EMAIL+","+ID+","+NAME+","+PHONE+","+PW+") VALUES("+param.getAddr()+","+param.getEmail()+","+param.getId()+","+param.getName()+","+param.getPhone()+","+param.getPw()+")";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public int selectCount(){
        int count = 0;

        String sql = "SELECT COUNT(*) as count FROM"+TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }

    public ArrayList<MemberDTO> findBy(MemberDTO param){
        String sql = "SELECT"+ADDR+","+EMAIL+","+ID+","+NAME+","+PHONE+","+PW +" " + "FROM "+TABLE+" WHERE "+"+ID"+" = '"+param.getId()+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

        if(cursor !=null){
            Log.d("findBy Result :","EXIST!!!");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO();

            temp.setAddr(cursor.getString(0));
            temp.setId(cursor.getString(2));
            temp.setPw(cursor.getString(5));
            temp.setName(cursor.getString(3));
            temp.setEmail(cursor.getString(1));
            temp.setPhone(cursor.getString(4));

        }while(cursor.moveToNext());
        return list;
    }
    public MemberDTO  selectOne(String id){

        // 아래 인스턴스 네개는 생각없이 무조건 나와야ㅠ 순서는 상관 없음
        String sql="SELECT "+String.format("%s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, EMAIL, PHONE,PHOTO, ADDR)+String.format(" FROM %s WHERE %s = '%s';",TABLE,ID,id);
        //1번
        //MemberDTO temp = new MemberDTO();
        //2번
        MemberDTO temp = null;
        //1번, 2번의 차이는? 1번은 주소가 있다.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        // 만약 이프문 안타면 null체크를 히야 하는데 new를 주면 널체크가 안된다
        if(cursor.moveToNext()){// 커서가 다음 값을 보니 있으면..?

            temp = new MemberDTO();

            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));
        }
        return temp;
    }
    public ArrayList<MemberDTO> selectList(){
        String sql ="SELECT "+String.format("%s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, EMAIL, PHONE,PHOTO, ADDR)+" FROM member;";
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor != null){
            Log.d("DAO LIST IS","EXIST");
            cursor.moveToFirst();
        }
        // 첫번째꺼가 인식을 못함(버그? 그래서 두와일)
        do{
            MemberDTO temp = new MemberDTO();
            //컬럼 인덱스는 위에서 %s 순서 준거로 결정
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setPhoto(cursor.getString(5));
            temp.setAddr(cursor.getString(6));
            list.add(temp);

        }while(cursor.moveToNext());

        return list;
    }

    //"+ADDR+","+EMAIL+","+"ID"+","+""NAME"+","+"PHONE"+","+"PW"
    public MemberDTO login(MemberDTO param){
        Log.d("DAO JOIN : ID", param.getId());
        Log.d("DAO JOIN : PW", param.getPw());

        String sql = "SELECT "+ PW+
                " FROM "+ TABLE+" WHERE id ='" + param.getId()+"';";

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
        //et_pwd, et_email, et_phone, et_addr
        // 쿼리문 만들 때 먼저 전체 쿼리문 만들고, '' 안에 "" 넣고 ""안에 ++ 추가
       String sql = "UPDATE "+TABLE+" SET PW ='"+param.getPw()+"',EMAIL='"+param.getEmail()+"',PHONE='"+param.getPhone()+"',PHOTO='"+param.getPhoto()+"',ADDR='"+param.getAddr()+"' WHERE ID='"+param.getId()+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void delete(String id){
        Log.d("삭제할 ID", id);
        String sql = "DELETE FROM"+TABLE +"WHERE ID ="+ id;//스트링도 객체1
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
}
