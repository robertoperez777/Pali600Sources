package org.kep.sax.parser;

import junit.framework.Assert;

import org.junit.Test;
import org.kep.karton.domain.FmpXMLResult;

public class FmpXMLParserTest {

	@Test
	public void testParseFmpXMl() {
		FmpXMLParser parser = new FmpXMLParser();
		FmpXMLResult result = parser.parseFmpXMl();
		System.out.println(result);
		Assert.assertNotNull(result);		
	}

}
