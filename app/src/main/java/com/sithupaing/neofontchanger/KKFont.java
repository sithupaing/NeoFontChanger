package com.sithupaing.neofontchanger;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sithu on 10/10/2016.
 */
public class KKFont {
    public void installKitKatFont() {
        try {
            DataOutputStream outputStream = new DataOutputStream(Runtime.getRuntime().exec("su").getOutputStream());

                if(new File("/system/fonts/Padauk-book.ttf").exists()) {
                    outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                    outputStream.writeBytes("dd if=/system/fonts/Padauk-book.ttf of=/sdcard/temp/fonts/BackupPadauk-book.ttf"+"\n");
                    outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Padauk-book.ttf"+"\n");
                }
                if(new File("/system/fonts/Padauk-bookbold.ttf").exists()) {
                    outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                    outputStream.writeBytes("dd if=/system/fonts/Padauk-bookbold.ttf of=/sdcard/temp/fonts/BackupPadauk-bookbold.ttf"+"\n");
                    outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Padauk-bookbold.ttf"+"\n");
                }

                if(new File("/system/fonts/Padauk.ttf").exists()) {
                    outputStream.writeBytes("mount -o remount,rw /system"+"\n");
                    outputStream.writeBytes("dd if=/system/fonts/Padauk.ttf of=/sdcard/temp/fonts/BackupPadauk.ttf"+"\n");
                    outputStream.writeBytes("dd if=/sdcard/temp/fonts/SmartZawgyiPro.ttf of=/system/fonts/Padauk.ttf"+"\n");
                }

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

            outputStream.writeBytes("reboot"+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
