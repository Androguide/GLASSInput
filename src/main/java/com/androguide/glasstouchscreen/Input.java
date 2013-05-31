package com.androguide.glasstouchscreen;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by androguide on 5/31/13.
 */
public class Input extends InputMethodService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.v("GLASS Input", "VOL UP DETECTED - SWIPING LEFT...");
                keyDownUp(KeyEvent.KEYCODE_DPAD_LEFT);
                return true;

            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.v("GLASS Input", "VOL DOWN DETECTED - SWIPING RIGHT...");
                keyDownUp(KeyEvent.KEYCODE_DPAD_RIGHT);
                return true;

            case KeyEvent.KEYCODE_BACK:
                if (event.isLongPress()) {
                    //Vibrate to notify the user the long-press is done
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    v.vibrate(300);
                    Log.v("GLASS Input", "LONG BACK PRESS DETECTED - DISPATCHING ENTER...");
                    keyDownUp(KeyEvent.KEYCODE_ENTER);
                } else {
                    Log.v("GLASS Input", "BACK PRESS DETECTED - USING ACTUAL BACK BUTTON...");
                    keyDownUp(KeyEvent.KEYCODE_BACK);
                }
                return true;

            case KeyEvent.KEYCODE_MENU:
                keyDownUp(KeyEvent.KEYCODE_ENTER);
                return true;

            default:
                Log.v("KeyCode", "" + keyCode);
                return super.onKeyDown(keyCode, event);

        }

    }

    private void keyDownUp(int keyEventCode) {
        getCurrentInputConnection().sendKeyEvent(
                new KeyEvent(KeyEvent.ACTION_DOWN, keyEventCode));
        getCurrentInputConnection().sendKeyEvent(
                new KeyEvent(KeyEvent.ACTION_UP, keyEventCode));
    }

}