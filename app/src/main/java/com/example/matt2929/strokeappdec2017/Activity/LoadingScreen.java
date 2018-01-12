package com.example.matt2929.strokeappdec2017.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.matt2929.strokeappdec2017.R;

import static com.example.matt2929.strokeappdec2017.Values.WorkoutData.progressCloud;
import static com.example.matt2929.strokeappdec2017.Values.WorkoutData.progressLocal;

public class LoadingScreen extends AppCompatActivity {
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading_screen);
		textView = (TextView) findViewById(R.id.progressText);

		final Handler handler = new Handler();
		handler.post(new Runnable() {
			@Override
			public void run() {
				Log.e("Prog", "" + progressLocal);
				if (progressLocal != 100f && progressCloud != 100f) {
					textView.setText("" + Math.round((progressLocal + progressCloud) / 2));
					handler.postDelayed(this, 100);
				} else {
					Intent intent = new Intent(getApplicationContext(), PostWorkoutReport.class);
					startActivity(intent);
				}
			}
		});

	}
}
