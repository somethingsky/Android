package com.example.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityLifeCycleActivity extends Activity {

	private static String TAG = "LIFTCYCLE";
	//��ȫ�������ڿ�ʼʱ�����ã���ʼ��Activity							
	@Override  
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i(TAG, "(1) onCreate()");
       
		//���尴ť�Ͱ�ť����������ͨ���û������ť����finish()������������
		Button button = (Button)findViewById(R.id.btn_finish);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
			finish();
			}
		});
    }

	//�����������ڿ�ʼʱ�����ã����û�������б�Ҫ�ĸ���					
	@Override  
    public void onStart() {
        super.onStart();
        Log.i(TAG, "(2) onStart()");
    }

	//��onStart()�󱻵��ã����ڻָ�onSaveInstanceState()������û�������Ϣ	
	@Override 
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "(3) onRestoreInstanceState()");
	}

	//�ڻ�������ڿ�ʼʱ�����ã��ָ���onPause()ֹͣ�����ڽ�����µ���Դ		
	@Override 
	public void onResume() {
		super.onResume();
		Log.i(TAG, "(4) onResume()");
	}
	
	//��onPause()�󱻵��ã����������ʱ��Ϣ								
	@Override  
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "(5) onSaveInstanceState()");
	}
	
	//�����½��������������ǰ�����ã������������Ҫ�ĸ�����Ϣ				
	@Override  
	public void onRestart() {
		super.onRestart();
		Log.i(TAG, "(6) onRestart()");
	}

	//�ڻ�������ڽ���ʱ�����ã���������־õ����ݻ��ͷ�ռ�õ���Դ			
	@Override  
	public void onPause() {
		super.onPause();
		Log.i(TAG, "(7) onPause()");
	}
	
	//�ڿ����������ڽ���ʱ�����ã������ͷ�ռ�õ���Դ						
	@Override 
	public void onStop() {
		super.onStop();
		Log.i(TAG, "(8) onStop()");
	}
	
	//����ȫ�������ڽ���ʱ�����ã��ͷ���Դ�������̡߳��������ӵ�				
	@Override 
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "(9) onDestroy()");
	}
}
