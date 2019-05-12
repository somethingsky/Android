package com.example.sqllitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
	public class DBAdapter {
		private static final String DB_NAME="people.db";
		private static final String DB_TABLE="peopleinfo";
		private static final int DB_VERSION=1;
		public static final String KEY_ID="_id";
		public static final String KEY_NAME="name";
		public static final String KEY_SEX="sex";
		public static final String KEY_PLACE="place";
		public static final String KEY_PAY="pay";
		private SQLiteDatabase db;
		private final Context context;
		private DBOpenHelper dbOpenHelper;
		private static class DBOpenHelper extends SQLiteOpenHelper{
			public DBOpenHelper(Context context,String name,CursorFactory factory,int version){
				super(context,name,factory,version);
			}
			private static final String DB_CREATE="create table "
										+ DB_TABLE + 
										"("
										+ KEY_ID + 
										" integer primary key autoincrement, " 
										+ KEY_NAME + 
										" text not null, " 
										+ KEY_SEX + 
										" text not null, " 
										+ KEY_PLACE + 
										" text not null, " 
										+ KEY_PAY + 
										" integer ); ";
			@Override
			public void onCreate(SQLiteDatabase _db) {
				// TODO Auto-generated method stub
				_db.execSQL(DB_CREATE);
			}
			@Override
			public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
				// TODO Auto-generated method stub
				_db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
				onCreate(_db);
			}
		}
		public DBAdapter(Context _context){
			context=_context;
		}
		public void open() throws SQLiteException {
			dbOpenHelper=new DBOpenHelper(context,DB_NAME,null,DB_VERSION);
			try{
				db=dbOpenHelper.getWritableDatabase();
			}catch(SQLiteException ex){
				db=dbOpenHelper.getReadableDatabase();
				ex.printStackTrace();
			}
		}
		public void close(){
			if(db!=null){
				db.close();
				db=null;
			}
		}
		public void insert(People people){
			ContentValues newValues=new ContentValues();
			newValues.put(KEY_NAME, people.Name);
			newValues.put(KEY_SEX, people.Sex);
			newValues.put(KEY_PLACE, people.Place);
			newValues.put(KEY_PAY, people.Pay);
			db.insert(DB_TABLE, null, newValues);
			Toast.makeText(context, " 添加数据成功", Toast.LENGTH_SHORT).show();
		}
		public void deleteAllData(){
			db.delete(DB_TABLE, null, null);
			Toast.makeText(context, " 删除数据成功", Toast.LENGTH_SHORT).show();
		}
		public void deleteOneData(long id){
			if(this.getOneData(id)!=null){
				db.delete(DB_TABLE, KEY_ID+"="+id, null);
				Toast.makeText(context, " 删除数据成功", Toast.LENGTH_SHORT).show();
			}
		}
		public void updateOneData(long id,People people){
			if(this.getOneData(id)!=null){
				ContentValues updateValues=new ContentValues();
				updateValues.put(KEY_NAME, people.Name);
				updateValues.put(KEY_SEX, people.Sex);
				updateValues.put(KEY_PLACE, people.Place);
				updateValues.put(KEY_PAY, people.Pay);
				db.update(DB_TABLE, updateValues, KEY_ID + "=" +id, null);
				Toast.makeText(context, " 更新数据成功", Toast.LENGTH_SHORT).show();
			}
		}
		private People[] ConvertToPeople(Cursor cursor){
			int resultCounts=cursor.getCount();
			if(resultCounts==0||!cursor.moveToFirst()){
				return null;
			}
			People[] peoples=new People[resultCounts];
			for(int i=0;i<resultCounts;i++){
				peoples[i]=new People();
				peoples[i].ID=cursor.getInt(0);
				peoples[i].Name=cursor.getString(cursor.getColumnIndex(KEY_NAME));
				peoples[i].Sex=cursor.getString(cursor.getColumnIndex(KEY_SEX));
				peoples[i].Place=cursor.getString(cursor.getColumnIndex(KEY_PLACE));
				peoples[i].Pay=cursor.getInt(cursor.getColumnIndex(KEY_PAY));
				cursor.moveToNext();
			}
			return peoples;
		}
		public People[] getAllData(){
			Cursor results=db.query(DB_TABLE, new String[]{KEY_ID, KEY_NAME,KEY_SEX, KEY_PLACE, KEY_PAY},null,null,null,null,null);
			return ConvertToPeople(results);
		}
		public People[] getOneData(long id){
			Cursor results=db.query(DB_TABLE, new String[]{KEY_ID, KEY_NAME,KEY_SEX, KEY_PLACE, KEY_PAY},KEY_ID + "=" + id,null,null,null,null);
			if(ConvertToPeople(results)!=null)
				return ConvertToPeople(results);
			else
				Toast.makeText(context, " 未找到相关记录",Toast.LENGTH_SHORT).show();
				return null;
		}
	}
