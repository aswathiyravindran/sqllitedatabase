package com.example.database_sql;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name;
		final EditText num;
        Button save,view;
        
        name=(EditText)findViewById(R.id.name);
        num=(EditText)findViewById(R.id.num);
        save=(Button)findViewById(R.id.sbt);
        view=(Button)findViewById(R.id.vbt);
        
    }

   
}
