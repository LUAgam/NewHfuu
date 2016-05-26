package Util;

import android.os.Looper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dao.HttpCallbackListener;

/**
 * Created by woshi on 2016/5/23.
 */

public class HttpUtil {


    public static void sendHttpRequest(final String uri,final HttpCallbackListener listener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection httpURLConnection = null;
                try{
                    URL url =new URL(uri);
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    InputStream in = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(in));
                    StringBuilder response  = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine())!= null){
                        response.append(line);
                    }
                    if(listener !=null){
                        //回掉onFinish()方法
                        listener.onFinish(response.toString());
                     }
                }catch (Exception e){
                    if(listener != null){
                        e.printStackTrace();
                       listener.onError(e);
                    }

                }finally {
                    if(httpURLConnection != null){
                        httpURLConnection.disconnect();
                    }
                }
                Looper.prepare();
            }
        }).start();
    }
}
