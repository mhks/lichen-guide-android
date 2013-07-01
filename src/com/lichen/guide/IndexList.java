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

public class IndexList extends ListActivity {
	
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
        setContentView(R.layout.main); 
        
        mDbHelper = new DatabaseHelper(this);
        mDbHelper.open();
        fillData();
        
    }
    private void fillData() {
        // Get all of the rows from the database and create the item list
        mNotesCursor = mDbHelper.fetchLichenIndex();
        startManagingCursor(mNotesCursor);

        // Create an array to specify the fields we want to display in the list
        String[] from = new String[]{DatabaseHelper.KEY_GENUS, DatabaseHelper.KEY_SPECIES};

        // and an array of the fields we want to bind those fields to 
        int[] to = new int[]{R.id.licGenus, R.id.licSpecies};

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
        Intent i = new Intent(this, IndexDetails.class);
        
        i.putExtra(DatabaseHelper.KEY_ROWID, id);
        
        i.putExtra(DatabaseHelper.KEY_GENUS, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_GENUS)));
        
        i.putExtra(DatabaseHelper.KEY_SPECIES, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_SPECIES)));
        
        i.putExtra(DatabaseHelper.KEY_THALLUS, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_THALLUS)));
        
        i.putExtra(DatabaseHelper.KEY_SUBSTRATE, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_SUBSTRATE)));
        
        i.putExtra(DatabaseHelper.KEY_HABITAT, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_HABITAT)));
        
        i.putExtra(DatabaseHelper.KEY_NOTES, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_NOTES)));
        
        i.putExtra(DatabaseHelper.KEY_BINOMIAL, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_BINOMIAL)));
        
        i.putExtra(DatabaseHelper.KEY_APOTHECIA, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_APOTHECIA)));
        
        i.putExtra(DatabaseHelper.KEY_SOREDIA, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_SOREDIA)));
        
        i.putExtra(DatabaseHelper.KEY_ISIDIA, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_ISIDIA)));
        
        i.putExtra(DatabaseHelper.KEY_PYCNIDIA, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_PYCNIDIA)));
        
        i.putExtra(DatabaseHelper.KEY_CILIA, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_CILIA)));
        
        i.putExtra(DatabaseHelper.KEY_RHIZINES, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_RHIZINES)));
        
        i.putExtra(DatabaseHelper.KEY_PSEUDOCYPH, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.KEY_PSEUDOCYPH)));
        
        //The image names passed over to IndexDetails activity
        i.putExtra(DatabaseHelper.PIC_ID1, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.PIC_ID1)));
        
        i.putExtra(DatabaseHelper.PIC_ID2, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.PIC_ID2)));
        i.putExtra(DatabaseHelper.PIC_ID3, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.PIC_ID3)));
        i.putExtra(DatabaseHelper.PIC_ID4, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.PIC_ID4)));
        i.putExtra(DatabaseHelper.PIC_ID5, c.getString(
                c.getColumnIndexOrThrow(DatabaseHelper.PIC_ID5)));

        startActivityForResult(i, ACTIVITY_DISPLAY);
        
    }

	//creates menu for menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.species_menu_menu, menu);
        return true;
    }
    @Override // the menu options and their on selection functions
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:     ShowMainMenu();
                                break;
            case R.id.startkey:     StartKey();
            					break;
            
    //        case R.id.menu_glossary: GoGlossary();
            
	//		break;


        }
        return true;
    }
    //methods linking menu to other app pages
    protected void ShowMainMenu(){
    	Intent i = new Intent(this, Start.class);
    	startActivity(i);
    }

    protected void StartKey(){
    	Intent i = new Intent(this, Key_Couplet1.class);
    	startActivity(i);
    }
 //   protected void GoGlossary(){
  //  	Intent i = new Intent(this, GlossaryList.class);
  //  	startActivity(i);
  //  }



}
    
 
    
    
