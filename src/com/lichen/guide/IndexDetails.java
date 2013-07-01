package com.lichen.guide;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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



public class IndexDetails extends Activity {

	public static final String NULL = "NULL";
	
    private TextView mThallusText;
    private TextView mSubstrateText;
    private TextView mHabitatText;
    private TextView mNotesText;
    private TextView mBinomialText;    
    private TextView mApotheciaText;
    private TextView mSorediaText;
    private TextView mIsidiaText;
    private TextView mPycnidiaText;
    private TextView mCiliaText;
    private TextView mRhizinesText;
    private TextView mPseudocyphText;
        
    private static int photo_id1;
    private static int photo_id2;
    private static int photo_id3;
    private static int photo_id4;
    private static int photo_id5;
    
    private Gallery mLichenGallery;     
    public DatabaseHelper mDbHelper;
	protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lichen_details); 
        mDbHelper = new DatabaseHelper(this);
        mDbHelper.open();
        
        mLichenGallery = (Gallery) findViewById(R.id.gallery);      
        mBinomialText = (TextView) findViewById(R.id.binomial);
        mThallusText = (TextView) findViewById(R.id.growth_type);
        mSubstrateText = (TextView) findViewById(R.id.substrate);
        mHabitatText = (TextView) findViewById(R.id.habitat);
        mNotesText = (TextView) findViewById(R.id.notes);   
        mApotheciaText = (TextView) findViewById(R.id.apothecia);
        mSorediaText = (TextView) findViewById(R.id.soredia);
        mIsidiaText = (TextView) findViewById(R.id.isidia);
        mPycnidiaText = (TextView) findViewById(R.id.pycnidia);
        mCiliaText = (TextView) findViewById(R.id.cilia);
        mRhizinesText = (TextView) findViewById(R.id.rhizines);
        mPseudocyphText = (TextView) findViewById(R.id.pseudocyph);
        
        Bundle extras = getIntent().getExtras();
        
        if (extras != null) {
        	
        	//text
	        String growth = extras.getString(DatabaseHelper.KEY_THALLUS);
	        String substrate = extras.getString(DatabaseHelper.KEY_SUBSTRATE);
	        String habitat = extras.getString(DatabaseHelper.KEY_HABITAT);    
	        String apothecia = extras.getString(DatabaseHelper.KEY_APOTHECIA);
	        String soredia = extras.getString(DatabaseHelper.KEY_SOREDIA);
	        String isidia = extras.getString(DatabaseHelper.KEY_ISIDIA);
	        String pycnidia = extras.getString(DatabaseHelper.KEY_PYCNIDIA);
	        String cilia = extras.getString(DatabaseHelper.KEY_CILIA);
	        String rhizines = extras.getString(DatabaseHelper.KEY_RHIZINES);
	        String pseudocyph = extras.getString(DatabaseHelper.KEY_PSEUDOCYPH);
	        String notes = extras.getString(DatabaseHelper.KEY_NOTES);
	        String binomial = extras.getString(DatabaseHelper.KEY_BINOMIAL);

	        //images
	        
	        String pic1 = extras.getString(DatabaseHelper.PIC_ID1);
	        String pic2 = extras.getString(DatabaseHelper.PIC_ID2);
	        String pic3 = extras.getString(DatabaseHelper.PIC_ID3);
	        String pic4 = extras.getString(DatabaseHelper.PIC_ID4);
	        String pic5 = extras.getString(DatabaseHelper.PIC_ID5);

        	mBinomialText.setText(binomial);
        	mThallusText.setText(growth);
        	mSubstrateText.setText(substrate);
        	mHabitatText.setText(habitat);
        	mApotheciaText.setText(apothecia);
        	mNotesText.setText(notes);
        	mSorediaText.setText(soredia);
        	mIsidiaText.setText(isidia);
        	mPycnidiaText.setText(pycnidia);
        	mCiliaText.setText(cilia);
        	mRhizinesText.setText(rhizines);
        	mPseudocyphText.setText(pseudocyph);
        
	        IndexDetails.setPhoto_id1(this.getResources().getIdentifier(pic1, "drawable", this.getPackageName()));
	    	IndexDetails.setPhoto_id2(this.getResources().getIdentifier(pic2, "drawable", this.getPackageName()));
	        IndexDetails.setPhoto_id3(this.getResources().getIdentifier(pic3, "drawable", this.getPackageName()));
	        IndexDetails.setPhoto_id4(this.getResources().getIdentifier(pic4, "drawable", this.getPackageName()));
	        IndexDetails.setPhoto_id5(this.getResources().getIdentifier(pic5, "drawable", this.getPackageName()));

          }
        
          mLichenGallery.setAdapter(new ImageAdapterALL(this));
          
     } // end onCreate()

    //start photo1
    public static int getPhoto_id1() {
		return photo_id1;
    }
	public static void setPhoto_id1(int photo_id1) {
		IndexDetails.photo_id1 = photo_id1;
	}
	
	//start photo2    
    public static int getPhoto_id2() {
    	return photo_id2;
    }
    public static void setPhoto_id2(int photo_id2) {
    	IndexDetails.photo_id2 = photo_id2;
    }
    
	//start photo3
    public static int getPhoto_id3() {
    	return photo_id3;
    }
    public static void setPhoto_id3(int photo_id3) {
    	IndexDetails.photo_id3 = photo_id3;
    }
    
	//start photo4
    public static int getPhoto_id4() {
    	return photo_id4;
    }
    public static void setPhoto_id4(int photo_id4) {
    	IndexDetails.photo_id4 = photo_id4;
    }
    
	//start photo5 
    public static int getPhoto_id5() {
    	return photo_id5;
    }
    public static void setPhoto_id5(int photo_id5) {
    	IndexDetails.photo_id5 = photo_id5;
    }

		    
  //SET IMAGE ADAPTER
    
    	public class ImageAdapterALL extends BaseAdapter {	
    	  public Context mContext; 
          int mGalleryItemBackground;
          
          int photo1 = IndexDetails.getPhoto_id1();
          int photo2 = IndexDetails.getPhoto_id2();
          int photo3 = IndexDetails.getPhoto_id3();
          int photo4 = IndexDetails.getPhoto_id4();
          int photo5 = IndexDetails.getPhoto_id5();
        
          public Integer[] mImageIds = {
        		  photo1,
        		  photo2,
        		  photo3,
        		  photo4,
        		  photo5
          };   
     
          public ImageAdapterALL(Context c) {  	  
        	  mContext = c;
       //       TypedArray a = obtainStyledAttributes(R.styleable.HelloGallery);
       //       mGalleryItemBackground = a.getResourceId(
       //               R.styleable.HelloGallery_android_galleryItemBackground, 0);
        //      a.recycle();    
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
        //      i.setBackgroundResource(mGalleryItemBackground);
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
            case R.id.index:     ShowLichenList();
                                break;
            case R.id.startkey:     StartKey();
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




