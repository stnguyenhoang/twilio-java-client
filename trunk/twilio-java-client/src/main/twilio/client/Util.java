
package twilio.client;

import java.util.*;

public class Util
{
	private static final Map<String, String> states = new HashMap<String, String>();

	static
	{
		states.put("AL", "Albabma");
		states.put("AK", "Alaska");
		states.put("AS", "American Samoa");
		states.put("AZ", "Arizona");
		states.put("AR", "Arkansas");
		states.put("CA", "California");
		states.put("CO", "Colorado");
		states.put("CT", "Connecticut");
		states.put("DE", "Delaware");
		states.put("DC", "District of Columbia");
		states.put("FM", "Federated States of Micronesia");
		states.put("FL", "Florida");
		states.put("GA", "Georgia");
		states.put("GU", "Guam");
		states.put("HI", "Hawaii");
		states.put("ID", "Idaho");
		states.put("IL", "Illinois");
		states.put("IN", "Indiana");
		states.put("IA", "Iowa");
		states.put("KS", "Kansas");
		states.put("KY", "Kentucky");
		states.put("LA", "Louisiana");
		states.put("ME", "Maine");
		states.put("MH", "Marshall Islands");
		states.put("MA", "Maryland");
		states.put("MA", "Massachusetts");
		states.put("MI", "Michigan");
		states.put("MN", "Minnesota");
		states.put("MO", "Missouri");
		states.put("MT", "Montana");
		states.put("NE", "Nebraska");
		states.put("NV", "Nevada");
		states.put("NH", "New Hampshire");
		states.put("NJ", "New Jersey");
		states.put("NY", "New York");
		states.put("NC", "North Carolina");
		states.put("ND", "North Dakota");
		states.put("MP", "Northern Mariana Islands");
		states.put("OH", "Ohio");
		states.put("OK", "Oklahoma");
		states.put("OR", "Oregon");
		states.put("PW", "Palau");
		states.put("PA", "Pennsylvania");
		states.put("PR", "Puerto Rico");
		states.put("RI", "Rhode Island");
		states.put("SC", "South Carolina");
		states.put("SD", "South Dakota");
		states.put("TN", "Tennessee");
		states.put("TX", "Texas");
		states.put("UT", "Utah");
		states.put("VT", "Vermont");
		states.put("VI", "Virgin Islands");
		states.put("VA", "Virginia");
		states.put("WA", "Washington");
		states.put("WV", "West Virginia");
		states.put("WI", "Wisconsin");
		states.put("WY", "Wyoming");
	}
	
	
	public static String getStateName(String stateCode)
	{
		if (stateCode != null)
		{
			stateCode = stateCode.toUpperCase();
		}
		return states.get(stateCode);
	}
}
