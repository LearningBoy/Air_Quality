package com.way.Left_Action;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.way.Main_Action.HandAirActivity;
import com.way.Main_Action.R;

public class CityChooseActivity extends Activity{
	
	private String[] str_list = {"","","","","","","","",""};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_choose);
		
		ListView lv = (ListView)findViewById(R.id.city_choose_list);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();

        for (String str:str_list ){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("test1", str);
            listItem.add(map);
        }

		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,
                R.layout.city_choose_item,
          new String[] {"test1"},
          new int[] {R.id.choose_item_textview_1}  
            );
		lv.setAdapter(mSimpleAdapter);
		lv.setOnItemClickListener(new OnItemClickListener(){
			
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(CityChooseActivity.this,HandAirActivity.class);
				startActivity(intent);
				CityChooseActivity.this.finish();
			}	
		});
	}
}

