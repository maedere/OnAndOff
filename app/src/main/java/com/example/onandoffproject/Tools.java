/*
    Written by newreza🍷
    Telegram: @newreza
    ✉ Mail: newreza7@gmail.com
    Version 2.8
    Updates: Fixed bug in method setGlowEffect();
    ***For legal use, don't remove this comment***
*/
package com.example.onandoffproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;




public class Tools {
    public static int w, h, minLength, inch, actionHeight, actionColor, size1, corner, p1, p2, p3;
    public static int color01, color02, color03, color04;
    public static int color05, color06, color07, color08, color09, color10, colorbtnCancle01,
            colorbtnCancle02, colorbtnOk01, colorbtnOk02, colorblue, colorgreen, colorgreen2, colorgreen3,
            colorline,colorc, colormain;
    public static float dimens, widthDimens, heightDimens;
    public static String address,addressshop;
    public static Typeface tf01, tf02, tf03;
    private char[] chpn;
    private Context context;
    private String[] pn;
    private Toast toast;
    private DisplayMetrics dm;
    Resources resources;

    public Tools(Context context) {
        this.context = context;
        pn = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};
        chpn = new char[]{'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};
        dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        w = dm.widthPixels;
        h = dm.heightPixels;
        minLength = w < h ? w : h;
        inch = dm.densityDpi;
        widthDimens = (float) w / inch;
        heightDimens = (float) h / inch;
        dimens = (float) Math.sqrt(Math.pow(widthDimens, 2) + Math.pow(heightDimens, 2));
        size1 = 14;
        corner = inch / 15;
        p1 = w / 30;
        p2 = w / 60;
        p3 = w / 120;
        actionColor = Color.rgb(0,91,127);
        actionHeight = getActionBarSize();
        address = "https://newreza.ir/rafed_shop/customer/";
        addressshop = "https://newreza.ir/rafed_shop/shop/";
        tf01 = Typeface.createFromAsset(context.getAssets(), "fonts/iransans.ttf");
        tf02 = Typeface.createFromAsset(context.getAssets(), "fonts/iransansbold.ttf");
        tf03 = Typeface.createFromAsset(context.getAssets(), "fonts/goodunicorn.ttf");

        resources = context.getResources();
        color01 = Color.rgb(2, 119, 189);
        color02 = Color.WHITE;
        color03 = Color.BLACK;
        color04 = Color.rgb(251, 171, 45);
        colorline = Color.rgb(189, 189, 189);
        colormain = Color.rgb(236, 239, 241);
        color04 = Color.rgb(46, 125, 50);
        color05 = Color.argb(150, 46, 125, 50);
        color06 = Color.rgb(211, 47, 47);
        color07 = Color.argb(150, 211, 47, 47);
        color08 = Color.rgb(50, 50, 50);
        color09 = Color.rgb(100, 100, 100);
        color10 = Color.rgb(0, 121, 106);
        colorbtnOk01 = Color.rgb(56, 196, 97);
        colorbtnOk02 = Color.argb(150, 56, 196, 97);
        colorbtnCancle01 = Color.rgb(236, 58, 54);
        colorbtnCancle02 = Color.argb(150, 236, 58, 54);
        colorgreen = Color.rgb(108, 195, 183);
        colorgreen2 = Color.argb(200,108, 195, 183);
        colorgreen3 = Color.rgb(155, 215, 205);
        colorblue = Color.rgb(150,150,255);

    }

    private int getActionBarSize() {
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        return TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
    }

    public String splitter(String s) {
        if (s.equals("")) {
            return "0";
        }
        String res = "";
        int index = s.length() % 3;
        int part = s.length() / 3;
        if (index > 0) {
            part++;
        } else {
            index = 3;
        }
        for (int j = 0; j < part; j++) {
            res = res + String.valueOf(s.substring(0, index)) + ",";
            s = s.substring(index);
            index = 3;
        }
        return res.substring(0, res.length() - 1);
    }

    public String splitter(int i) {
        return splitter(String.valueOf(i));
    }

    public String splitter(long l) {
        return splitter(String.valueOf(l));
    }

    public String english(String s) {
        String res = "";
        int count = s.length();
        for (int i = 0; i < count; i++) {
            if (s.charAt(i) != ',') {
                int j = 0;
                for (; j < 10; j++) {
                    if (s.charAt(i) == chpn[j]) {
                        res += String.valueOf(j);
                        break;
                    }
                }
                if (j == 10) {
                    res += String.valueOf(s.charAt(i));
                }
            }
        }
        return res;
    }

