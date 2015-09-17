package com.way.HTTP;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yun on 2015/8/30.
 */
public class HttpUtils {

    //从服务端获取数据
    public static List<HashMap<String, Object>> get_data(String path) {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(path);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                String json_string = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                JSONArray jsonArray = new JSONArray(json_string);
                for (int i = 0; i < 2; i++) {
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    //选择迭代器，输出数据
                    Iterator<String> iterator = jsonObject.keys();
                    while (iterator.hasNext()) {
                        String json_key = iterator.next();
                        Object json_value = jsonObject.get(json_key);
                        if (json_key == null) {
                            json_value = "";
                        }
                        map.put(json_key, json_value);
                    }
                    list.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
