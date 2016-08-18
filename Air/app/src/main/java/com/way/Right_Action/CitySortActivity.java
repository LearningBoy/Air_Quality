package com.way.Right_Action;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.way.HTTP.HttpUtils;
import com.way.HTTP.URL;
import com.way.Main_Action.R;

public class CitySortActivity extends Activity {

    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_sort);

        lv = (ListView) findViewById(R.id.city_sort_list);

        ImageView back = (ImageView) findViewById(R.id.city_sort_imageView1);
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CitySortActivity.this.finish();
            }
        });

        String path = URL.RANKING_AQI_URL + "?city=beijing&token=" + URL.KEY;
        new MyTask().execute(path);
    }

    /**************************************************************************************************
     * 异步任务加载城市排行
     */
    private class MyTask extends AsyncTask<String,Void,List<HashMap<String,Object>>>{

        private ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(CitySortActivity.this);
            dialog.setMessage("加载中...");
            dialog.show();
        }

        @Override
        protected List<HashMap<String, Object>> doInBackground(String... strings) {
            List<HashMap<String, Object>> list;
            list = HttpUtils.get_data(strings[0]);
            return list;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, Object>> hashMaps) {
            dialog.dismiss();
            Log.i("ERROR","长度:" + hashMaps.size());
            if (hashMaps.size() != 0){
                SimpleAdapter mSimpleAdapter = new SimpleAdapter(CitySortActivity.this, hashMaps,
                        R.layout.city_sort_item,
                        new String[]{"area", "aqi", "level"},
                        new int[]{R.id.item_text_view_1, R.id.item_text_view_2, R.id.item_text_view_3}
                );
                lv.setAdapter(mSimpleAdapter);
            }else{
                Toast.makeText(CitySortActivity.this,"稍后查看..",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
