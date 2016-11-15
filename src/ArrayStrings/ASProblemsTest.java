package ArrayStrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ASProblemsTest {

	// Problem 1.3
	@Test
	public void testUrlify() {
		String output = new String(ASProblems.urlify(" Diana Ross Jr         ".toCharArray()));
		assertEquals(output, "%20Diana%20Ross%20Jr%20");
		
		output = new String(ASProblems.urlify("  a cat         ".toCharArray()));
		assertEquals(output, "%20%20a%20cat%20");
	}

}
