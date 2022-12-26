import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeJava extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
			String city = (String) req.getParameter("city");
		
			
			TimeZone timeZoneNY = TimeZone.getTimeZone(city);
            Calendar calendarNY = Calendar.getInstance(timeZoneNY);
            int hourNY = calendarNY.get(Calendar.HOUR_OF_DAY);
            int minuteNY = calendarNY.get(Calendar.MINUTE);
            int secondNY = calendarNY.get(Calendar.SECOND);
            String amPm = hourNY > 11 ? "PM" : "AM" ;
            hourNY = hourNY%12 ;
            int hour = hourNY == 0 ? 12 : hourNY ;
            res.getWriter().print("Current time at "+ city + " : " + hour + ":" + minuteNY + ":" + secondNY + "  "+amPm);
	}

}
