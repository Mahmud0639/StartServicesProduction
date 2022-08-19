package com.manuni.servicestart3withseparatethreadhandlerforbestuseproductionapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;

public class MyService extends Service {
    private DownloadThread mDownloadThread;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mDownloadThread = new DownloadThread();
        mDownloadThread.start();

        while (mDownloadThread.mHandler == null){
            //here we need to keep main thread in waiting because Download Handler should go first then Main
            //so while loop will make the main thread in waiting for infinity time
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String songName = intent.getStringExtra(MainActivity.MESSAGE_KEY);
        Message msg = Message.obtain();
        msg.obj = songName;
        mDownloadThread.mHandler.sendMessage(msg);
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
      return null;
    }
}