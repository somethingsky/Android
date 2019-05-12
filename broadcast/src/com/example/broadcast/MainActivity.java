package com.example.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
	public class MainActivity extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			final Intent intent=new Intent(this,NewActivity.class);
			final EditText Name=(EditText)findViewById(R.id.editText1);
			Button Login=(Button)findViewById(R.id.button1);
			Button Quit=(Button)findViewById(R.id.button2);
			Button.OnClickListener LoginListener=new Button.OnClickListener(){
				@Override
				public void onClick(View i) {
					// TODO Auto-generated method stub
					switch(i.getId()){
					case R.id.button1:
						if(LoginCheck()){
							intent.putExtra("user", Name.getText().toString());
							startActivity(intent);
							return;
						}
						else{
							Toast.makeText(getApplicationContext(), " 用户名或密码错误", Toast.LENGTH_SHORT).show();
							return;
						}
					case R.id.button2:
						finish();
					}
				}
			};
			Login.setOnClickListener(LoginListener);
			Quit.setOnClickListener(LoginListener);
		}
		public boolean LoginCheck(){
			EditText Name=(EditText)findViewById(R.id.editText1);
			EditText Password=(EditText)findViewById(R.id.editText2);
			if(!Name.getText().toString().equals("admin")){
				return false;
			}
			else if(!Password.getText().toString().equals("123456")){
				return false;
			}
			else
				return true;
		}
	}
