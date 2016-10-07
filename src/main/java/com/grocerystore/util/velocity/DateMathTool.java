package com.grocerystore.util.velocity;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.velocity.tools.config.DefaultKey;

@DefaultKey("dateMathTool")
public class DateMathTool {

	public Date addDay(int amount){
		return DateUtils.addDays(new Date(), amount);
	}

	public Date addDay(Date date, int amount){
		return DateUtils.addDays(date, amount);
	}

	public boolean isSameDay(Date dateOne, Date dateTwo){
		return DateUtils.isSameDay(dateOne, dateTwo);
	}
	
	public Long getDateInLong(Date date) {
		Long dateInLong = null; 
		if(null != date) {
			dateInLong = date.getTime();
		}
		return dateInLong;
	}
	
	
	public boolean isGreaterEqualThanToday(Date dateToCompare) {
		boolean result = false;
		if (dateToCompare != null) {
			Date today = new Date();
			// if (today.compareTo(dateToCompare) <= 0) result = true;
			boolean sameDay = isSameDay(today, dateToCompare);
			if (sameDay || today.compareTo(dateToCompare) < 0) result = true;
		}
		return result;
	}
	
	public boolean isGreaterThanToday(Date dateToCompare) {
		boolean result = false;
		if (dateToCompare != null) {
			// get today instance
			Date today = new Date();
			if (today.compareTo(dateToCompare) < 0) result = true;
		}
		return result;
	}
	
}
