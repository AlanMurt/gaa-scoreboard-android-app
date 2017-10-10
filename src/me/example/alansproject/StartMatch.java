package me.example.alansproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class StartMatch extends Activity {

	private Chronometer chronometer;
	int aGoal = 0;
	int aPoint = 0;
	int bGoal = 0;
	int bPoint = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_match);
		
		
		Intent i= getIntent();
		Bundle b = i.getExtras();
		TextView TeamAName = (TextView) findViewById(R.id.getTeamA);
		TextView TeamBName = (TextView) findViewById(R.id.getTeamB);
		final TextView getTeamAAgain = (TextView) findViewById(R.id.getTeamAAgain);
		final TextView getTeamBAgain = (TextView) findViewById(R.id.getTeamBAgain);
		if(b!=null)
		{
			String teamA = b.getString("TeamA");
			TeamAName.setText(teamA);
			
			String teamB = b.getString("TeamB");
			TeamBName.setText(teamB);
			
			getTeamAAgain.setText(teamA);
			getTeamBAgain.setText(teamB);
			
			
			//START of code for timer on or off depending on color of timerButton
			int yesNoTimer = b.getInt("No Timer");
			if(yesNoTimer==1){
				chronometer.setVisibility(View.GONE);
			//END timerButton	
			}
			
		}
		
		

		final TextView getTeamAGoals = (TextView) findViewById(R.id.getTeamAGoals);
		final TextView getTeamBGoals = (TextView) findViewById(R.id.getTeamBGoals);
		final TextView getTeamAPoints = (TextView) findViewById(R.id.getTeamAPoints);
		final TextView getTeamBPoints = (TextView) findViewById(R.id.getTeamBPoints);
		final TextView teamAScoreDash = (TextView) findViewById(R.id.teamAScoreDash);
		final TextView teamBScoreDash = (TextView) findViewById(R.id.teamBScoreDash);
		
		

		//START of startMatchButton going invisible when clicked 
		final Button startMatchButton = (Button) findViewById(R.id.startMatchButton);
		final Button halfTimeButton = (Button) findViewById(R.id.halfTimeButton);
				final Button endGameButton = (Button) findViewById(R.id.endGameButton);

		startMatchButton.setOnClickListener(new OnClickListener() {

			
			

			@Override				
			public void onClick(View v) {

				startMatchButton.setVisibility(View.GONE);

				if(halfTimeButton.getText().equals("End Game")){

					

					//START teams and scores become visible 
					getTeamAAgain.setVisibility(View.VISIBLE);
					getTeamBAgain.setVisibility(View.VISIBLE);
					getTeamAGoals.setVisibility(View.VISIBLE);
					getTeamBGoals.setVisibility(View.VISIBLE);
					getTeamAPoints.setVisibility(View.VISIBLE);
					getTeamBPoints.setVisibility(View.VISIBLE);
					teamAScoreDash.setVisibility(View.VISIBLE);
					teamBScoreDash.setVisibility(View.VISIBLE);
					//END teams and scores become visible

					chronometer.setVisibility(View.GONE);
				}
				else{


					startMatchButton.setText("Start second half");

					//START chronometer 

					chronometer = (Chronometer) findViewById(R.id.chronometer);
					chronometer.setBase(SystemClock.elapsedRealtime());
					chronometer.start();
					//END chronometer setup

					//START teams and scores become visible 
					getTeamAAgain.setVisibility(View.VISIBLE);
					getTeamBAgain.setVisibility(View.VISIBLE);
					getTeamAGoals.setVisibility(View.VISIBLE);
					getTeamBGoals.setVisibility(View.VISIBLE);
					getTeamAPoints.setVisibility(View.VISIBLE);
					getTeamBPoints.setVisibility(View.VISIBLE);
					teamAScoreDash.setVisibility(View.VISIBLE);
					teamBScoreDash.setVisibility(View.VISIBLE);
					//END teams and scores become visible
				}
			}

		});

		//END of startMatchButton going invisible


		//START when half time button is selected 

		halfTimeButton.setOnClickListener(new OnClickListener() {

			TextView getTeamAAgain = (TextView) findViewById(R.id.getTeamAAgain);
			TextView getTeamBAgain = (TextView) findViewById(R.id.getTeamBAgain);
			TextView getTeamAGoals = (TextView) findViewById(R.id.getTeamAGoals);
			TextView getTeamBGoals = (TextView) findViewById(R.id.getTeamBGoals);
			TextView getTeamAPoints = (TextView) findViewById(R.id.getTeamAPoints);
			TextView getTeamBPoints = (TextView) findViewById(R.id.getTeamBPoints);
			TextView teamAScoreDash = (TextView) findViewById(R.id.teamAScoreDash);
			TextView teamBScoreDash = (TextView) findViewById(R.id.teamBScoreDash);
			
			@Override
			public void onClick(View v) {

				if(halfTimeButton.getText().equals("Half Time")){
					getTeamAAgain.setVisibility(View.GONE);
					getTeamBAgain.setVisibility(View.GONE);
					getTeamAGoals.setVisibility(View.GONE);
					getTeamBGoals.setVisibility(View.GONE);
					getTeamAPoints.setVisibility(View.GONE);
					getTeamBPoints.setVisibility(View.GONE);
					teamAScoreDash.setVisibility(View.GONE);
					teamBScoreDash.setVisibility(View.GONE);

					//chronometer stops here
					chronometer.stop();


					startMatchButton.setVisibility(View.VISIBLE); 
				}
				else{
					chronometer.setVisibility(View.GONE);
					startMatchButton.setVisibility(View.INVISIBLE); 
				}

				if(halfTimeButton.getText().equals("End Game")){
					 endGameButton.setVisibility(View.VISIBLE);
					halfTimeButton.setVisibility(View.GONE);
				}



				if(halfTimeButton.getText().equals("Half Time")){
					halfTimeButton.setText("Full Time");
				}
				else{
					halfTimeButton.setVisibility(View.GONE);
					endGameButton.setVisibility(View.VISIBLE);
				}

			}
		});

		//END when half time button is selected

		//START when end game button is selected
		endGameButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(StartMatch.this, MainActivity.class);
				startActivity(i);

			}
		});

		//END end game button

		Button teamAGoalButton = (Button) findViewById(R.id.teamAGoalButton);
		Button teamAPointButton = (Button) findViewById(R.id.teamAPointButton);
		Button teamAMinusGoalButton = (Button) findViewById(R.id.teamAMinusGoalButton);
		Button teamAMinusPointButton = (Button) findViewById(R.id.teamAMinusPointButton);
		Button teamBGoalButton = (Button) findViewById(R.id.teamBGoalButton);
		Button teamBPointButton = (Button) findViewById(R.id.teamBPointButton);
		Button teamBMinusGoalButton = (Button) findViewById(R.id.teamBMinusGoalButton);
		Button teamBMinusPointButton = (Button) findViewById(R.id.teamBMinusPointButton);
		
		//START goal for teamA
		teamAGoalButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				aGoal++;
				String goalScored = Integer.toString(aGoal);
				getTeamAGoals.setText(goalScored);
			}
		});
		//END Goal for team A
		
		//START point for teamA
		teamAPointButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				aPoint++;
				String pointScored = Integer.toString(aPoint);
				getTeamAPoints.setText(pointScored);
			}
		});
		//END Point for team A
		
		//START goal for teamB
				teamBGoalButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						bGoal++;
						String goalScored = Integer.toString(bGoal);
						getTeamBGoals.setText(goalScored);
					}
				});
				//END Goal for team B
				
				//START point for teamB
				teamBPointButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						bPoint++;
						String pointScored = Integer.toString(bPoint);
						getTeamBPoints.setText(pointScored);
					}
				});
				//END Point for team B
				
				//START minus goal for teamA
				teamAMinusGoalButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						aGoal--;
						String noGoal = Integer.toString(aGoal);
						getTeamAGoals.setText(noGoal);
					}
				});
				//END minus Goal for team A
				
				//START minus goal for teamB
				teamBMinusGoalButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						bGoal--;
						String noGoal = Integer.toString(bGoal);
						getTeamBGoals.setText(noGoal);
					}
				});
				//END minus Goal for teamB
				
				//START minus point for teamA
				teamAMinusPointButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						aPoint--;
						String noPoint = Integer.toString(aPoint);
						getTeamAPoints.setText(noPoint);
					}
				});
				//END minus point for team A
				
				//START minus point for teamB
				teamBMinusPointButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						bPoint--;
						String noPoint = Integer.toString(bPoint);
						getTeamBPoints.setText(noPoint);
					}
				});
				//END minus point for team B

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
		getMenuInflater().inflate(R.menu.start_match, menu);
		return true;
	}






}