    public String persian(int i) {
        int archive = i;
        String s = "";
        do {
            s = pn[Math.abs(i % 10)] + s;
            i = i / 10;
        } while (i != 0);
        if (archive < 0) {
            s = "-" + s;
        }
        return s;
    }

    public String persian(float f) {
        String stemp = String.valueOf(f);
        int integer = (int) f;
        int decimal = Integer.valueOf(stemp.substring(stemp.indexOf('.') + 1));
        return persian(integer) + "/" + persian(decimal);
    }

    public String persian(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                res += pn[s.charAt(i) - 48];
            } else {
                res += String.valueOf(s.charAt(i));
            }
        }
        return res;
    }

    public String persian(long l) {
        long archive = l;
        String res = "";
        do {
            res = pn[(int) Math.abs(l % 10)] + res;
            l = l / 10;
        } while (l != 0);
        if (archive < 0) {
            res = "-" + res;
        }
        return res;
    }

    public String persianSplitter(String s) {
        if (s.equals("")) {
            return "۰";
        }
        String res = "";
        int index = s.length() % 3;
        int part = s.length() / 3;
        if (index > 0) {
            part++;
        } else {
            index = 3;
        }
        for (int j = 0; j < part; j++) {
            res = res + persian(s.substring(0, index)) + ",";
            s = s.substring(index);
            index = 3;
        }
        return res.substring(0, res.length() - 1);
    }

    public String persianSplitter(int i) {
        return persianSplitter(String.valueOf(i));
    }

    public String persianSplitter(long l) {
        return persianSplitter(String.valueOf(l));
    }

    public boolean isNumeric(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    public String elapsedTime(long l) {
        long timediff = (System.currentTimeMillis() - l) / 1000;
        if (timediff < 60) {
            return persian(timediff) + " ثانیه پیش";
        }
        if (timediff < 3600) {
            return persian(timediff / 60) + " دقیقه پیش";
        }
        if (timediff < 86400) {
            return persian(timediff / 3600) + " ساعت پیش";
        }
        if (timediff < 604800) {
            return persian(timediff / 86400) + " روز پیش";
        }
        if (timediff < 2592000) {
            return persian(timediff / 604800) + " هفته پیش";
        }
        if (timediff < 31558150) {
            return persian(timediff / 2592000) + " ماه پیش";
        }
        return persian(timediff / 31558150) + " سال پیش";
    }

    public void setImageCorner(ImageView iv, int resource, int radius) {
        setImageCorner(iv, BitmapFactory.decodeResource(context.getResources(), resource), radius,false);
    }

    public void setImageCorner(final ImageView iv, final Bitmap bitmap, final int radius, boolean background) {
        iv.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        Bitmap bm = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int minBitmap = Math.min(bm.getWidth(), bm.getHeight());
        int minIv = Math.min(iv.getWidth(), iv.getHeight());
        int r = minBitmap / (minIv / radius);
        Canvas canvas = new Canvas(bm);
        Paint pclear = new Paint();
        pclear.setColor(Color.RED);
        pclear.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        pclear.setAntiAlias(true);
        pclear.setStrokeWidth(1);
        double r2 = Math.pow(r, 2);
        for (int i = 0; i < r; i++) {
            float temp = (float) (r - Math.sqrt(r2 - Math.pow(r - i, 2)));
            for (int j = 0; j < 4; j++) {
                canvas.drawLine(0, i, temp, i, pclear);
                canvas.drawLine(bm.getWidth(), i, bm.getWidth() - temp, i, pclear);
                canvas.drawLine(0, bm.getHeight() - i, temp, bm.getHeight() - i, pclear);
                canvas.drawLine(bm.getWidth(), bm.getHeight() - i, bm.getWidth() - temp, bm.getHeight() - i, pclear);
            }
        }
        if(background){
            iv.setBackground(new BitmapDrawable(bitmap));
        }
        else {
            iv.setImageBitmap(bm);
        }
    }

    public ArrayList<ArrayList<String>> cursor2list(Cursor cursor){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int count = cursor.getCount();
        int columnCount = cursor.getColumnCount();
        cursor.moveToFirst();
        ArrayList<String> temp;
        for(int i = 0; i < count; i++){
            temp = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                temp.add(cursor.getString(j));
            }
            res.add(temp);
            cursor.moveToNext();
        }
        return res;
    }
	
	public ArrayList<String> splitDecoder1D(String s, char ch) {
        ArrayList<String> res = new ArrayList<>();
        int length = s.length();
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ch) {
                res.add(s.substring(p, i));
                p = i + 1;
            }
        }
        return res;
    }

    public ArrayList<ArrayList<String>> splitDecoder2D(String s, char ch1, char ch2) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int length = s.length();
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ch2) {
                temp.add(s.substring(p, i));
                p = i + 1;
            } else if (s.charAt(i) == ch1) {
                temp.add(s.substring(p, i));
                p = i + 1;
                res.add(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }

    public ArrayList<String> array2list(String[]  array) {
        int length = array.length;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            res.add(array[i]);
        }
        return res;
    }

    public ArrayList<ArrayList<String>> array2list(String[][] array) {
        int length1 = array.length;
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> temp;
        for (int i = 0; i < length1; i++) {
            int length2 = array[i].length;
            temp = new ArrayList<>();
            for (int j = 0; j < length2; j++) {
                temp.add(array[i][j]);
            }
            res.add(temp);
        }
        return res;
    }



    public void setLocale(String s) {
        Configuration config = new Configuration();
        config.locale = new Locale(s);
        ((Activity) context).getBaseContext().getResources().updateConfiguration(config, dm);
    }

    public void setColor(View v, int c1, int c2) {
        StateListDrawable sld1 = new StateListDrawable();
        sld1.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(c2));
        sld1.addState(new int[]{}, new ColorDrawable(c1));
        v.setBackground(sld1);
    }

    public void setGradient(View v, GradientDrawable gd1, GradientDrawable gd2) {
        StateListDrawable sld1 = new StateListDrawable();
        sld1.addState(new int[]{android.R.attr.state_pressed}, gd2);
        sld1.addState(new int[]{}, gd1);
        v.setBackground(sld1);
    }

    public void setGradient(View v, int color1, int color2, int corner) {
        GradientDrawable gd1 = new GradientDrawable();
        gd1.setColor(color1);
        gd1.setCornerRadius(corner);
        GradientDrawable gd2 = new GradientDrawable();
        gd2.setColor(color2);
        gd2.setCornerRadius(corner);
        setGradient(v, gd1, gd2);
    }

    public void setGradient(View v, int color1, int color2) {
        setGradient(v, color1, color2, corner);
    }

    public Bitmap getColored(int res, int color) {
        return getColored(BitmapFactory.decodeResource(resources, res), color);
    }

    public Bitmap getColored(Bitmap bitmap, int color) {
        bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        int dimen = width * height;
        for (int i = 0; i < dimen; i++) {
            pixels[i] = Color.argb(Color.alpha(pixels[i]), red, green, blue);
        }
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public void setGradient(View v) {
        setGradient(v, color01, color02);
    }

    public void setGlowEffect(final View view, final int length, final int[] colors, boolean sizeIsSpecified) {
        setGlowEffectPrivate(view, length, colors);
    }

    public void setGlowEffect(final View view, final int length, final int[] colors) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                setGlowEffectPrivate(view, length, colors);
            }
        });
    }

    private void setGlowEffectPrivate(View view, int length, int[] colors) {
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();

        int w = width + 2 * length;
        int h = height + 2 * length;
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        LinearGradient linearGradient = new LinearGradient(w / 2, h / 2, w / 2, 0, colors, null, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setShader(linearGradient);
        canvas.drawRect(h / 2, 0, w - h / 2, h / 2, paint);

        linearGradient = new LinearGradient(w / 2, h / 2, w / 2, h, colors, null, Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.drawRect(h / 2, h / 2, w - h / 2, h, paint);

        RadialGradient radialGradient = new RadialGradient(h / 2, h / 2, h / 2, colors, null, Shader.TileMode.CLAMP);
        paint.setShader(radialGradient);
        Path path = new Path();
        path.moveTo(h / 2, 0);
        path.quadTo(0, 0, 0, h / 2);
        path.quadTo(0, h, h / 2, h);
        canvas.drawPath(path, paint);

        radialGradient = new RadialGradient(w - h / 2, h / 2, h / 2, colors, null, Shader.TileMode.CLAMP);
        paint.setShader(radialGradient);
        path = new Path();
        path.moveTo(w - h / 2, 0);
        path.quadTo(w, 0, w, h / 2);
        path.quadTo(w, h, w - h / 2, h);
        canvas.drawPath(path, paint);

        LinearLayout ll = new LinearLayout(context);
        if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams viewP = (RelativeLayout.LayoutParams)view.getLayoutParams();
            RelativeLayout.LayoutParams llP = new RelativeLayout.LayoutParams(w, h);
            llP.setMargins(viewP.leftMargin - length, viewP.topMargin - length, viewP.rightMargin - length, viewP.bottomMargin - length);
            int[] rules = viewP.getRules();
            for (int i = 0; i < rules.length; i++) {
                if (rules[i] != 0) {
                    llP.addRule(i, rules[i]);
                }
            }
            ll.setLayoutParams(llP);
            LinearLayout.LayoutParams viewP2 = new LinearLayout.LayoutParams(viewP.width, viewP.height);
            viewP2.setMargins(length, length, length, length);
            view.setLayoutParams(viewP2);
        } else {
            LinearLayout.LayoutParams viewP = (LinearLayout.LayoutParams) view.getLayoutParams();
            LinearLayout.LayoutParams llP = new LinearLayout.LayoutParams(w, h);
            llP.setMargins(viewP.leftMargin - length, viewP.topMargin - length, viewP.rightMargin - length, viewP.bottomMargin - length);
            ll.setLayoutParams(llP);
            viewP.setMargins(length, length, length, length);
            view.setLayoutParams(viewP);
        }
        ll.setGravity(Gravity.CENTER);
        ll.setBackground(new BitmapDrawable(context.getResources(), bitmap));

        ViewGroup parent = (ViewGroup)view.getParent();
        int index = parent.indexOfChild(view);
        parent.removeView(view);
        ll.addView(view);
        parent.addView(ll, index);
    }

    public void removeGlowEffect(View view) {
        LinearLayout parent = (LinearLayout) view.getParent();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (parent.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams parentParams = (RelativeLayout.LayoutParams) parent.getLayoutParams();
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(params.width, params.height);
            params2.setMargins(parentParams.leftMargin + params.leftMargin, parentParams.topMargin + params.topMargin,
                    parentParams.rightMargin + params.rightMargin, parentParams.bottomMargin + params.bottomMargin);
            int[] rules = parentParams.getRules();
            for (int i = 0; i < rules.length; i++) {
                params2.addRule(rules[i]);
            }
            view.setLayoutParams(params2);
        } else {
            LinearLayout.LayoutParams parentParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
            params.setMargins(parentParams.leftMargin + params.leftMargin, parentParams.topMargin + params.topMargin,
                    parentParams.rightMargin + params.rightMargin, parentParams.bottomMargin + params.bottomMargin);
            view.setLayoutParams(params);
        }
        ViewGroup originalParent = (ViewGroup)parent.getParent();
        int index = originalParent.indexOfChild(parent);
        parent.removeView(view);
        originalParent.removeView(parent);
        originalParent.addView(view, index);
    }

    public String getDeviceId() {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public void toast(String s) {
        try {
            toast.cancel();
        } catch (Exception e) {
        }
        toast = Toast.makeText(context, s, Toast.LENGTH_LONG);
        toast.show();
    }

    public void toast(int i) {
        try {
            toast.cancel();
        } catch (Exception e) {
        }
        toast = Toast.makeText(context, i, Toast.LENGTH_LONG);
        toast.show();
    }

    public int getVersionCode() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getVersionName() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void installAPK(String path) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setData(FileProvider.getUriForFile(context.getApplicationContext(), BuildConfig.APPLICATION_ID + ".fileprovider", new File(path)));
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void setOrientation(int i) {
        try {
            ((Activity) context).setRequestedOrientation(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning(Class c) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo rsi : am.getRunningServices(Integer.MAX_VALUE)) {
            if (c.getName().equals(rsi.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public JSONArray arrayList2jsonArray(ArrayList<JSONObject> arrayList) {
        int size = arrayList.size();
        JSONArray res = new JSONArray();
        for (int i = 0; i < size; i++) {
            res.put(arrayList.get(i));
        }
        return res;
    }

    public ArrayList<JSONObject> jsonArray2arrayList(JSONArray jsonArray) {
        int length = jsonArray.length();
        ArrayList<JSONObject> res = new ArrayList<>();
        try {
            for (int i = 0; i < length; i++) {
                res.add(jsonArray.getJSONObject(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static void showNotification(Context context, String title, String text, int logoRes, Class c, JSONObject data) {
        String channelId = context.getPackageName();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(context, c);
        intent.putExtra("data", data.toString());
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(c);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(logoRes)
                .setContentTitle(title)
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelDescription = "New Message!";
            int channelImportance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(channelId, title, channelImportance);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.enableVibration(true);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
        } else {
            notificationBuilder.setVibrate(new long[] {0, 250, 250, 250});
            notificationBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        }
        assert notificationManager != null;
        notificationManager.notify(1, notificationBuilder.build());
    }

    public int pxToDp(int px){
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                px,
                r.getDisplayMetrics()
        );
    }

}