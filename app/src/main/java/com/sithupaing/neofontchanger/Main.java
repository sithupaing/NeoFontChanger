package com.sithupaing.neofontchanger;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stericson.RootTools.RootTools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Sithu on 10/7/2016.
 */
public class Main extends AppCompatActivity {

    private TextView modelView;
    private TextView versionView;
    private TextView rootView;
    private TextView notiView;
    private Button installButton;
    private ICSFont icsFont;
    private JBFont jbFont;
    private KKFont kkFont;
    private LollipopFont lollipopFont;
    private RestoreFont restoreFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modelView = (TextView)findViewById(R.id.modelView) ;
        versionView = (TextView)findViewById(R.id.versionView) ;
        rootView = (TextView)findViewById(R.id.rootView);
        notiView = (TextView)findViewById(R.id.notiView) ;
        installButton = (Button) findViewById(R.id.intstallButton);

        Typeface tf = Typeface.createFromAsset(Main.this.getAssets(), "SmartZawgyiPro.ttf");
        notiView.setSelected(true);
        notiView.setTypeface(tf);
        installButton.setTypeface(tf);


        icsFont = new ICSFont();
        jbFont = new JBFont();
        kkFont = new KKFont();
        lollipopFont = new LollipopFont();
        restoreFont =  new RestoreFont();

        installButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(RootTools.isRootAvailable()){
                    int sdk = Build.VERSION.SDK_INT;

                    if(sdk<=15){
                        icsFont.installICSFont();
                    }else if(sdk<=18){
                        jbFont.installJBFont();
                    }else if(sdk<=20){
                        kkFont.installKitKatFont();
                    }else if(sdk<=22){
                        lollipopFont.installLollipopFont();
                    }else if(sdk<=23){
                        Toast.makeText(getApplicationContext(),"Do not support for this version.",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Your device does not have root permission.",Toast.LENGTH_LONG).show();
                }



            }
        });

        String deviceModel = Build.MODEL;
        String deviceVersion = Build.VERSION.RELEASE;


        if(RootTools.isRootAvailable()){
            rootView.setText("Root Access : Yes");
        }else{
            rootView.setText("Root Access : No");
        }

        modelView.setText("Model : "+deviceModel);
        versionView.setText("Android version : "+ deviceVersion);

        createFolder();

        try {
            copyDroidSansFallback();
            copySmartZawgyiPro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyDroidSansFallback() throws IOException {

        InputStream inputStream = getApplicationContext().getAssets().open("DroidSansFallback.ttf");
        OutputStream outputStream = new FileOutputStream("/sdcard/temp/fonts/DroidSansFallback.ttf");
        byte[] buffer = new byte[1024];
        while(true){
            int length = inputStream.read(buffer);
            if(length<=0){
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                return;
            }
            outputStream.write(buffer,0,length);
        }
    }
    private void copySmartZawgyiPro() throws IOException {

        InputStream inputStream = getApplicationContext().getAssets().open("SmartZawgyiPro.ttf");
        OutputStream outputStream = new FileOutputStream("/sdcard/temp/fonts/SmartZawgyiPro.ttf");
        byte[] buffer = new byte[1024];
        while(true){
            int length = inputStream.read(buffer);
            if(length<=0){
                outputStream.flush();
                outputStream.close();
                inputStream.close();
                return;
            }
            outputStream.write(buffer,0,length);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Toast.makeText(getApplicationContext(),"About Clicked",Toast.LENGTH_LONG).show();
            return true;
        }else{
            Toast.makeText(getApplicationContext(),"Help Clicked",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


    private void createFolder(){
        if(!new File("/sdcard/").exists()){
            Toast.makeText(getApplicationContext(),"Please insert sdcard..",Toast.LENGTH_LONG).show();
        }
        File tempFolder = new File("/sdcard/temp/fonts/");
        if(!tempFolder.exists()){
            tempFolder.mkdirs();
        }
    }
}
