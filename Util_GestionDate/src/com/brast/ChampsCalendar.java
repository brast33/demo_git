
package com.brast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ChampsCalendar {

    Date aujourdhui;

    Calendar calendar = new GregorianCalendar();

    ChampsCalendar() {

	aujourdhui = new Date();
    }

    public void format() {

	calendar.setTime(aujourdhui);

	System.out.println("Date du jour : " + aujourdhui);
	System.out.println("");

	System.out.println("Jour du mois: "
	        + calendar.get(Calendar.DAY_OF_MONTH));

	System.out.println("Jour de l'année: "
	        + calendar.get(Calendar.DAY_OF_YEAR));

	System.out.println("Jour de la semaine: "
	        + calendar.get(Calendar.DAY_OF_WEEK));

	System.out.println("Année: " + calendar.get(Calendar.YEAR));
	
	System.out.println("Mois: " + calendar.get(Calendar.MONTH));
	
	System.out.println("Semaine de l'année: "
	        + calendar.get(Calendar.WEEK_OF_YEAR));

	System.out.println("Semaine du mois: "
	        + calendar.get(Calendar.WEEK_OF_MONTH));
	
	System.out.println("Date: " + calendar.get(Calendar.DATE));

	System.out.println("Jour de la semaine du mois: "
	        + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

	System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));

	System.out.println("Heure: " + calendar.get(Calendar.HOUR));

	System.out.println("Heure de la journée: "
	        + calendar.get(Calendar.HOUR_OF_DAY));

	System.out.println("Minute: " + calendar.get(Calendar.MINUTE));

	System.out.println("Seconde: " + calendar.get(Calendar.SECOND));

	System.out.println("MILLISECONDE: "
	        + calendar.get(Calendar.MILLISECOND));

	System.out.println("ZONE_OFFSET: "
	        + (calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
	System.out.println("DST_OFFSET: "
	        + (calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000)));
	System.out.println("ERA: " + calendar.get(Calendar.ERA));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

	// TODO Auto-generated method stub

	new ChampsCalendar().format();
    }
}
