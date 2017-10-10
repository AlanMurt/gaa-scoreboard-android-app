package me.example.alansproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	int counter;
	int noTimer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //START of red/green timer button for page 1
        counter = 1;
        final Button timerButton = (Button) findViewById(R.id.timerButton);
        timerButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (counter % 2 !=0) {
					timerButton.setBackgroundColor(Color.RED);
					counter++;
					
					//START of code for timer on or off depending on color of timerButton
//					Intent i = new Intent(MainActivity.this, StartMatch.class);
//					i.putExtra("No Timer", noTimer=1);
//					startActivity(i);
					//END timerButton
				}
				else{
					timerButton.setBackgroundColor(Color.GREEN);
					counter++;
					
					//START of code for timer on or off depending on color of timerButton
//					Intent i = new Intent(MainActivity.this, StartMatch.class);
//					i.putExtra("No Timer", noTimer=0);
//					startActivity(i);
					//END timerButton
					
				}
				
			}
			//END of red/green timer button for page 1
			
			
			
			
			
			
		});
        
        //START to Change to StartMatchActivity
			final Button continueButtonn = (Button) findViewById(R.id.continueButton);
			continueButtonn.setOnClickListener(new OnClickListener() {
				
				
				
				@Override
				public void onClick(View v) {
					EditText setTeamA = (EditText) findViewById(R.id.setTeamA);
					EditText setTeamB = (EditText) findViewById(R.id.setTeamB);
					
					String TeamA = setTeamA.getText().toString();
					String TeamB = setTeamB.getText().toString();
					
					Intent i = new Intent(MainActivity.this, StartMatch.class);
					i.putExtra("TeamA", TeamA);
					i.putExtra("TeamB", TeamB);
					startActivity(i);
					
				}
			});
			
			//END to Change to StartMatchActivity
			
			
			final TextView setTeamB = (TextView) findViewById(R.id.setTeamB);
			final TextView setHomeTeam = (TextView) findViewById(R.id.setHomeTeam);
			
			//START when setting team name after click the text goes blank
			
			//END text box goes blank after click
			

			
			    
        
    }
    
    public void openSettings(){
		startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
	}
		
	@Override

	 public boolean onOptionsItemSelected(MenuItem item) {

	 // Handle action bar item clicks here. The action bar will

	 // automatically handle clicks on the Home/Up button, so long

	 // as you specify a parent activity in AndroidManifest.xml.

	 switch (item.getItemId()) {

	 case R.id.action_settings:

	openSettings();

	return true;

	 default:

	 return super.onOptionsItemSelected(item);

	}

	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  
    }


