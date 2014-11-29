
package com.brast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class TestDate {

    /**
     * @param args
     */
    public static void main(String[] args) throws AssertionError,
	    ParseException {

	// TODO Auto-generated method stub

	final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");

	// java.util.Date judDate1 = new java.util.Date();
	java.util.Date judDate1 = null;

	System.out
	        .println("Nous testons le formatage de la date suivante 15 10 2012....");

	judDate1 = sdf_ddMMyyyy.parse("15/10/2012");

	System.out.println("judDate1 : " + judDate1);

	// transformation de judDate1 en date au format SQL
	java.sql.Date sqlDate1 = new java.sql.Date(judDate1.getTime());

	System.out.println("sqlDate1 : " + sqlDate1);

	System.out.println("sdf_ddMMyyyy.format(sqlDate1) : "
	        + sdf_ddMMyyyy.format(sqlDate1));

	System.out.println("sdf_yyyyMMdd.format(sqlDate1) : "
	        + sdf_yyyyMMdd.format(sqlDate1));

	System.out.println("");
	System.out.println("--------------------------------------------");
	System.out.println("");

	StringTokenizer s = new StringTokenizer("Ceci est un, petit, test");
	while (s.hasMoreTokens()) {
	    System.out.println(s.nextToken());
	}
	System.out.println("");

	s = new StringTokenizer("Ceci est un, petit, test", ",");
	while (s.hasMoreTokens()) {
	    System.out.println(s.nextToken());
	}

	System.out.println("");
	System.out.println("--------------------------------------------");
	System.out.println("");

	String[] lesMois = { "Janvier", "Février", "Mars", "Avril", "Mai",
	        "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre",
	        "Décembre" };
	String moisCourant = GestionDate.getDateJour().substring(3, 5);
	// ex : 01 ou 02 ...

	System.out.println("mois Courant :" + moisCourant);

	System.out.println("xxx : "
	        + lesMois[(Integer.valueOf(moisCourant).intValue()) - 1]);

	System.out.println("Date du jour au format JJMMAAAA : "
	        + GestionDate.getDateJourJJMMAAAA());
	
	System.out.println("Date du jour au format JJMMAAAA.substring(6) : "
	        + GestionDate.getDateJourJJMMAAAA().substring(6));
	
	System.out.println("Date du jour au format JJMMAAAA : "
	        + GestionDate.getDateJourJJMMAAAA().substring(
	                GestionDate.getDateJourJJMMAAAA().length() - 4));
	
	System.out.println("Date du jour au format JJMMAAAA : "
	        + GestionDate.getDateJourJJMMAAAA().substring(
	                GestionDate.getDateJourJJMMAAAA().length() - 4,
	                GestionDate.getDateJourJJMMAAAA().length()));

    }

}
