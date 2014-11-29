
package com.brast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class GestionDate {

    public static void sop(String msg) {

	System.out.println(msg);
    }

    /**
     * Méthode permettant de récupérer la date système et de la convertir en String au
     * format courrant 'dd/MM/yyyy'.
     * 
     * @return Date système au format 'dd/MM/yyyy' sous la forme d'une String.
     */
    public static String getDateJour() {

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// sdf.setLenient(false);

	return sdf.format(date);
    }

    /**
     * Retourne la date du jour au format JJMMAAAA
     * 
     * @return Date système au format 'JJMMAAAA' sous la forme d'une String.
     */
    public static String getDateJourJJMMAAAA() {

	StringBuffer sb = new StringBuffer("");

	GregorianCalendar gc = new GregorianCalendar();

	String jour = String.valueOf(gc.get(Calendar.DAY_OF_MONTH));
	String mois = String.valueOf(gc.get(Calendar.MONTH) + 1);

	if ((gc.get(Calendar.DAY_OF_MONTH)) < 10) jour = "0" + jour;

	if ((gc.get(Calendar.MONTH) + 1) < 10) mois = "0" + mois;

	sb.append(jour);
	sb.append(mois);
	sb.append(gc.get(Calendar.YEAR));

	return sb.toString();
    }

    public static String formateUneDate(Date madate, String format)
	    throws ParseException {

	SimpleDateFormat sdf = new SimpleDateFormat(format);
	// sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

	sdf.setLenient(false);

	return sdf.format(madate);
    }

    public static Date stringToDate(String theDate, String theFormat)
	    throws ParseException {

	if (theDate == null) {
	    return null;
	}
	SimpleDateFormat sdf = new SimpleDateFormat(theFormat);
	sdf.setLenient(false);

	Date maDate = sdf.parse(theDate);

	return maDate;
    }

    public static Date stringToDate2(String theDate, String theFormat)
	    throws ParseException {

	if (theDate == null) {
	    return null;
	}

	Calendar cal = new GregorianCalendar();

	SimpleDateFormat sdf = new SimpleDateFormat(theFormat);
	sdf.setLenient(false);

	cal.setTime(sdf.parse(theDate));

	Date maDate = cal.getTime();

	return maDate;
    }

    public static Date dateDuJour() {

	return Calendar.getInstance().getTime();
    }

    public static Date customDate(int jour, int mois, int annee) {

	Calendar cal = Calendar.getInstance();

	// Attention le mois de janvier commence à zéro : date : 31 janvier 2012
	// cal.set(2012, 0, 31);
	cal.set(annee, mois - 1, jour);

	return cal.getTime();
    }

    public static Date addJoursToDate(Date date, int nbjour) {

	GregorianCalendar gc = new GregorianCalendar();
	gc.setTime(date);
	gc.add(Calendar.DATE, nbjour);
	return gc.getTime();
    }

    public static Date addMoisToDate(Date date, int nbmois) {

	GregorianCalendar gc = new GregorianCalendar();
	gc.setTime(date);
	gc.add(Calendar.MONTH, nbmois);
	return gc.getTime();
    }

    public static Date addAnneesToDate(Date date, int nbans) {

	GregorianCalendar gc = new GregorianCalendar();
	gc.setTime(date);
	gc.add(Calendar.YEAR, nbans);
	return gc.getTime();
    }

    public static Date addJoursToDateString(String sdate, int nbjour)
	    throws ParseException {

	java.util.Date date1 = stringToDate(sdate, "ddMMyyyy");
	sop("Date 1 = " + date1);

	GregorianCalendar gc = new GregorianCalendar();
	gc.setTime(date1);
	gc.add(Calendar.DATE, nbjour);
	return gc.getTime();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	// TODO Auto-generated method stub

	Date todayDate = new Date();
	sop("todayDate new Date(): " + todayDate);
	sop("");

	todayDate = dateDuJour();
	sop("todayDate dateDuJour(): " + todayDate);
	sop("");

	try {
	    sop("todayDate \"EEEE, d MMM yyyy HH:mm:ss\": "
		    + formateUneDate(todayDate, "EEEE, d MMM yyyy HH:mm:ss"));

	    sop("todayDate \"yyyy-MM-dd HH:mm:ss S\": "
		    + formateUneDate(todayDate, "yyyy-MM-dd HH:mm:ss S"));

	    sop("todayDate \"dd/MM/yyyy HH:mm:ss S\": "
		    + formateUneDate(todayDate, "dd/MM/yyyy HH:mm:ss S"));

	    sop("todayDate \"yyyy-MM-dd'T'HH:mm:ss'Z'\": "
		    + formateUneDate(todayDate, "yyyy-MM-dd'T'HH:mm:ss'Z'"));

	    sop("todayDate \"ddMMyyyy\": "
		    + formateUneDate(todayDate, "ddMMyyyy"));

	}
	catch (ParseException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	sop("");

	String myStringDate = DateFormat.getDateInstance().format(todayDate);
	sop("myStringDate : " + myStringDate);
	sop("");

	DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,
	        Locale.FRANCE);

	String myStringDate2 = df.format(todayDate);
	sop("myStringDate2 (DateFormat.LONG): " + myStringDate2);
	sop("");

	df = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);

	myStringDate2 = df.format(todayDate);
	sop("myStringDate2 (DateFormat.FULL): " + myStringDate2);
	sop("");

	String myStringTime = DateFormat.getTimeInstance().format(todayDate);
	sop("myStringTime : " + myStringTime);
	sop("");

	// Affichage de la date du jour

	// Retourne la date du jour au format dd/MM/yyyy
	sop("Date du jour au format dd/MM/yyyy : " + getDateJour());
	String strDatejour = getDateJour();

	// Conversion d'une chaine dans un format reconnu en format Date
	try {
	    Date maDate = stringToDate(strDatejour, "dd/MM/yyyy");
	    sop("stringToDate - maDate : " + maDate);

	}
	catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	sop("");

	// Conversion d'une chaine dans un format reconnue en format Date
	try {
	    String strDate = "26/06/1965";

	    Date maDate = stringToDate2(strDate, "dd/MM/yyyy");
	    sop("strDate : " + strDate);
	    sop("stringToDate2 - maDate : " + maDate);

	}
	catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	sop("");

	try {
	    String strDate = "1965-06-26";

	    Date maDate = stringToDate2(strDate, "y-M-d");
	    sop("strDate : " + strDate);
	    sop("stringToDate2 - maDate : " + maDate);

	}
	catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	sop("");

	try {
	    String strDate = "32/06/1965";

	    Date maDate = stringToDate2(strDate, "dd/MM/yyyy");
	    sop("strDate : " + strDate);
	    sop("stringToDate2 - maDate : " + maDate);

	}
	catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	sop("");

	Date customDate = customDate(31, 1, 2014);
	sop("customDate : " + customDate);
	sop("");

	Date customDate2 = customDate(32, 1, 2014);
	// customDate2 : Sat Feb 01 11:46:54 CET 2014
	sop("customDate2 : " + customDate2);

	// Ajoute un nombre de jour...
	sop("");

	Date maDate = customDate(27, 2, 2013);

	Date maNewDate4J = addJoursToDate(maDate, 4);
	Date maNewDatemoins5J = addJoursToDate(maDate, -5);

	Date maNewDate3M = addMoisToDate(maDate, 3);
	Date maNewDatemoins4M = addMoisToDate(maDate, -4);

	Date maNewDate2A = addAnneesToDate(maDate, 2);
	Date maNewDatemoins3A = addAnneesToDate(maDate, -3);

	try {
	    sop("maDate           : " + formateUneDate(maDate, "dd/MM/yyyy"));
	    sop("");

	    sop("maDate + 4 jours : "
		    + formateUneDate(maNewDate4J, "dd/MM/yyyy"));

	    sop("maDate - 5 jours : "
		    + formateUneDate(maNewDatemoins5J, "dd/MM/yyyy"));

	    sop("");
	    sop("maDate + 3 mois : "
		    + formateUneDate(maNewDate3M, "dd/MM/yyyy"));
	    sop("maDate - 4 mois : "
		    + formateUneDate(maNewDatemoins4M, "dd/MM/yyyy"));
	    sop("");
	    sop("maDate + 2 ans  : "
		    + formateUneDate(maNewDate2A, "dd/MM/yyyy"));
	    sop("maDate - 3 ans  : "
		    + formateUneDate(maNewDatemoins3A, "dd/MM/yyyy"));

	}
	catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	sop("");

    }

}
