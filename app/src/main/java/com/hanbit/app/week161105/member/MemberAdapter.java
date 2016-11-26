package com.hanbit.app.week161105.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.app.week161105.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-19.
 */

public  class MemberAdapter extends BaseAdapter{
    ArrayList<MemberDTO> list;//어뎁터: 다른 리스트와 결합해서 사용하기 위해
    LayoutInflater inflater;//픽셀로 되어 있는 것을 화면으로 보여 주는 것.
    private  int[] photos = {
            R.drawable.cupcake
            ,R.drawable.donut
            , R.drawable.eclair
            ,R.drawable.froyo
            ,R.drawable.gingerbread
            ,R.drawable.honeycomb
            ,R.drawable.icecream
            ,R.drawable.kitkat
            ,R.drawable.lollipop
    };

    //외부에서 받는 것들을 생성자에 넣어둔다..
    //                      액티비티에서, 서비스에서 각각 받음
    public MemberAdapter(Context context, ArrayList<MemberDTO> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        //i는 인덱스
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if(v == null){
            v = inflater.inflate(R.layout.member_list, null);
            holder = new ViewHolder();
            holder.ivPhoto  =(ImageView) v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView)v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView)v.findViewById(R.id.tv_phone);
            v.setTag(holder);
        }else{
            holder = (ViewHolder)v.getTag();
        }

        Log.d("Adapter Checked Name:::",list.get(i).getName());
        holder.ivPhoto.setImageResource(photos[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());

        return v;
    }
    //Inner Class
    static class ViewHolder{
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    }
}
