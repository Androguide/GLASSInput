package com.androguide.glasstouchscreen;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.input_settings);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName com = new ComponentName("com.android.settings", "com.android.settings.LanguageSettings");
                Intent intent = new Intent().setAction(Intent.ACTION_MAIN).setComponent(com);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            Log.v("TOUCH", "TAP DETECTED!");

        }
        return super.onTouchEvent(event);
    }

}
