package com.lichen.guide;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
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

public class Key_Couplet13 extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  String[] countries = getResources().getStringArray(R.array.couplet13);
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.key_couplet, countries));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    
	    	switch (position){
	    		case 0: 	AlertDialog.Builder builder = new AlertDialog.Builder(Key_Couplet13.this);
    			builder.setMessage("Usnea")
			       .setCancelable(false)
			       .setPositiveButton("Go to Index", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   Intent newActivity0 = new Intent(Key_Couplet13.this, IndexList.class);
				    		startActivity(newActivity0);
			           }
			       })
			.setNegativeButton("Back to Key", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		           }
		       });
			   
					builder.show();
	    		break;
	    		
	    		 case 1:  Intent newActivity1 = new Intent(Key_Couplet13.this, Key_Couplet14.class);     
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