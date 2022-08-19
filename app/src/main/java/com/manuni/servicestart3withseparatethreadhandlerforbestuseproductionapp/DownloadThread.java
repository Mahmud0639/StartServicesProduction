package com.manuni.servicestart3withseparatethreadhandlerforbestuseproductionapp;

import android.os.Looper;

public class DownloadThread extends Thread{
    DownloadHandler mHandler;

    public DownloadThread(){

    }
    @Override
    public void run() {
        super.run();
        Looper.prepare(); // it will create message queue
        mHandler = new DownloadHandler();
        Looper.loop();
    }
}
