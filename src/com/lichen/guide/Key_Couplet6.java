package com.lichen.guide;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Key_Couplet6 extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  String[] countries = getResources().getStringArray(R.array.couplet6);
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.key_couplet, countries));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    
	    	switch (position){
	    		case 0: Intent newActivity0 = new Intent(Key_Couplet6.this, Key_Couplet7.class);
	    		startActivity(newActivity0);
	    		break;
	    		
	    		 case 1:  Intent newActivity1 = new Intent(Key_Couplet6.this, Key_Couplet8.class);     
	                startActivity(newActivity1);
	                break;
	    		
	    	}
	     
	    	
	    }
	  });
	}
	
	//creates menu for menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.all_menu_menu, menu);
        return true;
    }
    @Override // the menu options and their on selection functions
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:     ShowMainMenu();
                                break;
            case R.id.index:     ShowLichenList();
                                break;
            case R.id.startkey:     RestartKey();
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