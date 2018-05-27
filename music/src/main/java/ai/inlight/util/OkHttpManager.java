package ai.inlight.util;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class OkHttpManager{
    private OkHttpClient okClient =new OkHttpClient();
    static MediaType MEDIA_TYPE_URLENCODED = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    static MediaType MEDIA_TYPE_JSON = MediaType.parse("text/x-markdown; charset=utf-8");
    static OkHttpManager instance;

    static {
        try {
            instance = new OkHttpHolder().instance;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OkHttpManager() throws IOException {
        okClient.setConnectTimeout(10,TimeUnit.SECONDS);
        okClient.setReadTimeout(10,TimeUnit.SECONDS);
        okClient.setWriteTimeout(10,TimeUnit.SECONDS);
    }

    //静态内部类
    private static class OkHttpHolder{
        OkHttpManager instance = new OkHttpManager();

        private OkHttpHolder() throws IOException {
        }
    }


    /**
     * 同步get封装
     */
    public String requestGetSyn(String baseUrl, String actionUrl,HashMap<String, String> paramsMap) throws IOException {
        StringBuilder builder =new StringBuilder();
        int sign = 0;
        appendSign(paramsMap, builder, sign);
        //完全的请求地址
        String requestUrl = String.format("%s/%s?%s",baseUrl,actionUrl,builder.toString());
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();
        Response response = okClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 同步post封装
     */
    public String requestPostSyn(String baseUrl,String actionUrl,HashMap<String, String> paramsMap) throws IOException {
        StringBuilder builder =new StringBuilder();
        int sign = 0;
        appendSign(paramsMap, builder, sign);
        //完全的请求地址
        String requestUrl = String.format("%s/%s",baseUrl,actionUrl);
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_URLENCODED, builder.toString());
        Request request =new Request.Builder()
                .url(requestUrl)
                .post(requestBody)
                .build();
        Response response = okClient.newCall(request).execute();
        String result = "出错啦！";
        if (response.isSuccessful()) result = response.body().string();
        return result;
    }

    private void appendSign(HashMap<String, String> paramsMap, StringBuilder builder, int sign) throws UnsupportedEncodingException {
        for (HashMap.Entry<String,String> map: paramsMap.entrySet()){
            if (sign > 0) builder.append("&");
            builder.append(String.format("%s=%s", String.valueOf(map.getKey()), URLEncoder.encode(String.valueOf(map.getValue()), "utf-8")));
            sign++;
        }
    }

}