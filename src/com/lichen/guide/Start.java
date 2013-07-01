package com.lichen.guide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends Activity {


	Button key_genera_button, species_index_button, glossary_button, about_button;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.start_options_main); 
        
        
        /* Navigation Buttons */
        final Button key_genera_button = (Button) findViewById(R.id.key_genera);
        key_genera_button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent newActivity0 = new Intent(Start.this, Key_Couplet1.class);
				startActivity(newActivity0);
				
			}	
		});
        
        final Button species_index_button = (Button) findViewById(R.id.index);
        species_index_button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent newActivity0 = new Intent(Start.this, IndexList.class);
				startActivity(newActivity0);
				
			}
		});
        
        final Button glossary_button = (Button) findViewById(R.id.glossary);
        glossary_button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent newActivity0 = new Intent(Start.this, GlossaryList.class);
				startActivity(newActivity0);
				
			}
		}); 
        
        final Button about_button = (Button) findViewById(R.id.about);
        about_button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent newActivity0 = new Intent(Start.this, AboutApp.class);
				startActivity(newActivity0);
				
			}
		});
    }
}


	  


	
/*	
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
            case R.id.menu_glossary: GoGlossary();
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
    protected void GoGlossary(){
    	Intent i = new Intent(this, Glossary.class);
    	startActivity(i);
    }*/


