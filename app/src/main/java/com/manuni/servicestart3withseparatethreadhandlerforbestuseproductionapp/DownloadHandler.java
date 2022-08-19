package com.manuni.servicestart3withseparatethreadhandlerforbestuseproductionapp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class DownloadHandler extends Handler {
    private static final String TAG = "MyTag";
    public DownloadHandler(){

    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        DownloadSong(msg.obj.toString());
    }
    public void DownloadSong(String songName){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "DownloadSong: "+songName+" has been downloaded.");
    }
}
