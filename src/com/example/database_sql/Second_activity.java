package com.example.database_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second_activity extends Activity{
	
	String data;
	TextView d;
	protected void onCreate(Bundle  savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
    	data= i.getStringExtra("username");
    	d=(TextView)findViewById(R.id.cname);
    	d.setText("Content is"+d);

	}


}
