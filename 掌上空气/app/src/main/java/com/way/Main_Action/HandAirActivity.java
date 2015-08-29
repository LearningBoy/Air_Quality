package com.way.Main_Action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.way.Left_Action.CityChooseActivity;
import com.way.Main_Slide.HomeCenterLayout;
import com.way.Right_Action.AboutUsActivity;
import com.way.Right_Action.CitySortActivity;
import com.way.Right_Action.MentionSettingsActivity;
import com.way.Right_Action.SettingsActivity;
import com.way.Right_Action.SkinActivity;

public class HandAirActivity extends Activity implements OnClickListener {

    private HomeCenterLayout centerLayout;

    private ListView list_right;

    private String[] right_str = {"界面截图","城市排行","皮肤设置","通用排行","提醒设置","关于我们","版本号：V.01"};

    private long exitTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    /************************************************************************************************************
     * 初始化视图
     */
    public  void  initView(){

        LinearLayout leftLayout = (LinearLayout) findViewById(R.id.homeLeft);
        LinearLayout rightLayout = (LinearLayout) findViewById(R.id.homeRight);
        centerLayout = (HomeCenterLayout) findViewById(R.id.homeCenter);

        leftLayout.setVisibility(View.GONE);
        rightLayout.setVisibility(View.GONE);
        centerLayout.setBrotherLayout(leftLayout, rightLayout);

        LinearLayout leftBtn = (LinearLayout) findViewById(R.id.ivTitltBtnLeft);
        ImageButton rightBtn = (ImageButton) findViewById(R.id.ivTitleBtnRigh);

        list_right = (ListView) findViewById(R.id.list_right);
        ArrayList<HashMap<String,Object>> list_item_right = new ArrayList<HashMap<String, Object>>();
        for (int i = 0;i<right_str.length;i++){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("name",right_str[i]);
            list_item_right.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,list_item_right,R.layout.left_item,new String[]{"name"},new int[]{R.id.left_text_first});
        list_right.setAdapter(adapter);

        leftBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
                    centerLayout.setPage(HomeCenterLayout.LEFT);
                else
                    centerLayout.setPage(HomeCenterLayout.MIDDLE);
            }
        });

        rightBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (centerLayout.getPage() == HomeCenterLayout.MIDDLE)
                    centerLayout.setPage(HomeCenterLayout.RIGHT);
                else
                    centerLayout.setPage(HomeCenterLayout.MIDDLE);
            }
        });

    }

    /************************************************************************************************************
     * 按钮触发
     */
    public void onClick(View v) {
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
}