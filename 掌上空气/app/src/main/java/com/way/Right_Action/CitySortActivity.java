package com.way.Right_Action;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.way.Main_Action.R;

public class CitySortActivity extends Activity{
	
	private String[] sort = {"1","2","3","4","5","6","7","8","9"};
	private String[] city = {"city_1","city_2","city_3","city_4","city_5","city_6","city_7","city_8","city_9"};
	private String[] AQI = {"1","1","1","1","1","1","1","1","1"};
	
	ListView lv;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_sort);
		
		lv = (ListView) findViewById(R.id.city_sort_list);  
		
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
        
		int lengh = sort.length;  
		for(int i =0; i < lengh; i++) {  
		    HashMap<String,Object> map = new HashMap<String,Object>();  
		    map.put("test1", sort[i]);  
	        map.put("test2", city[i]); 
	        map.put("test3", AQI[i]);
	        listItem.add(map);   
	    }  
		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,
                R.layout.city_sort_item,
          new String[] {"test1","test2", "test3"},
          new int[] {R.id.item_textview_1,R.id.item_textview_2,R.id.item_textview_3}  
            );
		lv.setAdapter(mSimpleAdapter);

		ImageView Goback = (ImageView) findViewById(R.id.city_sort_imageView1);
	    Goback.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CitySortActivity.this.finish();
			}
		});
	
	}
}
