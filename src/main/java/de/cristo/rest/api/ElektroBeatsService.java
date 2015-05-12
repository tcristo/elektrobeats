package de.cristo.rest.api;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.json.stream.*;

/**
 * Created by cristo on 11.05.2015.
 */
@Path( "/playlist" )
public class ElektroBeatsService
{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPlayList(@QueryParam("date") String sdate ) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" );
		Date date = dateFormat.parse( sdate );


		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add( Calendar.DATE, 1); //minus number would decrement the days

		String nextDate = dateFormat.format( cal.getTime());


		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(
			"https://mein.radioeins.de/playList.do?action=searching&remote=1&version=2&from=" + sdate + "_23-00&to=" + nextDate+
			"_01-00" );

		Invocation invocation = target.request( "text/plain" ).buildGet();

		// Invoke the request using generic interface
		String response = invocation.invoke( String.class );
		response = response.substring( response.indexOf( "(" ) + 1, response.lastIndexOf( ")" ) );

		response = response.replace( "<!-- Anfang - Musiktitelanzeige - /portlet/remotePlayListV2.jsp -->","" );
		response = response.replace( "<!-- Ende - Musiktitelanzeige - /portlet/remotePlayListV2.jsp -->","");
		response = response.replace( "\\n","");


		/*
		System.out.println( response1 );


		JsonParserFactory factory = Json.createParserFactory( null );
		JsonParser parser = factory.createParser( new StringReader( response1 ) );

		String key = null;
		String value = null;

		try
		{

			while ( parser.hasNext() )
			{
				final JsonParser.Event event = parser.next();
				switch ( event )
				{
					case KEY_NAME:
						key = parser.getString();
						System.out.println( "Key:" + key );
						break;
					case VALUE_STRING:
						value = parser.getString();
						System.out.println( "Value:" + value );
						break;
				}
			}
		}
		catch ( JsonParsingException ex )
		{
			System.out.println( ex.getMessage() );
		}
		finally
		{
			parser.close();
		}
		*/
		return response;
	}
}
