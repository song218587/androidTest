package com.hanbit.app.week161105.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO {
    //3. MemberServiceImpl에서 생성
    public MemberDAO(Context context) {
    }

    // 서비스에서 복붙. 데이터 베이스를 위해 존재
    public void insert(MemberDTO param){

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
        MemberDTO member = new MemberDTO();
        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
