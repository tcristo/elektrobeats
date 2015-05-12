package de.cristo.rest.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cristo on 11.05.2015.
 */
@Path("/wednesdays")
public class WeekDayService
{
	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public List<String> getWednesDay(@QueryParam("year") int year)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" );

		ArrayList<String> wednesDays = new ArrayList<>(  );
		GregorianCalendar cal=new GregorianCalendar();
		int total=365;

		Calendar today = Calendar.getInstance();
		int thisYear = today.get( Calendar.YEAR );
		if(thisYear==year)
			total = today.get( Calendar.DAY_OF_YEAR );


		cal.set(Calendar.YEAR, year);
		if (cal.isLeapYear(year)) {
			total++;
		}

		for(int d=1; d<=total; d++) {
			cal.set(Calendar.DAY_OF_YEAR, d);
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
				wednesDays.add(dateFormat.format( cal.getTime()) );
		}

		return wednesDays;
	}
}
