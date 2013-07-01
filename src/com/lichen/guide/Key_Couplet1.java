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

public class Key_Couplet1 extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
/*      Builder builder = new AlertDialog.Builder(this);  
      builder.setTitle("Disclaimer");
      builder.setMessage("This is a key to the lichen genera found during surveys of EEON plots at TESC and does not necessarily " +
      		"reflect the entire possible lichen community found on campus.  For more detailed information, consult a field guide.");
      
      builder.setPositiveButton("Ok", null);
      builder.show();
*/

	  String[] couplet = getResources().getStringArray(R.array.couplet1);
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.key_couplet, couplet));
	  
	  

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    
	    	switch (position){
	    		case 0: Intent newActivity0 = new Intent(Key_Couplet1.this, Key_Couplet2.class);
	    		startActivity(newActivity0);
	    		break;
	    		
	    		 case 1:  
		    			AlertDialog.Builder builder1 = new AlertDialog.Builder(Key_Couplet1.this);
		    			builder1.setMessage("Lichenomphalia")
		    			       .setCancelable(false)
		    			       .setPositiveButton("Go to Index", new DialogInterface.OnClickListener() {
		    			           public void onClick(DialogInterface dialog, int id) {
		    			        	   Intent newActivity0 = new Intent(Key_Couplet1.this, IndexList.class);
		    				    		startActivity(newActivity0);
		    			           }
		    			       })
		    			.setNegativeButton("Back to Key", new DialogInterface.OnClickListener() {
		    		           public void onClick(DialogInterface dialog, int id) {
		    		                dialog.cancel();
		    		           }
		    		       });
		    			   
		    					builder1.show();	    			
		    			
		    		break;
	                
	    		 case 2: 
		    			AlertDialog.Builder builder2 = new AlertDialog.Builder(Key_Couplet1.this);
		    			builder2.setMessage("Cladonia")
		    			       .setCancelable(false)
		    			       .setPositiveButton("Go to Index", new DialogInterface.OnClickListener() {
		    			           public void onClick(DialogInterface dialog, int id) {
		    			        	   Intent newActivity0 = new Intent(Key_Couplet1.this, IndexList.class);
		    				    		startActivity(newActivity0);
		    			           }
		    			       })
		    			.setNegativeButton("Back to Key", new DialogInterface.OnClickListener() {
		    		           public void onClick(DialogInterface dialog, int id) {
		    		                dialog.cancel();
		    		           }
		    		       });
		    			   
		    					builder2.show();	    			
		    			
		    		break;
	              
	    		 case 3: 
		    			AlertDialog.Builder builder3 = new AlertDialog.Builder(Key_Couplet1.this);
		    			builder3.setMessage("Sphaerophorus")
		    			       .setCancelable(false)
		    			       .setPositiveButton("Go to Index", new DialogInterface.OnClickListener() {
		    			           public void onClick(DialogInterface dialog, int id) {
		    			        	   Intent newActivity0 = new Intent(Key_Couplet1.this, IndexList.class);
		    				    		startActivity(newActivity0);
		    			           }
		    			       })
		    			.setNegativeButton("Back to Key", new DialogInterface.OnClickListener() {
		    		           public void onClick(DialogInterface dialog, int id) {
		    		                dialog.cancel();
		    		           }
		    		       });
		    			   
		    					builder3.show();	    			
		    			
		    		break;
	    		
	    	}
	     
	    	
	    }
	  });
	}
	
	//creates menu for menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.first_couplet_menu_menu, menu);
        return true;
    }
    @Override // the menu options and their on selection functions
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:     ShowMainMenu();
                                break;
            case R.id.index:     ShowLichenList();
                                break;
 //           case R.id.menu_glossary: GoGlossary();
//			break;


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
 //   protected void GoGlossary(){
  //  	Intent i = new Intent(this, GlossaryList.class);
  //  	startActivity(i);
  //  }
}