package com.example.sqlitedemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.view.Menu;

@SuppressLint("NewApi") public class MainActivity extends Activity {

    @Override
	public void startActivityForResult(Intent intent, int requestCode,
			Bundle options) {
		// TODO Auto-generated method stub
		super.startActivityForResult(intent, requestCode, options);
	}


	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerComponentCallbacks(callback);
	}


	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterComponentCallbacks(callback);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
