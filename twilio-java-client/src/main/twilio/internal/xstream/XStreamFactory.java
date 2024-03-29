
package twilio.internal.xstream;

import twilio.client.*;
import twilio.markup.Dial;
import twilio.markup.Number;
import twilio.markup.Play;
import twilio.markup.Redirect;
import twilio.markup.Say;
import twilio.markup.Sms;
import twilio.internal.xstream.TwilioConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class XStreamFactory
{
	
	public static XStream createClientXStream() 
	{
		
		XStream xstream;
		
		// todo : use XppDriver 
		
		xstream = new XStream(new PureJavaReflectionProvider(), new DomDriver())
		{
			protected MapperWrapper wrapMapper(MapperWrapper next)
			{
				return new TwilioMapper(next);
			}
		};
		
		xstream.autodetectAnnotations(true);
		
 		xstream.registerConverter(new IntConverter(), XStream.PRIORITY_VERY_HIGH);
 		xstream.registerConverter(new DateConverter(), XStream.PRIORITY_VERY_HIGH);
 		xstream.registerConverter(new DoubleConverter(), XStream.PRIORITY_VERY_HIGH);
 		// xstream.registerConverter(new BigDecimalConverter(), XStream.PRIORITY_VERY_HIGH);
 		// xstream.registerConverter(new CalendarConverter(), XStream.PRIORITY_VERY_HIGH);
 		
 		xstream.registerConverter(new TwilioListConverter(xstream.getMapper()), XStream.PRIORITY_VERY_HIGH);
 		
 		// xstream.aliasField("Calls", TwilioResponse.class, "calls");
 		// xstream.aliasField("Sid", Call.class, "sid");
 		
		xstream.alias("Account", Account.class);
		xstream.alias("Type", Account.Type.class);
		xstream.alias("Call", Call.class);
		xstream.alias("Calls", Calls.class);
		xstream.alias("Conference", Conference.class);
		xstream.alias("Conferences", Conferences.class);
		xstream.alias("IncomingPhoneNumber", IncomingPhoneNumber.class);
		xstream.alias("IncomingPhoneNumbers", IncomingPhoneNumbers.class);
		xstream.alias("Notification", Notification.class);
		xstream.alias("Notifications", Notifications.class);
		xstream.alias("OutgoingCallerId", OutgoingCallerId.class);
		xstream.alias("OutgoingCallerIds", OutgoingCallerIds.class);
		xstream.alias("Participant", Participant.class);
		xstream.alias("Participants", Participants.class);
		xstream.alias("Recording", Recording.class);
		xstream.alias("Recordings", Recordings.class);
		xstream.alias("SMSMessage", SMSMessage.class);
		xstream.alias("SMSMessages", SMSMessages.class);
		xstream.alias("TwilioException", TwilioException.class);
		xstream.alias("TwilioResponse", TwilioResponse.class);
		xstream.alias("ValidationRequest", ValidationRequest.class);
		
		
		return xstream;
		
	}

	public static XStream createMarkupXStream()
	{
		XStream xstream = new XStream(new PureJavaReflectionProvider(), new DomDriver());
		
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Dial.class, "phoneNumber"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Play.class, "url"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Number.class, "value"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Say.class, "message"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Sms.class, "message"), XStream.PRIORITY_VERY_HIGH);
		xstream.registerConverter(new TwilioConverter(xstream.getMapper(), Redirect.class, "url"), XStream.PRIORITY_VERY_HIGH);
		
		xstream.autodetectAnnotations(true);
		
		return xstream;
	}
	
}
