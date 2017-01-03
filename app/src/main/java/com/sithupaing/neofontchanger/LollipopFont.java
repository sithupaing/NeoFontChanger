package com.sithupaing.neofontchanger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sithu on 10/12/2016.
 */
public class LollipopFont {
    public void installLollipopFont(){
        try {
            DataOutputStream outputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());
            if(new File("/system/fonts/NotoSansMyanmar-Regular.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/NotoSansMyanmar-Regular.ttf of=/sdcard/temp/fonts/NotoSansMyanmar-Regular.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/NotoSansMyanmar-Regular.ttf"+"\n");
            }
            if(new File("/system/fonts/NotoSansMyanmar-Bold.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/NotoSansMyanmar-Bold.ttf of=/sdcard/temp/fonts/NotoSansMyanmar-Bold.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Roboto-Regular.ttf"+"\n");
            }
            if(new File("/system/fonts/NotoSansMyanmarUI-Regular.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/NotoSansMyanmarUI-Regular.ttf of=/sdcard/temp/fonts/NotoSansMyanmarUI-Regular.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Padauk.ttf"+"\n");
            }
            if(new File("/system/fonts/NotoSansMyanmarUI-Bold.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/NotoSansMyanmarUI-Bold.ttf of=/sdcard/temp/fonts/NotoSansMyanmarUI-Bold.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/NotoSansMyanmarUI-Bold.ttf"+"\n");
            }
            if(new File("/system/fonts/SamsungMyanmar.ttf").exists()) {
                outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                outputStream.writeBytes("dd if=/system/fonts/SamsungMyanmar.ttf of=/sdcard/temp/fonts/SamsungMyanmar.ttf"+"\n");
                outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/SamsungMyanmar.ttf"+"\n");
            }
            outputStream.writeBytes("reboot"+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
