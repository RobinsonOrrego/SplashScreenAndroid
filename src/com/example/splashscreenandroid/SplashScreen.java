package com.example.splashscreenandroid;


import java.util.Timer;
import java.util.TimerTask;
 
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends Activity{

 // Se define la duración del splashScreen
    private static final long SPLASH_SCREEN_DELAY = 10000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        // orientación
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // se oculta el titulo de la App
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        setContentView(R.layout.splashscreen);
 
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
 
                // se inicia la siguiente activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);
 
                
                // Cierra app
                finish();
            }
        };
 
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
