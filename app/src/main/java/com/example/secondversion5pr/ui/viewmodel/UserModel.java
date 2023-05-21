package com.example.secondversion5pr.ui.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserModel {
    public void createFileAppSpecific(Context context, String fileName, String name, String password) {
        try (FileOutputStream fos = context.openFileOutput(fileName+".txt", Context.MODE_PRIVATE)) {
            fos.write(name.getBytes());
            fos.write(password.getBytes());
            Toast.makeText(context, "Текстовый файл "+ context.getDataDir().getAbsolutePath() + "/" + fileName, Toast.LENGTH_SHORT).show();
            Log.i("Чо случилось", "Текстовый файл "+ context.getDataDir().getAbsolutePath() + "/" + fileName);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createFileExternalStorage(Activity activity, String fileName, String name, String password) {
        Context context = activity.getApplicationContext();
        if (context.getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filePath, fileName);
            FileOutputStream outputStream;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(name.getBytes());
                outputStream.write(password.getBytes());
                Toast.makeText(context, "Текстовый файл" + filePath +"/"+ fileName, Toast.LENGTH_SHORT).show();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    public void createFileSharedPreferences(Context context, String filename, String name, String password){
        SharedPreferences pref = context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", name);
        editor.putString("password", password);
        editor.apply();
        Log.i("file", "File path" + pref + filename);
    }
}
