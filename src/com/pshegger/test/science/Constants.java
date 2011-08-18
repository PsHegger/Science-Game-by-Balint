package com.pshegger.test.science;

public class Constants {
	public static int RULE_SZIN = 0;
	public static int SZIN_PIROS = 0;
	public static int SZIN_KEK = SZIN_PIROS + 1;
	public static int SZIN_ZOLD = SZIN_KEK + 1;
	
	public static int RULE_SZAM = RULE_SZIN + 1;
	public static int SZAM_EGY = 0;
	public static int SZAM_KETTO = SZAM_EGY + 1;
	public static int SZAM_HAROM = SZAM_KETTO + 1;
	
	public static int RULE_FORMA = RULE_SZAM + 1;
	public static int FORMA_KOR = 0;
	public static int FORMA_HAROMSZOG = FORMA_KOR + 1;
	public static int FORMA_NEGYZET = FORMA_HAROMSZOG + 1;
	
	public static int RULE_KITOLTES = RULE_FORMA + 1;
	public static int KITOLTES_URES = 0;
	public static int KITOLTES_CSIKOS = KITOLTES_URES + 1;
	public static int KITOLTES_POTTYOS = KITOLTES_CSIKOS + 1;
	
	public static int RULE_BARMI = -1;
}
