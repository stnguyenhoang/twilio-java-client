
package twilio.servlet;

import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

import java.util.logging.*;

public class SecurityUtil
{
	private static final Logger log = Logger.getLogger(SecurityUtil.class.getName());
	private static final String CHARSET = "UTF-8";
	private static final String ALGORITHM = "HmacSHA1";

	static private byte[] getBytes(CharSequence seq)
	{
		String str;
		
		if (seq == null)
		{
			return new byte[0];
		}
		if (seq instanceof String)
		{
			str = (String) seq;
		}
		else
		{
			str = seq.toString();
		}
		
		try
		{
			return str.getBytes(CHARSET);
		} 
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	static public boolean verifyRequest(CharSequence data, String twilioSignature, String twilioAuthToken)
	{
		log.fine("verifyRequest data: " + data);
		log.fine("verifyRequest twilioSignature: " + twilioSignature);
		log.fine("verifyRequest twilioAuthToken: " + twilioAuthToken);
		
		return Arrays.equals(getBytes(twilioSignature), calculateSignature(data, twilioAuthToken));
	}
	
	static public byte[] calculateSignature(CharSequence data, String twilioAuthToken)
	{
		
		try
		{
			SecretKeySpec key = new SecretKeySpec(twilioAuthToken.getBytes(CHARSET), ALGORITHM); 
			Mac mac = Mac.getInstance(ALGORITHM);
			mac.init(key);
			
			byte[] base64 = Base64.encodeBase64(mac.doFinal(getBytes(data)));
			
			return base64;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	static public boolean verifyRequest(TwilioRequest req, String twilioAuthToken)
	{
		StringBuffer data = req.getRequestURL();
		
		if (req.getQueryString() != null)
		{
			data.append("?");
			data.append(req.getQueryString());
		}
		
		if (req.getMethod().equalsIgnoreCase("POST"))
		{
			@SuppressWarnings("unchecked")
			Map<String, String> paramMap = req.getParameterMap();
			List<String> keyList = new ArrayList<String>(getPostParameterNames(req));
			Collections.sort(keyList);
			for (String key : keyList)
			{
				data.append(key);
				String value = "";
				if (paramMap.get(key) != null)
				{
					value = paramMap.get(key);
				}
				data.append(value);
			}
			
		}
		
		return verifyRequest(data, req.getTwilioSignature(), twilioAuthToken);
		
	}
	
	private static Set<String> getPostParameterNames(HttpServletRequest req)
	{
		@SuppressWarnings("unchecked")
		Set<String> parameterKeys = (Set<String>) req.getParameterMap().keySet();
		
		Set<String> result = new HashSet<String>(parameterKeys);
		
		result.retainAll(getQueryStringParameterNames(req));
		
		return result;
		
	}
	
	private static Set<String> getQueryStringParameterNames(HttpServletRequest req)
	{
		Set<String> result = new HashSet<String>();
		
		if (req.getQueryString() != null)
		{
			StringTokenizer tokenizer = new StringTokenizer(req.getQueryString(), "&");
			while (tokenizer.hasMoreTokens())
			{
				String token = tokenizer.nextToken();
				int equalSignPosition = token.indexOf('=');
				if (equalSignPosition != -1)
				{
					result.add( token.substring(0, equalSignPosition) );
				}
			}
		}
		
		return result;
	}
}
