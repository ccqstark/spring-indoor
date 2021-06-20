package com.ccqstark.ioc;

import okhttp3.OkHttpClient;

// 实例工厂注入
public class OkHttpFactory {

    private  OkHttpClient okHttpClient;

    public  OkHttpClient getInstance(){
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }

}
