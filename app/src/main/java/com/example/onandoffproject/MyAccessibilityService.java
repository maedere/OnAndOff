package com.example.onandoffproject;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MyAccessibilityService extends AccessibilityService {


    @Override
    public void onInterrupt() {
    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
       // Toast.makeText(this,"here",Toast.LENGTH_SHORT).show();
        switch(accessibilityEvent.getEventType()) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                try {
                    Class className = Class.forName(accessibilityEvent.getClassName().toString());

                    if (EditText.class.isAssignableFrom(className)) {
                        // An EditText was Clicked or Focused
                        // Use other methods from the accessibilityEvent to do what
                        // you need to do

                        AccessibilityNodeInfo nodeInfo = accessibilityEvent.getSource()==null ? null : accessibilityEvent.getSource();

                        Toast.makeText(this,nodeInfo.getText(),Toast.LENGTH_SHORT).show();



                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }



}
