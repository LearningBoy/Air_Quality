package com.way.Right_Action;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.way.Main_Action.R;

import org.w3c.dom.Text;

public class SettingsActivity extends Activity implements OnClickListener {

    private ImageView Go_back;

    private TextView data_update;

    private CheckBox show_in_bar;

    private CheckBox desk_icon;

    private TextView check_update;

    private TextView advice_submit;

    private TextView using_help;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        initview();

        setListener();

    }

    public void initview() {

        //返回按钮
        Go_back = (ImageView) findViewById(R.id.settings_imageView1);

        //数据更新
        data_update = (TextView) findViewById(R.id.settings_data_update);

        //通知栏显示
        show_in_bar = (CheckBox) findViewById(R.id.settings_show_in_bar);

        //桌面图标
        desk_icon = (CheckBox) findViewById(R.id.settings_desk_icon);

        //检查更新
        check_update = (TextView) findViewById(R.id.settings_check_update);

        //意见反馈
        advice_submit = (TextView) findViewById(R.id.settings_advice_submit);

        //使用帮助
        using_help = (TextView) findViewById(R.id.settings_using_help);
    }

    public void setListener() {

        Go_back.setOnClickListener(this);

        data_update.setOnClickListener(this);

        show_in_bar.setOnClickListener(this);

        desk_icon.setOnClickListener(this);

        check_update.setOnClickListener(this);

        advice_submit.setOnClickListener(this);

        using_help.setOnClickListener(this);

    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.settings_imageView1:
                SettingsActivity.this.finish();
                break;

            case R.id.settings_data_update:
                break;

            case R.id.settings_show_in_bar:
                break;

            case R.id.settings_desk_icon:
                break;

            case R.id.settings_check_update:
                break;

            case R.id.settings_advice_submit:
                break;

            case R.id.settings_using_help:
                break;
        }
    }
}
