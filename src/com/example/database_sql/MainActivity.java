package com.example.database_sql;

import java.util.List;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	EditText name;
	 EditText num;
    Button save,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        name=(EditText)findViewById(R.id.name);
        num=(EditText)findViewById(R.id.num);
        save=(Button)findViewById(R.id.sbt);
        view=(Button)findViewById(R.id.vbt);
        final DataBase d=new DataBase(this);
        save.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		       
		        String cname=name.getText().toString();
				String cnum=num.getText().toString();
		        d.addContact(new Contact(cname,cnum));
		        Toast.makeText(getApplicationContext(),cname + " saved",Toast.LENGTH_LONG).show();  
				
			}
        	
        });
        
        view.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 List<Contact> contacts = d.getAllContacts(); 
				 for (Contact cn : contacts) {
			            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
			                // Writing Contacts to log
			            Intent i=new Intent(MainActivity.this,Second_activity.class);
			            i.putExtra("username",log);
			            startActivity(i);
			            
			    }
				
			}
        	
        });
    }

   
}
