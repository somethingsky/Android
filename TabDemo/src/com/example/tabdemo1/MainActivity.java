package com.example.tabdemo1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TabHost tabHost=getTabHost();
		
		tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator(" ���Բ���").setContent(new Intent().setClass(this, Tab1Activity.class)));
		tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator(" ���Բ���").setContent(new Intent().setClass(this, Tab2Activity.class)));
		tabHost.addTab(tabHost.newTabSpec("TAB3").setIndicator(" ��Բ���").setContent(new Intent().setClass(this, Tab3Activity.class)));
	}
}