
package com.lichen.guide;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class GlossaryDetails extends Activity {
	
    private static int gphoto_id1;
    private static int gphoto_id2;
	
    private TextView mGlossaryTitle;
    private TextView mGlossaryText;
    private Gallery mGlossaryGallery;

//    public DatabaseHelper mDbHelper;
//	protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glossary_details);
 //       mDbHelper = new DatabaseHelper(this);
 //       mDbHelper.open();
        
        mGlossaryGallery = (Gallery) findViewById(R.id.gallery); 
        mGlossaryTitle = (TextView) findViewById(R.id.glossary_title);
        mGlossaryText = (TextView) findViewById(R.id.glossary_text);

        Bundle extras = getIntent().getExtras();
        
        if (extras != null) {
        	
        	//title and text
            String glossaryTitle = extras.getString(DatabaseHelper.GLOSSARY_TITLE);
            String glossaryText = extras.getString(DatabaseHelper.GLOSSARY_ENTRY);
            
        	mGlossaryTitle.setText(glossaryTitle);
        	mGlossaryText.setText(glossaryText);
            
            //images
	        String gpic1 = extras.getString(DatabaseHelper.GPIC_ID1);
	        String gpic2 = extras.getString(DatabaseHelper.GPIC_ID2);
	        
	        GlossaryDetails.setPhoto_id1(this.getResources().getIdentifier(gpic1, "drawable", this.getPackageName()));
	    	GlossaryDetails.setPhoto_id2(this.getResources().getIdentifier(gpic2, "drawable", this.getPackageName()));
	       
	        //SET GALLERYVIEW  
	        mGlossaryGallery.setAdapter(new ImageAdapter(this));

        }
    }
    
    //start photo1
    public static int getPhoto_id1() {
		return gphoto_id1;
    }
	public static void setPhoto_id1(int gphoto_id1) {
		GlossaryDetails.gphoto_id1 = gphoto_id1;
	}
	
	//start photo2    
    public static int getPhoto_id2() {
    	return gphoto_id2;
    }
    public static void setPhoto_id2(int gphoto_id2) {
    	GlossaryDetails.gphoto_id2 = gphoto_id2;
    }

//GET IMAGES FOR GLOSSARY

	public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        
        int gphoto1 = GlossaryDetails.getPhoto_id1();
        int gphoto2 = GlossaryDetails.getPhoto_id2();
        
        private Integer[] mImageIds = {
                gphoto1,
                gphoto2
        };   

        public ImageAdapter(Context c) {
            mContext = c;
           // TypedArray a = obtainStyledAttributes(R.styleable.HelloGallery);
          //  mGalleryItemBackground = a.getResourceId(
          //          R.styleable.HelloGallery_android_galleryItemBackground, 0);
          //  a.recycle();
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        	
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setAdjustViewBounds(true);
            i.setScaleType(ImageView.ScaleType.FIT_XY);
        //    i.setBackgroundResource(mGalleryItemBackground);

            return i;
        }
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
            case R.id.index:    ShowLichenList();
                                break;
            case R.id.startkey: StartKey();
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
    protected void StartKey(){
    	Intent i = new Intent(this, Key_Couplet1.class);
    	startActivity(i);
    }
    protected void GoGlossary(){
    	Intent i = new Intent(this, GlossaryList.class);
    	startActivity(i);
    }
}



