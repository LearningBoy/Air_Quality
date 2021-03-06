package com.way.Right_Action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.way.Main_Action.R;

@SuppressLint("SimpleDateFormat")
public class MentionSettingsActivity extends Activity{
	
	SimpleDateFormat fmtTime = new SimpleDateFormat("HH:mm");
	TextView TimeLabel = null;
	Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener(){
		
		public void onTimeSet(TimePicker view, int hour, int minute) {
			dateAndTime.set(Calendar.HOUR,hour);
			dateAndTime.set(Calendar.MINUTE,minute);
			updateLabel();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mention_settings);
		
		ImageView Go_back = (ImageView) findViewById(R.id.mention_settings_imageView1);
	    Go_back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				MentionSettingsActivity.this.finish();
			}
		});
	    
	    RelativeLayout mentiontime = (RelativeLayout) findViewById(R.id.mention_time);
	    mentiontime.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				new TimePickerDialog(MentionSettingsActivity.this,t,
						dateAndTime.get(Calendar.HOUR),
						dateAndTime.get(Calendar.MINUTE),true).show();
			}
		});
	    
	    TimeLabel = (TextView) findViewById(R.id.get_time);
	    
	    updateLabel();
	}
	
	private void updateLabel(){
		TimeLabel.setText(fmtTime.format(dateAndTime.getTime()));
	}
}
