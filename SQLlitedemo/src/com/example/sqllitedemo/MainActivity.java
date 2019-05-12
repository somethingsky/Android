package com.example.sqllitedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
	public class MainActivity extends Activity {
		private DBAdapter dbadapter;
		private Context mContext;
		public DBAdapter getDbadapter() {
			return dbadapter;
		}
		public void setDbadapter(DBAdapter dbadapter) {
			this.dbadapter = dbadapter;
		}
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			final EditText name=(EditText)findViewById(R.id.editText1);
			final EditText sex=(EditText)findViewById(R.id.editText2);
			final EditText place=(EditText)findViewById(R.id.editText3);
			final EditText pay=(EditText)findViewById(R.id.editText4);
			final EditText ID=(EditText)findViewById(R.id.editText5);
			final Button add=(Button)findViewById(R.id.button1);
			final Button show=(Button)findViewById(R.id.button2);
			Button clean=(Button)findViewById(R.id.button3);
			Button delete=(Button)findViewById(R.id.button4);
			Button ID_delete=(Button)findViewById(R.id.button5);
			Button ID_check=(Button)findViewById(R.id.button6);
			Button ID_update=(Button)findViewById(R.id.button7);
			Button Quit=(Button)findViewById(R.id.button8);
			final TextView showdata=(TextView)findViewById(R.id.textView6);
			mContext = this;
			Button.OnClickListener QuitListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					finish();
				}
			};
			Button.OnClickListener addListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbadapter =new DBAdapter(mContext);
					dbadapter.open();
					People add=new People();
					add.Name=name.getText().toString();
					add.Sex=sex.getText().toString();
					add.Place=place.getText().toString();
					if(!pay.getText().toString().equals(""))
					add.Pay=Integer.parseInt(pay.getText().toString());
					else add.Pay=0;
					dbadapter.insert(add);
					dbadapter.close();
				}
			};
			Button.OnClickListener cleanListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					showdata.setText("");
				}
			};
			Button.OnClickListener deleteListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbadapter =new DBAdapter(mContext);
					dbadapter.open();
					dbadapter.deleteAllData();
					dbadapter.close();
				}
			};
			Button.OnClickListener ShowListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbadapter =new DBAdapter(mContext);
					dbadapter.open();
					People[] shows=new People[56];
					String results = "";
					if(ID.getText().toString()==null)
						Toast.makeText(MainActivity.this, " 请输入ID",Toast.LENGTH_SHORT).show();
					else if(dbadapter.getAllData()!=null){
						shows=dbadapter.getAllData();
						dbadapter.close();
						for(int i=0;i<shows.length;i++){
							results += shows[i];
							results += "\n";
						}
					}
					else
						Toast.makeText(MainActivity.this, " 未找到相关记录",Toast.LENGTH_SHORT).show();
					showdata.setText(results.toString());
				}
			};
			Button.OnClickListener ID_deleteListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(ID.getText().toString().equals(""))
						Toast.makeText(MainActivity.this, " 请输入ID",Toast.LENGTH_SHORT).show();
					else{
						dbadapter =new DBAdapter(mContext);
						dbadapter.open();
						int id=Integer.parseInt(ID.getText().toString());
						dbadapter.deleteOneData(id);
						dbadapter.close();
					}
				}
			};
			Button.OnClickListener ID_checkListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(ID.getText().toString().equals(""))
						Toast.makeText(MainActivity.this, " 请输入ID",Toast.LENGTH_SHORT).show();
					else{
						dbadapter =new DBAdapter(mContext);
						dbadapter.open();
						long id=Integer.parseInt(ID.getText().toString());
						People[] shows=new People[1];
						if(dbadapter.getOneData(id)!=null){
							shows=dbadapter.getOneData(id);
							dbadapter.close();
							String results = shows[0].toString();
							showdata.setText(results);
						}
					}
				}
			};
			Button.OnClickListener ID_updateListener=new Button.OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(ID.getText().toString().equals(""))
						Toast.makeText(MainActivity.this, " 请输入ID",Toast.LENGTH_SHORT).show();
					else{
						dbadapter =new DBAdapter(mContext);
						dbadapter.open();
						long id=Integer.parseInt(ID.getText().toString());
						People people=new People();
						people.Name=name.getText().toString();
						people.Sex=sex.getText().toString();
						people.Place=place.getText().toString();
						if(!pay.getText().toString().equals(""))
							people.Pay=Integer.parseInt(pay.getText().toString());
						else people.Pay=0;
						dbadapter.updateOneData(id, people);
						dbadapter.close();
					}
				}
			};
			add.setOnClickListener(addListener);
			show.setOnClickListener(ShowListener);
			clean.setOnClickListener(cleanListener);
			delete.setOnClickListener(deleteListener);
			Quit.setOnClickListener(QuitListener);
			ID_delete.setOnClickListener(ID_deleteListener);
			ID_check.setOnClickListener(ID_checkListener);
			ID_update.setOnClickListener(ID_updateListener);
		}
	}