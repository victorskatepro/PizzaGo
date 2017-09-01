    package com.victoralejandro.pizzago;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

    public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar1;
        private Timer timer;
        private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar1 = (ProgressBar) findViewById(R.id.progress);
        progressBar1.setProgress(0);
        final long intervalo = 30;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i < 100){
                    progressBar1.setProgress(i);
                    i++;
                }else {
                     timer.cancel();
                    Intent intent = new Intent(SplashActivity.this,PrincipalActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,intervalo);
    }
}
