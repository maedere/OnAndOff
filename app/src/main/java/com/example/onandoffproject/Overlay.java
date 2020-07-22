package com.example.onandoffproject;

import android.app.ActionBar;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Overlay extends Service {

    private WindowManager windowManager;
    private View topView,buttonView,leftView,rightView;

    Tools t;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       // t = new Tools(this);
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        topView=new View(this);
        topView.setBackgroundColor(Color.parseColor("#00ff00"));
        buttonView=new View(this);
        buttonView.setBackgroundColor(Color.parseColor("#00ff00"));
        leftView=new View(this);
        leftView.setBackgroundColor(Color.parseColor("#00ff00"));
        rightView=new View(this);
        rightView.setBackgroundColor(Color.parseColor("#00ff00"));


        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.height=12;
        params.width=2100;

        params.gravity = Gravity.TOP | Gravity.LEFT;
        windowManager.addView(topView, params);
//----------------------------------------------------------------
        WindowManager.LayoutParams params1 = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params1.height=12;
        params1.width=2100;

        params1.gravity = Gravity.BOTTOM | Gravity.LEFT;
        windowManager.addView(buttonView, params1);
//----------------------------------------------------------------
        WindowManager.LayoutParams params2 = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params2.height=2700;
        params2.width=12;

        params2.gravity =  Gravity.LEFT;
        windowManager.addView(leftView, params2);
//----------------------------------------------------------------
        WindowManager.LayoutParams params3 = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params3.height=2700;
        params3.width=12;

        params3.gravity =  Gravity.RIGHT;
        windowManager.addView(rightView, params3);








    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startid) {

    }

}
