package com.example.serivce;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
	public class MathService extends Service{
		private final IBinder mBinder=new LocalBinder();
		public class LocalBinder extends Binder{
			MathService getService(){
				return MathService.this;
			}
		}
		@Override
		public IBinder onBind(Intent arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(this, " 已启动服务", Toast.LENGTH_SHORT).show();
			return mBinder;
		}
		@Override
		public boolean onUnbind(Intent intent){
			Toast.makeText(this, " 已取消服务", Toast.LENGTH_SHORT).show();
			return false;
		}
		public int Compare(int a,int b){
			if(a>b){
				return a;
			}
			else if(b>a){
				return b;
			}
			else
				return 0;
		}
		public int add(int a,int b) {
			return a+b;
		}
	}
