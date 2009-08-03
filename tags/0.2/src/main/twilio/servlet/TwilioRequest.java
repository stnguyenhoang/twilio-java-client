
package twilio.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import twilio.client.CallStatus;
import twilio.markup.TranscriptionStatus;

public class TwilioRequest extends HttpServletRequestWrapper
{

	public TwilioRequest(HttpServletRequest request)
	{
		super(request);
	}

	public String getCallGuid()
	{
		return this.getParameter("CallGuid");
	}
	
	public String getCaller()
	{
		return this.getParameter("Caller");
	}
	
	public String getCalled()
	{
		return this.getParameter("Called");
	}
	
	public String getAccountGuid()
	{
		return this.getParameter("AccountGuid");
	}
	
	public String getCallStatusParameter()
	{
		return this.getParameter("CallStatus");
	}
	
	public CallStatus getCallStatus()
	{
		if (getCallStatusParameter() == null)
		{
			return null;
		}
		else
		{
			CallStatus status = new CallStatus();
			
			// todo : code here
			
			return status;
		}
		
	}
	
	public String getCallerCity()
	{
		return this.getParameter("CallerCity");
	}
	
	public String getCallerState()
	{
		return this.getParameter("CallerState");
	}
	
	public String getCallerZip()
	{
		return this.getParameter("CallerZip");
	}
	
	public String getCallerCountry()
	{
		return this.getParameter("CallerCountry");
	}
	
	public String getCalledCity()
	{
		return this.getParameter("CalledCity");
	}
	
	public String getCalledState()
	{
		return this.getParameter("CalledState");
	}
	
	public String getCalledZip()
	{
		return this.getParameter("CalledZip");
	}
	
	public String getCalledCountry()
	{
		return this.getParameter("CalledCountry");
	}
	
	public String getDigits()
	{
		return this.getParameter("Digits");
	}
	
	public String getRecordingUrl()
	{
		return this.getParameter("RecordingUrl");
	}
	
	public String getDuration()
	{
		return this.getParameter("Duration");
	}
	
	public String getTwilioSignature()
	{
		return this.getParameter("X-Twilio-Signature");
	}

	public String getDialStatus()
	{
		return this.getParameter("DialStatus");
	}

	public String getTranscriptionText()
	{
		return this.getParameter("TranscriptionText");
	}
	
	public TranscriptionStatus getTranscriptionStatus()
	{
		String ts = this.getParameter("TranscriptionStatus");
		
		return TranscriptionStatus.getTranscriptionStatus(ts);
	}
	
	public String getTranscriptionUrl()
	{
		return this.getParameter("TranscriptionUrl");
	}
	
	public boolean isInboundCall()
	{
		// todo : return ( (getCalled() != null) || (getCalled().equalsIgnoreCase(getAccountPhoneNumber()));
		
		return true;
	}
	
	public boolean isDialCallback()
	{
		return (getDialStatus() != null);
	}
	
	public boolean isRecordCallback()
	{
		return (getRecordingUrl() != null);
	}
	

	public boolean isGatherCallback()
	{
		return (getDigits() != null);
	}

	public boolean isTranscribeCallback()
	{
		return (getTranscriptionStatus() != null);
	}
	
	public boolean isGet()
	{
		return this.getMethod().equalsIgnoreCase("GET");
	}
	
	public boolean isPost()
	{
		return this.getMethod().equalsIgnoreCase("POST");
	}

	public String toString()
	{
		return ServletUtil.toString(this);
	}
}