package cn.edu.gdmec.s07131019.sqlitedemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText myEt1,myEt2,myEt3,myEt4;
	TextView myTv;
	
	People people=new People();
	DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEt1 = (EditText) findViewById(R.id.editText1);
        myEt2 = (EditText) findViewById(R.id.editText2);
        myEt3 = (EditText) findViewById(R.id.editText3);
        myEt4 = (EditText) findViewById(R.id.editText4);
        myTv = (TextView) findViewById(R.id.textView5);
        dbAdapter = new DBAdapter(this,null,null,0);       
    }
    
    People getPeopleInfo(){
    	people.Name = myEt2.getText().toString();
    	people.Age = Integer.parseInt(myEt3.getText().toString());
    	people.Height = Float.parseFloat(myEt4.getText().toString());
    	if (people.Name.equals("")){
    		return null;
    	}else{
    		return people;
    	}
    }

    
    public void create(View v){
    	if (getPeopleInfo()!=null){
    		long id =dbAdapter.insert(people);
    		myTv.setText("people id:"+id+" has been create");
    	}
    }
    
    public void retrieve(View v){
    	long id = Long.parseLong(myEt1.getText().toString());
    	People[] ps = dbAdapter.retrieveById(id);
    	myTv.setText(ps[0].toString());
    }
   
    public void retrievall(View v){
    	People[] ps = dbAdapter.retrieveAll();
    	if (ps==null ||ps.length==0){
    		return;
    	}
    	String msg="";
    	for (int i=0;i<ps.length;i++){
    		msg += ps[i].toString();
    	}
    	myTv.setText(msg);
    }
    
    public void update(View v){
    	if (getPeopleInfo()!=null){
    		long id = dbAdapter.update(people, Integer.parseInt(myEt1.getText().toString()));
    		myTv.setText("id:"+id+" has been updated.");
    	}
    }
    
    public void delete(View v){
    	long id = Long.parseLong(myEt1.getText().toString());
    	int affectrows= dbAdapter.deleteById(id);
    	myTv.setText(affectrows+"rows have been delete.");
    	
    }
    public void deleteAll(View v){
    	int affectrows = dbAdapter.deleteAll();
    	myTv.setText(affectrows+"rows have been delete.");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
