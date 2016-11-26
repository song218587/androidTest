package com.hanbit.app.week161105.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.app.week161105.R;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{
    MemberService service;

    TextView tv_name, tv_id;
    EditText et_pwd, et_email, et_phone, et_addr;
    Button bt_confirm, bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        service = new MemberServiceImpl(this.getApplicationContext());

        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_id = (TextView)findViewById(R.id.tv_id);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        et_email = (EditText)findViewById(R.id.et_email);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_addr = (EditText)findViewById(R.id.et_addr);
        bt_confirm = (Button)findViewById(R.id.bt_confirm);
        bt_cancel = (Button)findViewById(R.id.bt_cancel);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_confirm:

                MemberDTO param = new MemberDTO();

                //param.setId(tv_id.getText().toString());
                param.setPw(et_pwd.getText().toString());
               // param.setName(tv_name.getText().toString());
                param.setEmail(et_email.getText().toString());
                param.setPhone(et_phone.getText().toString());
                param.setAddr(et_addr.getText().toString());

                service.update(param);
                break;
            case R.id.bt_cancel:
                break;
        }
    }
}
