package com.project.tank.outmove.utils;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @description: 网络请求工具类
 * @auther linweijie 
 * @time 2018/10/31 19:19
 */

public class HttpUtil {
    private static final String TAG = "HttpUtil";


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    private static OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)//设置超时时间
            .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(30, TimeUnit.SECONDS)//设置写入超时时间
            .build();


    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        Request request = new Request.Builder()
                .url(address)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 统一post
     * @param url
     * @param params
     * @param callback
     */
    public static void postByForm(String url, HashMap<String,String> params, okhttp3.Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : params.keySet()) {
            //追加表单信息
            builder.add(key, params.get(key));
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * Get获取数据
     */
    public static class GetDataThread extends Thread{
        Handler handler;
        String url;
        int what;

        public GetDataThread(Handler handler, String url, int what) {
            this.handler = handler;
            this.url = url;
            this.what = what;
        }

        @Override
        public void run() {
            super.run();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            mOkHttpClient.newCall(request).enqueue(new Callback() {
                Message message = new Message();
                @Override
                public void onFailure(Call call, IOException e) {
                    message.what = what;
                    message.arg1 = 1;
                    handler.sendMessage(message);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    message.what = what;
                    message.arg1 = 0;
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                }
            });
        }
    }

}
