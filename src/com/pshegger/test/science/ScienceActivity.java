package com.pshegger.test.science;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ScienceActivity extends Activity {
	public static final int MENU_NEW_RULES = 0;
	public static final int MENU_HISTORY = MENU_NEW_RULES + 1;
	
	private RadioGroup szin, szam, forma, kitoltes;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				check();
			}
		});
        
        this.szin = (RadioGroup) findViewById(R.id.szin);
        this.szam = (RadioGroup) findViewById(R.id.szam);
        this.forma = (RadioGroup) findViewById(R.id.forma);
        this.kitoltes = (RadioGroup) findViewById(R.id.kitoltes);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_NEW_RULES, 0, "Új szabályok");
		menu.add(0, MENU_HISTORY, 0, "Előzmények");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_NEW_RULES:
			reset();
			return true;
		case MENU_HISTORY:
			showHistory();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showHistory() {
		
	}

	private void reset() {
		
	}

	private void check() {
		
	}
}