package com.sithupaing.neofontchanger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sithu on 10/10/2016.
 */
public class RestoreFont {
    public RestoreFont(){

    }

    public void restoreOriginal(){
        try {
            DataOutputStream outputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());

            if(new File("/sdcard/temp/fonts/BackupDSF.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/BackupDSF.ttf of=/system/fonts/DroidSansFallback.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/BackupRoboto.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/BackupRoboto.ttf of=/system/fonts/Roboto-Regular.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/BackupPadauk.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/BackupPadauk.ttf of=/system/fonts/Padauk.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/NotoSansMyanmar-Regular.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/NotoSansMyanmar-Regular.ttf of=/system/fonts/NotoSansMyanmar-Regular.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/NotoSansMyanmar-Bold.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/NotoSansMyanmar-Bold.ttf of=/system/fonts/NotoSansMyanmar-Bold.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/NotoSansMyanmarUI-Regular.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/NotoSansMyanmarUI-Regular.ttf of=/system/fonts/NotoSansMyanmarUI-Regular.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/NotoSansMyanmarUI-Bold.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/NotoSansMyanmarUI-Bold.ttf of=/system/fonts/NotoSansMyanmarUI-Bold.ttf"+"\n");

            }
            if(new File("/sdcard/temp/fonts/SamsungMyanmar.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SamsungMyanmar.ttf of=/system/fonts/SamsungMyanmar.ttf"+"\n");

            }
            outputStream.writeBytes("rm /sdcard/temp/fonts/*"+"\n");
            outputStream.writeBytes("reboot"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
