package com.hanbit.app.week161105.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 1027 on 2016-11-26.
 */

public class Phone {
    // 네이티브앱에서 구현하려면 이렇게 해야한당. 상속이 아니라 직접 액티비티로 연관관계
    private Context context;
    private Activity activity;
    //동작 구현은 상속을 받던지 액티비티를 받던지.
    // 하지만 여기서는 액티비티


    public Phone(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dial(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tell:" + phoneNum));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        context.startActivity(intent);
    }

    public void directCal(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},2);
            return;
        }
        context.startActivity(intent);
    }

}
