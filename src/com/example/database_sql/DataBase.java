package com.example.database_sql;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
	 // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "contactsManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

	public DataBase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	 

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		 
        // Create tables again
        onCreate(db);
		// TODO Auto-generated method stub
		
	}
	void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
	
	 public List<Contact> getAllContacts() {
	        List<Contact> contactList = new ArrayList<Contact>();
	        // Select All Query
	        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
	 
	        SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // looping through all rows and adding to list
	        if (cursor.moveToFirst()) {
	            do {
	                Contact contact = new Contact();
	                contact.setID(Integer.parseInt(cursor.getString(0)));
	                contact.setName(cursor.getString(1));
	                contact.setPhoneNumber(cursor.getString(2));
	                // Adding contact to list
	                contactList.add(contact);
	            } while (cursor.moveToNext());
	        }
	 
	        // return contact list
	        return contactList;
	    }
	 
}
