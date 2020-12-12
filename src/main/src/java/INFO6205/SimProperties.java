package INFO6205;

import INFO6205.Place.Place;


public class SimProperties {
	public static double k_factor=0.2;
	public static double r_factor=0.6;
	public static boolean flag123 = true;
	public static boolean showGUI = true;
	public static int exposetime = 500;
	public static double fatality = 0.1;
	public static double probTogetSym =0.4;
	public static double infect = 0.5;
	public static double sprange = 3.0;
	public static Place flag15 =null;
	public static boolean contactTrace = false;
	public static Boolean start12 = false;
	public static boolean lockdownplace1 = false;
	public static int infection = 1500;
	public static String typeOfVirus = "SARS-CoV";
	public static Boolean socialDistance = false;
	public static boolean mask = false;
	public static boolean lockdownOnT = false;
	public static int quartime = 1500;
	public SimProperties()  {
		flag123 = false;
		if (typeOfVirus.equals("SARS-CoV")) {
			infection =1500;
			quartime = infection;
			exposetime = 500;
			probTogetSym = 0.4;
			fatality = 1.15;
			sprange =4;
			infect =1.5;
		}
		else if (typeOfVirus.equals("SARS-CoV-2")){
			infection = 2000;
			quartime = infection;
			exposetime = 600;
			probTogetSym = 0.4;
			fatality = 1.05;
			sprange =3;//r
			infect =1.7;//k
		}

	}}
