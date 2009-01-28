
package twilio.markup;

import junit.framework.TestCase;

public class MarkupTest extends TestCase
{
	public void test() throws Exception
	{
		Response rsp = new Response();

		Play play = new Play();
		play.setUrl("http://www.foo.com/music.mp3");
		
		rsp.add(play);
		
		
		rsp.add(new Say("Tell me your name"));
		
		Record r = new Record();
		r.setAction("/foo");
		r.setMethod("POST");
		r.setTimeout(10);
		
		rsp.add(r);
		
		rsp.add(new Say("Thank you"));
		
		
		Dial dial = new Dial("+1 503-555-5555");
		
		rsp.add(dial);
		
		String xml = rsp.toXml();
		
		assertNotNull(xml);
		
		assertTrue(xml.length() > 0);
		
		System.out.println(xml);
	}
}