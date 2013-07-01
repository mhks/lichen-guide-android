package com.lichen.guide;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutApp extends Activity {
	
	static Context context;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_menu);
        
    }
    
	//creates menu for menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.about_menu_menu, menu);
        return true;
    }
    @Override // the menu options and their on selection functions
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:     ShowMainMenu();
                                break;
            case R.id.index:     ShowLichenList();
                                break;
            case R.id.startkey:     StartKey();
            					break;
            
     //       case R.id.menu_glossary: GoGlossary();
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
    protected void StartKey(){
    	Intent i = new Intent(this, Key_Couplet1.class);
    	startActivity(i);
    }
    /*
    protected void GoGlossary(){
    	Intent i = new Intent(this, GlossaryList.class);
    	startActivity(i);
    } */


}
