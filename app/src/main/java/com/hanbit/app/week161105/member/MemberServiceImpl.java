package com.hanbit.app.week161105.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao;
    //2. DAO생성해서 Context 넘겨준다.
    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public void join(MemberDTO param) {
        Log.d("JOIN : ID", param.getId());
        Log.d("JOIN : PW", param.getPw());
        Log.d("JOIN : NAME", param.getName());
        Log.d("JOIN : Email", param.getEmail());
        Log.d("JOIN : Phone", param.getPhone());
        Log.d("JOIN : Addr", param.getAddr());

        dao.insert(param);
    }

    @Override
    public int count() {
        int count = 0;
        return count;
    }

    @Override
    public MemberDTO detail(String id) {
        MemberDTO member = new MemberDTO();
        return member;
    }

    @Override
    public ArrayList<MemberDTO> list() {
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }

    @Override
    public boolean login(MemberDTO param) {

        boolean flag = false;

        //return (param.getPw().equals(dao.login(param).getPw()))?true:false;
        return (param.getPw().equals(dao.login(param).getPw()));



    }

    @Override
    public void update(MemberDTO param) {

    }

    @Override
    public void delete(MemberDTO param) {

    }
// 2) 서비스에 있는 것 구현: alt+insert 자동
}
