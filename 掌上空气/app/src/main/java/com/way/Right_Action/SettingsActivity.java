package com.way.Right_Action;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.way.Main_Action.R;

public class SettingsActivity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		ImageView Goback = (ImageView) findViewById(R.id.settings_imageView1);
	    Goback.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				SettingsActivity.this.finish();
			}
		});
	}

}
