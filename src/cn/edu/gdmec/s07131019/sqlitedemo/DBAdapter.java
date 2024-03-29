package cn.edu.gdmec.s07131019.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter extends SQLiteOpenHelper {
	static String DB_NAME = "people";
	static String TABLE_NAME = "peopleinfo";
	static int DB_VERSION = 3;
	
	String KEY_ID="_id";
	String KEY_NAME="name";
	String KEY_AGE ="age";
	String KEY_HEIGHT = "height";
	
	SQLiteDatabase  db;
	Context _context;

	String DB_CREATE = "create table "+TABLE_NAME +"("+
						KEY_ID + " integer primary key autoincrement, "+
						KEY_NAME + " text not null ,"+
						KEY_AGE + " integer, "+
						KEY_HEIGHT + " float "+")";
	
	DBAdapter(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DB_NAME, null, DB_VERSION);
		db = this.getWritableDatabase();
		_context  = context;
	}
	

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(DB_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 String sql = "drop table if exists " + TABLE_NAME ;
		 db.execSQL(sql);
		 onCreate(db);
	}

	private People[] convertCursorToPeople(Cursor cursor){
		int rowCount = cursor.getCount();
		if (rowCount==0||!cursor.moveToFirst()){
			return null;
		}
		People[] result  = new People[rowCount];
		for (int i=0;i<rowCount;i++){
			result[i]=new People();
			result[i].Age = cursor.getInt(cursor.getColumnIndex(KEY_AGE));
			result[i].Height = cursor.getFloat(cursor.getColumnIndex(KEY_HEIGHT));
			result[i].Name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
			result[i].ID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
			cursor.moveToNext();
		}
		return result;
	}
	
	public People[] retrieveById(long id){
		Cursor cursor = db.query( TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_AGE,KEY_HEIGHT},
								KEY_ID+"="+id, null, null,null, null);
		return convertCursorToPeople(cursor);
	}
	public People[] retrieveAll(){
		Cursor cursor = db.query( TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_AGE,KEY_HEIGHT},
				null, null, null,null, null);
		return convertCursorToPeople(cursor);
	}
	public long insert(People people){
		ContentValues newValue = new ContentValues();
		newValue.put(KEY_NAME, people.Name);
		newValue.put(KEY_AGE, people.Age);
		newValue.put(KEY_HEIGHT, people.Height);
		long id = db.insert(TABLE_NAME, null, newValue);
		return id;
	}
	public long update(People people,long id){
		ContentValues updateValue = new ContentValues();
		updateValue.put(KEY_NAME, people.Name);
		updateValue.put(KEY_AGE, people.Age);
		updateValue.put(KEY_HEIGHT, people.Height);
		return db.update(TABLE_NAME, updateValue, KEY_ID +'='+id, null);
	}
	public int deleteById(long id){
		return db.delete(TABLE_NAME, KEY_ID +"="+id, null);
	}
	public int deleteAll(){
		return db.delete(TABLE_NAME, null, null);
	}
	
}
