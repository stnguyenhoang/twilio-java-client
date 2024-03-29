
package twilio.servlet;

import org.springframework.mock.web.MockHttpServletRequest;

import junit.framework.TestCase;


public class SecurityUtilTest extends TestCase
{
	public void test() throws Exception
	{
		
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		
		req.addParameter("a", "a1");
		req.addParameter("b", "b1");
		
		req.setQueryString("foo=bar&color=green");
		
		req.addHeader("X-Twilio-Signature", "xxx");
		
		TwilioRequest trequest = new TwilioRequest(req, "503-555-5555");
		
		boolean result = SecurityUtil.verifyRequest(trequest, "foo");
		
		// todo : assertTrue(result);
		
		// result = SecurityUtil.verifyRequest(new MockHttpServletRequest(), "bogus-auth-token");
		
		// todo : assertFalse(result);
		
	}
}
