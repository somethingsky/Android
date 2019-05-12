package com.example.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
	public class NewActivity extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_new);
			final TextView welcome=(TextView)findViewById(R.id.TextView1);
			final EditText editText=(EditText)findViewById(R.id.editText1);
			Button button=(Button)findViewById(R.id.button1);
			Intent intent=getIntent();
			welcome.setText(" »¶Ó­Äã£º "+intent.getStringExtra("user"));
			Button.OnClickListener buttonListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent2=new Intent("com.example.broadcast");
					intent2.putExtra("key", editText.getText().toString());
						sendBroadcast(intent2);
					}
				};
			button.setOnClickListener(buttonListener);
		}
	}