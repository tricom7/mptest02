package com.example.mptest02;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	 /** Called when the activity is first created. */
	 MediaPlayer m;
	 Context c;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnPlay1 = (Button)findViewById(R.id.buttonPlay1);
		Button btnPlay2 = (Button)findViewById(R.id.buttonPlay2);
		Button btnPlay3 = (Button)findViewById(R.id.buttonPlay3);
		Button btnPlay4 = (Button)findViewById(R.id.buttonPlay4);
		
	    Button btnStop = (Button)findViewById(R.id.buttonStop);
	 
	    //Register button click listener
	    btnPlay1.setOnClickListener(this);
	    btnPlay2.setOnClickListener(this);
	    btnPlay3.setOnClickListener(this);
	    btnPlay4.setOnClickListener(this);
	    
	    btnStop.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
    //Register button click event
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.buttonPlay1){
            play(R.raw.a);
        }else if(id == R.id.buttonPlay2){
        	play(R.raw.b);
        }else if(id == R.id.buttonPlay3){
        	play(R.raw.c);
        }else if(id == R.id.buttonPlay4){
        	play(R.raw.d);
        }else if(id == R.id.buttonStop){
        stop();
        }else{
        //do nothing
        }
    }

    
    //Play music
    public void play(int resourceID){
        c = getApplicationContext();
        try {
            stop();
            m = MediaPlayer.create(c, resourceID);
            m.setLooping(true);
            m.start();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    //Stop music play
    public void stop()
    {
        try {
            if(m != null)
            {
                m.stop();
                m.release();
                m = null;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
