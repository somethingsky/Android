package com.example.introduce;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Button;
import android.app.Activity;

	public class MainActivity extends Activity{
		String name="";
		String sex="";
		String hobby="";
		String age="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Show();
		final CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox1);
		final CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
		final CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
		final EditText editText1=(EditText)findViewById(R.id.editText1);
		final EditText editText2=(EditText)findViewById(R.id.editText2);
		final RadioButton radio1=(RadioButton)findViewById(R.id.radio1);
		final RadioButton radio2=(RadioButton)findViewById(R.id.radio2);
		final Button button=(Button)findViewById(R.id.button1);
		final Spinner spinner=(Spinner)findViewById(R.id.spinner1);
		Button.OnClickListener buttonListener=new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		name="";
		age="";
		name=editText1.getText().toString();
		age=spinner.getSelectedItem().toString();
		editText2.setText(" 大家好,我是"+name+", 性别:"+sex+", 爱好:"+hobby+"年级:"+age);
				return;
			}
	};
		button.setOnClickListener(buttonListener);
		CheckBox.OnClickListener checkboxListener=new CheckBox.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hobby="";
				if(checkBox1.isChecked())
					MainActivity.this.hobby+=" 音乐,";
				if(checkBox2.isChecked())
					MainActivity.this.hobby+=" 运动,";
				if(checkBox3.isChecked())
					MainActivity.this.hobby+=" 电影,";
				return;
			}
		};
		checkBox1.setOnClickListener(checkboxListener);
		checkBox2.setOnClickListener(checkboxListener);
		checkBox3.setOnClickListener(checkboxListener);
			RadioButton.OnClickListener raidoButtonListener=new RadioButton.OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					switch(v.getId()){
						case R.id.radio1:
							if(radio1.isChecked())
								MainActivity.this.sex=" 男";
							return;
						case R.id.radio2:
							if(radio2.isChecked())
								MainActivity.this.sex=" 女";
							return;
					}
				}
			};
				radio1.setOnClickListener(raidoButtonListener);
				radio2.setOnClickListener(raidoButtonListener);
	}
		public void Show(){
			Spinner spinner=(Spinner)findViewById(R.id.spinner1);
				List<String>list=new ArrayList<String>();
					list.add(" 大一年级");
					list.add(" 大二年级");
					list.add(" 大三年级");
					list.add(" 大四年级");
				ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
					adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					spinner.setAdapter(adapter);
				}
	}