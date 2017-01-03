package com.sithupaing.neofontchanger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sithu on 10/9/2016.
 */
public class ICSFont {
    public ICSFont(){

    }
    public void installICSFont()  {

        try {
            DataOutputStream outputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
            if(new File("/system/fonts/DroidSansFallback.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/DroidSansFallback.ttf of=/sdcard/temp/fonts/BackupDSF.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/DroidSansFallback.ttf of=/system/fonts/DroidSansFallback.ttf"+"\n");
            }
            outputStream.writeBytes("reboot"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
