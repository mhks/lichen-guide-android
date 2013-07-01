package com.lichen.guide;


import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
	//DATABASE VERSION !!!!!!!
	private static final int DB_VERSION = 11; // 3 = 5/21/11 release, 11 = 12/3/11
	//DATABASE VERSION!!!!!!!!! CHANGE EACH RELEASE!!!!WHY?  SO USERS DON'T HAVE TO UNINSTALL THE APP !!
	
	public static final String DATABASE_NAME = "lichendb";
	public static final String DATABASE_TABLE = "lichens";
	public static final String DATABASE_LICHEN_INDEX = "lichen_index";
	
	public static final String GLOSSARY_TABLE = "glossary";
	public static final String GLOSSARY_TITLE = "entry_title";
	public static final String GLOSSARY_ENTRY = "entry_body";
	
	//TEXT ITEMS 
	public static final String KEY_ROWID = "_id";
	public static final String KEY_GENUS = "genus";
	public static final String KEY_SPECIES = "species";
	public static final String KEY_SUBSTRATE = "substrate";
	public static final String KEY_THALLUS = "thallus_type";
	public static final String KEY_HABITAT = "habitat";
	public static final String KEY_NOTES = "notes";
	public static final String KEY_FOREST_TYPE = "forest_type";
	public static final String KEY_BINOMIAL = "full_binomial";
	public static final String KEY_APOTHECIA = "apothecia";
	public static final String KEY_SOREDIA = "soredia";
	public static final String KEY_ISIDIA = "isidia";
	public static final String KEY_PYCNIDIA = "pycnidia";
	public static final String KEY_CILIA = "cilia";
	public static final String KEY_RHIZINES = "rhizines";
	public static final String KEY_PSEUDOCYPH = "pseudocyphellae";
	
	//lichen IMAGE NAMES
	public static final String PIC_ID1 = "pic_1";
	public static final String PIC_ID2 = "pic_2";
	public static final String PIC_ID3 = "pic_3";
	public static final String PIC_ID4 = "pic_4";
	public static final String PIC_ID5 = "pic_5";

	//glossary IMAGE NAMES
	public static final String GPIC_ID1 = "pic_1";
	public static final String GPIC_ID2 = "pic_2";


	protected Context context;
	public SQLiteDatabase mDb;
	private DatabaseHelper mDbHelper;
	
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DB_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String s;
		try {
			
			InputStream in = context.getResources().openRawResource(R.raw.lichendb);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(in, null);
			NodeList statements = doc.getElementsByTagName("statement");
			for (int i=0; i<statements.getLength(); i++) {
				s = statements.item(i).getChildNodes().item(0).getNodeValue();
				db.execSQL(s);
			}
		} catch (Throwable t) {
			Toast.makeText(context, t.toString(), 50000).show();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS lichen_index");
		db.execSQL("DROP TABLE IF EXISTS glossary");	
		onCreate(db);
	}
	
	
    public DatabaseHelper open() throws SQLException {
        mDbHelper = new DatabaseHelper(context);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    
    public Cursor fetchLichenIndex() {

        return mDb.query(DATABASE_LICHEN_INDEX, new String[] {
        		KEY_ROWID, 
        		KEY_GENUS,
                KEY_SPECIES, 
                KEY_SUBSTRATE, 
                KEY_THALLUS, 
                KEY_HABITAT,
                KEY_NOTES,
                KEY_BINOMIAL,
                KEY_APOTHECIA,
                KEY_SOREDIA,
                KEY_ISIDIA,
                KEY_PYCNIDIA,
                KEY_CILIA,
                KEY_RHIZINES,
                KEY_PSEUDOCYPH,
                PIC_ID1,
                PIC_ID2,
                PIC_ID3,
                PIC_ID4,
                PIC_ID5}, null, null, null, null, null);
    }
    
    
    public Cursor fetchGlossaryIndex() {

        return mDb.query(GLOSSARY_TABLE, new String[] {
        		KEY_ROWID, 
        		GLOSSARY_TITLE,
                GLOSSARY_ENTRY,
                GPIC_ID1,
                GPIC_ID2}, null, null, null, null, null);
    }
    

}
    
    

    

