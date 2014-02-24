package edu.mit.menyou;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayFavorites extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_favorites);
		
        TextView txtFood = (TextView) findViewById(R.id.df_textView1);
        Button df_button = (Button) findViewById(R.id.df_button);
 
        Intent i = getIntent();
        // Receiving the Data
        //String food = i.getStringExtra("food");
        //Log.e("Second Screen", food);
 
        // Displaying Received data
        //txtFood.setText("Your favorite food is "+food+" ?? That's so weird!");
 
        // Binding Click event to Button
        df_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Closing this Activity
                finish();
            }
        });
 
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_favorites, menu);
		return true;
	}

}