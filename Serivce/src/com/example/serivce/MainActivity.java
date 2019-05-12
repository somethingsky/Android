package com.example.serivce;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.content.ComponentName;
	@SuppressWarnings("unused")
	public class MainActivity extends Activity {
		private MathService mathService;
		private boolean isBound=false;
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				final EditText One=(EditText)findViewById(R.id.editText1);
				final EditText Two=(EditText)findViewById(R.id.editText2);
				Button Begin=(Button)findViewById(R.id.button1);
				Button Do=(Button)findViewById(R.id.button2);
				Button Stop=(Button)findViewById(R.id.button3);
				Button Quit=(Button)findViewById(R.id.button4);
				final TextView textView=(TextView)findViewById(R.id.textView1);
				Begin.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(!isBound){
							final Intent serviceIntent=new Intent(MainActivity.this,MathService.class);
							bindService(serviceIntent,mConnection,Context.BIND_AUTO_CREATE);
							isBound=true;
						}
					}
				});
				Do.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(mathService==null){
							textView.setText(" 未绑定服务");
							return;
						}
						int a=Integer.parseInt(One.getText().toString());
						int b=Integer.parseInt(Two.getText().toString());
						int s=mathService.Compare(a, b);
						int c=mathService.add(a, b);
						textView.setText(" 较大的数为： "+s+"；求和结果为： "+c);
					}
				});
				Stop.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View arg0){
						if(isBound){
							isBound=false;
							unbindService(mConnection);
							mathService=null;
						}
					}
				});
				Quit.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View arg0){
						finish();
					}
				});
			}
			private ServiceConnection mConnection=new ServiceConnection(){
				@Override
				public void onServiceConnected(ComponentName name,IBinder service){
					mathService=((MathService.LocalBinder)service).getService();
				}
				@Override
				public void onServiceDisconnected(ComponentName name){
					mathService=null;
				}
			};
	}