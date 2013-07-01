
package com.lichen.guide;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class GlossaryList extends ListActivity {
	
	private static final int ACTIVITY_DISPLAY=1;
    private DatabaseHelper mDbHelper;
    private Cursor mNotesCursor;
	protected EditText searchText;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;

    @Override
	public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.glossary_main); 
        
        mDbHelper = new DatabaseHelper(this);
        mDbHelper.open();
        fillData();
        
    }
    private void fillData() {
        // Get all of the rows from the database and create the item list
        mNotesCursor = mDbHelper.fetchGlossaryIndex(); //CHANGE TO RETRIEVE GLOSSARY ENTRIES
        startManagingCursor(mNotesCursor);

        // Create an array to specify the fields we want to display in the list
        String[] from = new String[]{DatabaseHelper.GLOSSARY_TITLE};

        // and an array of the fields we want to bind those fields to 
        int[] to = new int[]{R.id.licGenus};

        // Now create a simple cursor adapter and set it to display
        SimpleCursorAdapter species = 
            new SimpleCursorAdapter(this, R.layout.lichen_row, mNotesCursor, from, to);
        setListAdapter(species);

    }

//manages what data gets sent to IndexDetails.class for display when an item is clicked
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor c = mNotesCursor;
        c.moveToPosition(position);
        Intent i = new Intent(this, GlossaryDetails.class);
        i.putExtra(DatabaseHelper.KEY_ROWID, id);
        
        i.putExtra(DatabaseHelper.GLOSSARY_TITLE, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.GLOSSARY_TITLE)));
        
        i.putExtra(DatabaseHelper.GLOSSARY_ENTRY, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.GLOSSARY_ENTRY)));
        
        i.putExtra(DatabaseHelper.GPIC_ID1, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.GPIC_ID1)));
        
        i.putExtra(DatabaseHelper.GPIC_ID2, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.GPIC_ID2)));
          
        startActivityForResult(i, ACTIVITY_DISPLAY);
    }
    
    //creates menu for menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.glossary_menu_menu, menu);
        return true;
    }
    @Override // the menu options and their on selection functions
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:     ShowMainMenu();
                                break;
            case R.id.index:    ShowLichenList();
                                break;
            case R.id.startkey: RestartKey();
								break;
        }
        return true;
    }
    //methods linking menu to other app pages
    protected void ShowMainMenu(){
    	Intent i = new Intent(this, Start.class);
    	startActivity(i);
    }
    protected void ShowLichenList(){
    	Intent i = new Intent(this, IndexList.class);
    	startActivity(i);
    }
    protected void RestartKey(){
    	Intent i = new Intent(this, Key_Couplet1.class);
    	startActivity(i);
    }


}

