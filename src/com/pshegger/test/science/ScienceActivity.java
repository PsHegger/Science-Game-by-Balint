package com.pshegger.test.science;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ScienceActivity extends Activity {
	public static final int MENU_NEW_RULES = 0;
	public static final int MENU_HISTORY = MENU_NEW_RULES + 1;
	
	private Rule[] rules;
	private RadioGroup szinGrp, szamGrp, formaGrp, kitoltesGrp;
	
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
        
        this.szinGrp = (RadioGroup) findViewById(R.id.szin);
        this.szamGrp = (RadioGroup) findViewById(R.id.szam);
        this.formaGrp = (RadioGroup) findViewById(R.id.forma);
        this.kitoltesGrp = (RadioGroup) findViewById(R.id.kitoltes);
        
        reset();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_NEW_RULES, 0, "Új szabályok");
		// menu.add(0, MENU_HISTORY, 0, "Előzmények");
		
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
		this.rules = new Rule[4];
		
		this.rules[0] = new Rule(true);
		
		boolean conflict = false;
		do {
			this.rules[1] = new Rule(false);
			conflict = this.rules[1].conflict(this.rules[0]);
		} while(conflict);
		do {
			this.rules[2] = new Rule(false);
			if (this.rules[2].conflict(this.rules[0])) break;
			conflict = this.rules[2].conflict(this.rules[1]);
		} while(conflict);
		do {
			this.rules[3] = new Rule(false);
			if (this.rules[3].conflict(this.rules[0])) break;
			if (this.rules[3].conflict(this.rules[1])) break;
			conflict = this.rules[3].conflict(this.rules[2]);
		} while(conflict);
		
		Log.d("Science", this.rules[0].toString());
		Log.d("Science", this.rules[1].toString());
		Log.d("Science", this.rules[2].toString());
		Log.d("Science", this.rules[3].toString());
	}

	private void check() {
		boolean bang = false;
		int szin = Constants.RULE_BARMI;
		int szam = Constants.RULE_BARMI;
		int forma = Constants.RULE_BARMI;
		int kitoltes = Constants.RULE_BARMI;
		
		switch (this.szinGrp.getCheckedRadioButtonId()) {
		case R.id.piros:
			szin = Constants.SZIN_PIROS;
			break;
		case R.id.kek:
			szin = Constants.SZIN_KEK;
			break;
		case R.id.zold:
			szin = Constants.SZIN_ZOLD;
			break;
		}
		
		switch (this.szamGrp.getCheckedRadioButtonId()) {
		case R.id.egy:
			szam = Constants.SZAM_EGY;
			break;
		case R.id.ketto:
			szam = Constants.SZAM_KETTO;
			break;
		case R.id.harom:
			szam = Constants.SZAM_HAROM;
			break;
		}
		
		switch (this.formaGrp.getCheckedRadioButtonId()) {
		case R.id.haromszog:
			forma = Constants.FORMA_HAROMSZOG;
			break;
		case R.id.negyzet:
			forma = Constants.FORMA_NEGYZET;
			break;
		case R.id.kor:
			forma = Constants.FORMA_KOR;
			break;
		}
		
		switch (this.kitoltesGrp.getCheckedRadioButtonId()) {
		case R.id.csikos:
			kitoltes = Constants.KITOLTES_CSIKOS;
			break;
		case R.id.pottyos:
			kitoltes = Constants.KITOLTES_POTTYOS;
			break;
		case R.id.ures:
			kitoltes = Constants.KITOLTES_URES;
			break;
		}
		
		Rule guess = new Rule(szin, szam, forma, kitoltes);
		
		for (int i = 0; i < this.rules.length; i++) {
			if (rules[i].check(guess))
				bang = true;
		}
		
		if (bang) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Felrobbant");
			AlertDialog alert = builder.create();
			alert.show();
		}else{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Stabill");
			AlertDialog alert = builder.create();
			alert.show();
		}
			
	}
}