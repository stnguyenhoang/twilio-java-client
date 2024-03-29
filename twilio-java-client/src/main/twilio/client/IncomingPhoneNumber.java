
package twilio.client;

import java.util.*;

/**
 * 
 * An <i>IncomingPhoneNumber</i> represents a phone number 
 * given to you by Twilio to receive incoming phone calls. 
 *
 */
public class IncomingPhoneNumber implements java.io.Serializable
{
	private String sid;
	private String accountSid;
	private String friendlyName;
	private String phoneNumber;
	private String url;
	private String method;
	private Date dateCreated;
	private Date dateUpdated;

	public String getSid()
	{
		return sid;
	}



	public void setSid(String sid)
	{
		this.sid = sid;
	}



	public String getAccountSid()
	{
		return accountSid;
	}



	public void setAccountSid(String accountSid)
	{
		this.accountSid = accountSid;
	}



	public String getFriendlyName()
	{
		return friendlyName;
	}



	public void setFriendlyName(String friendlyName)
	{
		this.friendlyName = friendlyName;
	}



	public String getPhoneNumber()
	{
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}



	public String getUrl()
	{
		return url;
	}



	public void setUrl(String url)
	{
		this.url = url;
	}



	public String getMethod()
	{
		return method;
	}



	public void setMethod(String method)
	{
		this.method = method;
	}



	public Date getDateCreated()
	{
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}



	public Date getDateUpdated()
	{
		return dateUpdated;
	}



	public void setDateUpdated(Date dateUpdated)
	{
		this.dateUpdated = dateUpdated;
	}



	public String toString()
	{
		// return ToStringBuilder.build(this);
		return "";
	}
	
}
