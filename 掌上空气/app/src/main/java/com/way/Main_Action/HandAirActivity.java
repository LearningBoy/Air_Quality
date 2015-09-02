package com.way.Main_Action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.way.HTTP.HttpUtils;
import com.way.HTTP.URL;
import com.way.Main_Slide.HomeCenterLayout;

public class HandAirActivity extends Activity implements OnClickListener {

    //主页面
    private HomeCenterLayout centerLayout;

    //当前城市
    private TextView text_city;

    //空气状态，优、良、轻度污染、中度污染、重度污染、严重污染
    private TextView text_center;

    //PM2.5值
    private TextView text_PM_2_5;

    //AQI值
    private TextView text_AQI;

    //主要污染物
    private TextView text_primary_pollution;

    //右侧边栏布局
    private ListView list_right;

    //显示右边栏按钮
    private ImageButton rightBtn;

    //显示左边栏按钮
    private LinearLayout leftBtn;

    //右侧边栏选项
    private String[] right_str = {"界面截图", "城市排行", "皮肤设置", "通用排行", "提醒设置", "关于我们", "版本号：V.01"};

    //截图结束时间
    private long exitTime;

    /************************************************************************************************************
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();
        setListener();
    }

    /************************************************************************************************************
     * 初始化视图
     */
    public void initView() {

        LinearLayout leftLayout = (LinearLayout) findViewById(R.id.homeLeft);
        LinearLayout rightLayout = (LinearLayout) findViewById(R.id.homeRight);
        centerLayout = (HomeCenterLayout) findViewById(R.id.homeCenter);

        leftLayout.setVisibility(View.GONE);
        rightLayout.setVisibility(View.GONE);
        centerLayout.setBrotherLayout(leftLayout, rightLayout);

        leftBtn = (LinearLayout) findViewById(R.id.ivTitltBtnLeft);
        rightBtn = (ImageButton) findViewById(R.id.ivTitleBtnRigh);

        text_city = (TextView) findViewById(R.id.main_text_city);
        text_center = (TextView) findViewById(R.id.main_text_center);
        text_PM_2_5 = (TextView) findViewById(R.id.main_text_PM_2_5);
        text_AQI = (TextView) findViewById(R.id.main_text_AQI);
        text_primary_pollution = (TextView) findViewById(R.id.main_text_primary_pollution);

        String path = URL.PM_2_5_URL + "?city=beijing&token=" + URL.KEY;
        new MyTask().execute(path);

        //加载右侧栏选项
        list_right = (ListView) findViewById(R.id.list_right);
        ArrayList<HashMap<String, Object>> list_item_right = new ArrayList<HashMap<String, Object>>();
        for (String str : right_str) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", str);
            list_item_right.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list_item_right, R.layout.item_right, new String[]{"name"}, new int[]{R.id.item_right_text});
        list_right.setAdapter(adapter);

    }

    /************************************************************************************************************
     * 按钮触发
     */
    public void setListener() {
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);
    }

    /************************************************************************************************************
     * 按钮触发
     */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivTitltBtnLeft:
                if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
                    centerLayout.setPage(HomeCenterLayout.LEFT);
                else
                    centerLayout.setPage(HomeCenterLayout.MIDDLE);
                break;
            case R.id.ivTitleBtnRigh:
                if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
                    centerLayout.setPage(HomeCenterLayout.RIGHT);
                else
                    centerLayout.setPage(HomeCenterLayout.MIDDLE);
                break;
        }

    }

    /************************************************************************************************************
     * 获取主界面截图
     */
    private void Shoot_Image() {
        View draw_view = this.getWindow().getDecorView();
        draw_view.setDrawingCacheEnabled(true);
        Bitmap bitmap = draw_view.getDrawingCache();
        String SavePath = getSDCardPath() + "/ScreenImage";
        try {
            File path = new File(SavePath);
            String filepath = SavePath + "/Screen_1.png";
            File file = new File(filepath);
            if (!path.exists()) {
                path.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos;
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(this, "截图成功", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /************************************************************************************************************
     * 获得本地SD卡路径
     */
    private String getSDCardPath() {
        File sdcardDir = null;
        boolean sdcardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        if (sdcardExist) {
            sdcardDir = Environment.getExternalStorageDirectory();
        }
        return sdcardDir.toString();
    }

    /************************************************************************************************************
     * 双击返回键退出主页面
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.press_again_exit), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 50);
                toast.show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /************************************************************************************************************
     * 异步任务加载网路数据
     */
    public class MyTask extends AsyncTask<String, Void, List<HashMap<String, Object>>> {

        @Override
        protected List<HashMap<String, Object>> doInBackground(String... strings) {
            List<HashMap<String, Object>> list;
            list = HttpUtils.get_city_all_PM_2_5(strings[0]);
            return list;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, Object>> hashMaps) {
            text_city.setText(hashMaps.get(0).get("area").toString());
            text_center.setText(hashMaps.get(0).get("quality").toString());
            text_PM_2_5.setText(hashMaps.get(0).get("pm2_5").toString());
            text_AQI.setText(hashMaps.get(0).get("aqi").toString());
            text_primary_pollution.setText(hashMaps.get(0).get("primary_pollutant").toString());
            super.onPostExecute(hashMaps);
        }
    }
}