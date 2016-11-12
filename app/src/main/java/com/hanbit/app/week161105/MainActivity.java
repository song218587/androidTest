package com.hanbit.app.week161105;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.app.week161105.calc.CalcActivity;
import com.hanbit.app.week161105.member.JoinActivity;
import com.hanbit.app.week161105.member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_calc = (Button) findViewById(R.id.bt_calc);

        bt_calc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.bt_calc :
                intent = new Intent(this.getApplicationContext(), CalcActivity.class);

                this.startActivity(intent);

                break;

            case R.id.bt_join :
                intent = new Intent(this.getApplicationContext(), JoinActivity.class);

                this.startActivity(intent);
                break;

            case R.id.bt_login :
                intent = new Intent(this.getApplicationContext(), LoginActivity.class);

                this.startActivity(intent);
                break;

        }


    }
}
