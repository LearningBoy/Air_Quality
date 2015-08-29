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
	
	//��ȡʱ���ʽ������
	//DateFormat fmtTime = DateFormat.getDateTimeInstance();
	SimpleDateFormat fmtTime = new SimpleDateFormat("HH:mm");
	TextView TimeLabel = null;
	//��ȡһ���������
	Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener(){
		
		public void onTimeSet(TimePicker view, int hour, int minute) {
			// TODO Auto-generated method stub
			dateAndTime.set(Calendar.HOUR,hour);
			dateAndTime.set(Calendar.MINUTE,minute);
			updateLabel();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mention_settings);
		
		ImageView Goback = (ImageView) findViewById(R.id.mention_settings_imageView1);
	    Goback.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				MentionSettingsActivity.this.finish();
			}
		});
	    
	    RelativeLayout mentiontime = (RelativeLayout) findViewById(R.id.mention_time);
	    mentiontime.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
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
