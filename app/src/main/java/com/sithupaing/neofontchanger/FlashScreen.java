package com.sithupaing.neofontchanger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FlashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(FlashScreen.this,Main.class);
                    startActivity(intent);
                }
            }
        });

        thread.start();
    }
}
