// Some useful functions used in project.

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;  
import java.util.Calendar;  

public class Functions {

	public static String giveDateString(Date date)
	{ 
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String strDate = dateFormat.format(date);  
        return strDate;
	}
	
	
	public static Date giveDate(String date) 
	{
		try {
			return new SimpleDateFormat("dd.mm.yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return null;
	}
	
	
	public static LocalDateTime ConvertToLocalDateTime(Date date)
	{
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneOffset.UTC);
	}
	
	
	public static long hoursDiff(Date startDate, Date endDate) 	// Found in stackoverflow and modified for our purpose. 	https://stackoverflow.com/a/43893009
	{ 

	    long different = endDate.getTime() - startDate.getTime();

	    long secondsInMilli = 1000;
	    long minutesInMilli = secondsInMilli * 60;
	    long hoursInMilli = minutesInMilli * 60;
	    long daysInMilli = hoursInMilli * 24;

	    long elapsedHours = different / hoursInMilli;
	    different = different % hoursInMilli;

	    return elapsedHours;
	}
}
