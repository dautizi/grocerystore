package com.grocerystore.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DateUtil {

    private static final Logger logger = Logger.getLogger(DateUtil.class);

    public static String DATE_PATTERN = "dd/MM/yyyy";
    public static String DATE_PATTERN_EN = "MM/dd/yyyy";
    public static String DATE_TIME_PATTERN_SS = "dd/MM/yyyy HH:mm:ss";
    public static String DATE_TIME_PATTERN_W = "dd/MM/yyyy HH:mm";

    public static String DATE_TIME_PATTERN_EN_SS = "MM/dd/yyyy HH:mm:ss";
    public static String DATE_TIME_PATTERN_EN_MM = "MM/dd/yyyy HH:mm";
    public static String DATE_TIME_PATTERN_EN_DAY = "MM/dd/yyyy";

    public static String DATE_DB_PATTERN = "yyyyMMdd";
    public static String DATE_TIME_DB_PATTERN = "yyyyMMdd HH:mm:ss";

    public static String TIME_PATTERN = "HH:mm:ss";
    public static String TIME_PATTERN_HH_MM = "HH:mm";
    public static String DATE_TIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    public static String DATE_ALL_PATTERN  = "EEE MMM dd HH:mm:ss ZZ yyyy";
    public static String DATE_CET_PATTERN  = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static String DATE_PATTERN_MYSQL    = "yyyy-MM-dd";

    public static String DATE_PATTERN_M        = "yyyyMddHHmmss";
    public static String DATE_PATTERN_M_FORMAT = "yyyyMMddHHmmss";

    public static String MYSQL_DB_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String MYSQL_DB_DATE_PATTERN_DAY = "yyyy-MM-dd";

    public static String CALENDAR_DB_DATE_PATTERN = "yyyy-MM-dd HH:mm";

    public DateUtil() {}

    public static long getMillisFromString(String pattern, String date) {
        long millis = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date d = sdf.parse(date);
            millis = d.getTime();
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Failure in getting millis by date ["+date+"], with pattern ["+pattern+"]");
        }
        return millis;
    }

    public static String convertDateStringFormat(String viewFormattedDate, String outgoingPattern){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outgoingPattern);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(DATE_PATTERN,viewFormattedDate));
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+viewFormattedDate+"]. Il formato atteso e' gg/mm/aaaa");
        }
        return formattedDate;
    }

    public static String convertDateStringFormat(String date, String inPattern, String outPattern){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outPattern);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(inPattern,date));
        } catch (ParseException e) {
            logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+date+"]. Il formato atteso e' "+inPattern);
        }
        return formattedDate;
    }

    public static String convertDateStringFormat(String date, String inPattern, String outPattern, Locale local){
        String formattedDate = null;
        SimpleDateFormat outgoingDateFormat = new SimpleDateFormat(outPattern,local);
        try {
            formattedDate = outgoingDateFormat.format(convertStringToDate(inPattern,date,local));
        } catch (ParseException e) {
        logger.error(e);
            throw new RuntimeException("Formato inatteso della data ["+date+"]. Il formato atteso e' "+inPattern);
        }
        return formattedDate;
    }

    public static Calendar convertStringToCalendar(String strDate,
        String pattern) {
        Calendar c = null;

        try {
            Date d = convertStringToDate(pattern, strDate);
            c = new GregorianCalendar();
            c.setTime(d);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return c;
    }

    /**
     * This method converts a String to a timestamp using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     *
     * @throws ParseException
     */
    public static Timestamp convertStringToTimestamp(String strTs,
        String pattern) throws ParseException {
        Timestamp t = null;

        try {
            t = new Timestamp(convertStringToDate(pattern, strTs).getTime());
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return t;
    }


    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
        throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method generates a string representation of a date
     * in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        if (aDate != null) {
            return getDateTime(DATE_PATTERN, aDate);
        } else {
            return "";
        }
    }

    public static final String convertDateToString(Date aDate, String pattern) {
        return getDateTime(pattern, aDate);
    }

    public static final String convertTimestampToString(Timestamp aTimestamp,
        String pattern) {
        if (aTimestamp != null) {
            return convertDateToString(new Date(aTimestamp.getTime()), pattern);
        } else {
            return "";
        }
    }

    public static final String convertTimestampToString(Timestamp aTimestamp) {
        if (aTimestamp != null) {
            return convertDateToString(new Date(aTimestamp.getTime()));
        } else {
            return "";
        }
    }

    public static final String convertCalendarToString(Calendar c,
        String pattern) {
        if (c != null) {
            return convertDateToString(c.getTime(), pattern);
        } else {
            return "";
        }
    }

    public static final String convertCalendarToString(Calendar c) {
        if (c != null) {
            return convertDateToString(c.getTime());
        } else {
            return "";
        }
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     *
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }
    
    
    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param date a date dd/MM/yyyy
     * @return Date representation of the date
     *
     * @see java.text.SimpleDateFormat
     */
    public static final Date convertStringToDate(String date) {
        
        try {
            //TODO: da testare prima di eliminare il new Date(...) deprecato
//            GregorianCalendar a = new GregorianCalendar();
//            a.set(Calendar.YEAR, Integer.parseInt(date.substring(6))-1900);
//            a.set(Calendar.MONTH, Integer.parseInt(date.substring(3,5))-1);
//            a.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(0,2)));
//            return a.getTime();
            return new Date(Integer.parseInt(date.substring(6))-1900, Integer.parseInt(date.substring(3,5))-1, Integer.parseInt(date.substring(0,2)) );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        
    }
    
    
    // FUNZIONE PER LA CONVERSIONE DELLA DATA dal formato from al formato to
    public static String formatDate(String date, String fromPattern, String toPattern)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(fromPattern);
            Date d = sdf.parse(date);
            sdf = new SimpleDateFormat(toPattern);
            return sdf.format(d);
        }
        catch(Exception e)
        {
            return "";
        }
    }
    
    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate,Locale local)
        throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask,local);

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }
    
    
    
    public static String formatBaseDate(Date date, String format) {
        String output = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // System.out.println(dateFormat.format(dateFormat.parse("31/05/2011")));
        try {
            output = dateFormat.format(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return output;
    }
    
    
    public static Integer getDaysInMonth(Calendar date, Integer year, Integer month) {
        Integer days = 0;
        if (null != date) {
            // Get the number of days in that month
            days = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        } else {
            // Create a calendar object and set year and moth
            Calendar mycal = new GregorianCalendar(year, month, 1);
            // Get the number of days in that month
            days = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        return days;
    }
    
    
    public static Integer getDayOfWeek(String date) {
        Integer day = null;
        if (!StringUtils.isEmpty(date)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                day = cal.get(Calendar.DAY_OF_WEEK);
            } catch (ParseException e) {
                logger.error("Errore durante la cattura del giorno relativo alla settimana ");
                e.printStackTrace();
            }
        }
        return day;
    }
    
    public static Integer getMonth(String date) {
        Integer month = 0;
        if (!StringUtils.isEmpty(date)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                // Get the number of days in that month
                month = cal.MONTH;
            } catch (ParseException e) {
                logger.error("Errore durante la cattura del mese ");
                e.printStackTrace();
            }
        }
        return month;
    }
    
    public static HashMap<String, Integer> getMonthYearOfDate(String date) {
        HashMap<String, Integer> monthYearMap = null;
        Integer daysOfMonth = 0;
        Integer month = 0;
        Integer year = 0;
        if (!StringUtils.isEmpty(date)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                monthYearMap = new HashMap<String, Integer>();
                cal.setTime(sdf.parse(date));
                daysOfMonth = cal.DAY_OF_MONTH;
                monthYearMap.put("giorni", daysOfMonth);
                month = cal.MONTH;
                monthYearMap.put("mese", month);
                year = cal.YEAR;
                monthYearMap.put("year", year);
            } catch (ParseException e) {
                logger.error("Errore durante la cattura mese/anno ");
                e.printStackTrace();
            }
        }
        return monthYearMap;
    }
    
    public static Calendar getCalendarFromDate(String date) {
        Calendar cal = null;
        if (!StringUtils.isEmpty(date)) {
            cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
            } catch(Exception ex) {
                logger.error("Errore durante il parsing da String a Calendar: "+ex);
            }
        }
        return cal;
    }
    
    public static Calendar getCalendarFirstDayOfMonth(String date) {
        Calendar cal = null;
        if (!StringUtils.isEmpty(date)) {
            cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
            } catch(Exception ex) {
                logger.error("Errore durante il parsing da String a Calendar: "+ex);
            }
        }
        return cal;
    }
    
    public static Calendar getCalendarLastDayOfMonth(String date) {
        Calendar cal = null;
        if (!StringUtils.isEmpty(date)) {
            cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            } catch(Exception ex) {
                logger.error("Errore durante il parsing da String a Calendar: "+ex);
            }
        }
        return cal;
    }
    
    public static String getFirstDayOfMonth(String date) {
        String result = null;
        if (!StringUtils.isEmpty(date)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
                result = sdf.format(cal.getTime());
            } catch(Exception ex) {
                logger.error("Errore durante il parsing da String a Calendar: "+ex);
            }
        }
        return result;
    }
    
    public static String getLastDayOfMonth(String date) {
        String result = null;
        if (!StringUtils.isEmpty(date)) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_MYSQL);
            try {
                cal.setTime(sdf.parse(date));
                cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                result = sdf.format(cal.getTime());
            } catch(Exception ex) {
                logger.error("Errore durante il parsing da String a Calendar: "+ex);
            }
        }
        return result;
    }
    
    
    
    public static void main(String[] args) {
        /*
        Map<Integer, Orario> oreCategorizzate = new HashMap<Integer, Orario>();
        Orario orario1 = new Orario();
        orario1.setInizio("08:00");
        orario1.setFine("09:00");
        orario1.setOra(1);
        oreCategorizzate.put(800, orario1);
        
        Orario orario2 = new Orario();
        orario2.setInizio("09:00");
        orario2.setFine("10:00");
        orario2.setOra(2);
        oreCategorizzate.put(900, orario2);
        
        Orario orario3 = new Orario();
        orario3.setInizio("10:00");
        orario3.setFine("11:00");
        orario3.setOra(3);
        oreCategorizzate.put(1000, orario3);
        
        Orario orario4 = new Orario();
        orario4.setInizio("11:00");
        orario4.setFine("12:00");
        orario4.setOra(4);
        oreCategorizzate.put(1100, orario4);
        
        Orario orario5 = new Orario();
        orario5.setInizio("12:00");
        orario5.setFine("13:00");
        orario5.setOra(5);
        oreCategorizzate.put(1200, orario5);
        
        Orario orario6 = new Orario();
        orario6.setInizio("13:00");
        orario6.setFine("14:00");
        orario6.setOra(6);
        oreCategorizzate.put(1300, orario6);
        
        Orario orario7 = new Orario();
        orario7.setInizio("14:00");
        orario7.setFine("15:00");
        orario7.setOra(7);
        oreCategorizzate.put(1400, orario7);
        
        Orario orario8 = new Orario();
        orario8.setInizio("15:00");
        orario8.setFine("16:00");
        orario8.setOra(8);
        oreCategorizzate.put(1500, orario8);
        
        String dataOraInizio = "22/12/2012 12:00:00";
        String dataOraFine = "22/12/2012 14:00:00";
        // dataOraFine = "17/12/2012 12:00:00","17/12/2012 13:00:00"
        
        logger.info(" ### Main [START] ###");
        
        List<Orario> lista = splitOrariInOre(dataOraInizio, dataOraFine, oreCategorizzate);
        logger.info("Lista ore: "+lista.size());
        for(int i=0; i<lista.size(); i++) {
            Orario orarioI = lista.get(i);
            logger.info("_Orario detail_ start");
            logger.info("Inizio: "+orarioI.getInizio());
            logger.info("Ora: "+orarioI.getOra());
            logger.info("Fine: "+orarioI.getFine());
            logger.info("_Orario detail_ end");
        }
        */

        Calendar cal = getCalendarFirstDayOfMonth("2013-03-23");
        Date date = cal.getTime();
        logger.info("Data: "+date.toString());
        
        logger.info(" ### Main [END] ###");
    }

}
