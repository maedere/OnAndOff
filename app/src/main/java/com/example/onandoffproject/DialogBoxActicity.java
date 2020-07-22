package com.example.onandoffproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class DialogBoxActicity extends AppCompatActivity {

    int selected_item;

    RelativeLayout layout;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box_acticity);
        layout=findViewById(R.id.relative_layout);



        AlertDialog alertDialog = new AlertDialog.Builder(DialogBoxActicity.this).create();
        alertDialog.setButton(AlertDialog.BUTTON1, "ON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
               // dialog.dismiss();
               // layout.setBackgroundResource(R.drawable.border);
                //startService(new Intent(getApplicationContext(), ChatHeadService.class));
                finish();
                startService(new Intent(getApplicationContext(), Overlay.class));
                startActivity(new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS));

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OFF",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();

    }
    public void showDialog(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setSingleChoiceItems(new String[]{"ON", "OFF"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selected_item=i;
                        /*if(!isSystemAlertPermissionGranted(DialogBoxActicity.this)){
                            requestSystemAlertPermission(DialogBoxActicity.this,1);
                        }*/

                        startService(new Intent(getApplicationContext(), Overlay.class));



                    }
                });
        builder.show();


    }
    public static void requestSystemAlertPermission(Activity context, int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;
        final String packageName = context == null ? context.getPackageName() : context.getPackageName();
        final Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + packageName));
        if (context != null)
            context.startActivityForResult(intent, requestCode);
        else
            context.startActivityForResult(intent, requestCode);
    }
    @TargetApi(23)
    public static boolean isSystemAlertPermissionGranted(Context context) {
        final boolean result = Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP || Settings.canDrawOverlays(context);
        return result;
    }

}