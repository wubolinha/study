package com.carboxtech.studymain.tool;

import android.content.Context;
import android.content.res.AssetManager;

import com.carboxtech.studymain.MainApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by admin on 2018/11/28.
 *
 *   读取　ａｓｓｅｔｓ　文件夹相关的工具
 *
 */

public class AssetsTool {



    public static String getText(String fileName,Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }



}
