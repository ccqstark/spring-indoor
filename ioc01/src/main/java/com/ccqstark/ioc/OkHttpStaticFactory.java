package com.ccqstark.ioc;

import okhttp3.OkHttpClient;

// 静态工厂注入
public class OkHttpStaticFactory {

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getInstance(){
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
