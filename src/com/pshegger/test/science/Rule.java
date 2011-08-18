package com.pshegger.test.science;

import java.util.Random;


public class Rule {
	private int[] rule = {Constants.RULE_BARMI, Constants.RULE_BARMI, Constants.RULE_BARMI, Constants.RULE_BARMI};
	public boolean main;
	
	public Rule(boolean main) {
		this.main = main;
		Random rand = new Random(System.currentTimeMillis());
		int ruleType = rand.nextInt(4);
		int value = rand.nextInt(3);
		
		this.rule[ruleType] = value;
		
		if (!this.main) {
			int ruleType2 = rand.nextInt(4);
			while (ruleType2 == ruleType)
				ruleType2 = rand.nextInt(4);
			value = rand.nextInt(3);
			this.rule[ruleType] = value;
		}
	}
	
	public Rule(int szin, int szam, int forma, int kitoltes) {
		this.rule[Constants.RULE_SZIN] = szin;
		this.rule[Constants.RULE_SZAM] = szam;
		this.rule[Constants.RULE_FORMA] = forma;
		this.rule[Constants.RULE_KITOLTES] = kitoltes;
	}
	
	public int[] getRule() {
		return this.rule;
	}
	
	public boolean check(Rule other) {
		return (other.toString().equalsIgnoreCase(toString()));
	}
	
	public boolean conflict(Rule other) {
		boolean conflict = false;
		int[] otherRule = other.getRule();
		
		if (other.main) {
			for (int i = 0; i < this.rule.length; i++)
				if (otherRule[i] == this.rule[i])
					conflict = true;
		}
		
		if (other.toString().equalsIgnoreCase(toString()))
			conflict = true;
		
		int[] same = {0, 0, 0, 0};
		int[] count = {0, 0, 0, 0};
		for (int i = 0; i < this.rule.length; i++) {
			if (this.rule[i] == otherRule[i] && this.rule[i] != Constants.RULE_BARMI)
				same[i]++;
			if (this.rule[i] != Constants.RULE_BARMI && otherRule[i] != Constants.RULE_BARMI)
				count[i]++;
		}
		boolean sameTwo = false;
		int i = 0;
		while (i < same.length || !sameTwo) {
			if (same[i] == 2) {
				sameTwo = true;
				break;
			}
			i++;
		}
		if (sameTwo) {
			for (int j = 0; j < count.length; j++) {
				if (count[j] == 2 && j != i)
					conflict = true;
			}
		}
		
		return conflict;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.rule[0]);
		builder.append(";");
		builder.append(this.rule[1]);
		builder.append(";");
		builder.append(this.rule[2]);
		builder.append(";");
		builder.append(this.rule[3]);
		
		return builder.toString();
	}
}
