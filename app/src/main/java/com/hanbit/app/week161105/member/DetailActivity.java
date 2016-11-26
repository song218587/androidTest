package com.hanbit.app.week161105.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.app.week161105.R;
import com.hanbit.app.week161105.util.MapsActivity;
import com.hanbit.app.week161105.util.Phone;
import com.hanbit.app.week161105.util.WebActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    MemberDTO member;
    ImageView iv_photo;
    TextView tv_name, tv_id, tv_pwd, tv_email, tv_phone, tv_addr;
    Button bt_call, bt_massage, bt_movie, bt_update, bt_list, bt_map;
    String id ="";
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());

        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tv_name = (TextView) findViewById(R.id.tv_name);

        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pwd = (TextView) findViewById(R.id.tv_pwd);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        //list액티비티에서 id라서 ..
        id = this.getIntent().getExtras().getString("id");
        member = service.detail(id);

        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_email.setText(member.getEmail());
            tv_addr.setText(member.getAddr());
            tv_pwd.setText(member.getPw());
            tv_phone.setText(member.getPhone());
            //iv_photo

        }else{
            Log.d("아이디가 존재","하지않음");
        }

        bt_call = (Button) findViewById(R.id.bt_call);
        bt_massage = (Button) findViewById(R.id.bt_massage);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);
        bt_map = (Button) findViewById(R.id.bt_map);

        bt_call.setOnClickListener(this);
        bt_massage.setOnClickListener(this);
        bt_movie.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);
        bt_map.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_call:
                Log.d("전화번호 클릭:","OK");
                phone = new Phone(this, this);
                phone.directCal(member.getPhone());
                break;
            case R.id.bt_massage:
                break;
            case R.id.bt_movie:
                intent = new Intent(DetailActivity.this, WebActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_map:
                Log.d("구글맵 클릭:","OK");
                intent = new Intent(DetailActivity.this, MapsActivity.class);
                //37.5665350,126.9779690
                String pos = member.getAddr();
                pos ="37.5665350,126.9779690";
                intent.putExtra("pos",pos);
                startActivity(intent);
                break;
            case R.id.bt_update:
                intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
                break;
            case R.id.bt_list:
                break;


        }
    }
}