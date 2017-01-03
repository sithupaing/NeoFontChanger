package com.sithupaing.neofontchanger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sithu on 10/10/2016.
 */
public class JBFont {
    public JBFont(){

    }
    public void installJBFont(){

        try {
            DataOutputStream outputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
            if(new File("/system/fonts/DroidSansFallback.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/DroidSansFallback.ttf of=/sdcard/temp/fonts/BackupDSF.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/DroidSansFallback.ttf"+"\n");
            }
            if(new File("/system/fonts/Roboto-Regular.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/Roboto-Regular.ttf of=/sdcard/temp/fonts/BackupRoboto.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Roboto-Regular.ttf"+"\n");
            }
            if(new File("/system/fonts/Padauk.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/Padauk.ttf of=/sdcard/temp/fonts/BackupPadauk.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Padauk.ttf"+"\n");
            }
            outputStream.writeBytes("reboot"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
