package it.ventura.pound.oldfashion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.ventura.pound.oldfashion.OperationResult;
import it.ventura.pound.oldfashion.Pound;

class OperationResultTest {

	@Test
	void testNormalizeRest() {
		
		OperationResult or = new OperationResult(new Pound(), 13);
		final String resultExpected = " (1s 1d)";
		assertEquals(resultExpected, or.normalizeRest());
	}

	@Test
	void testNormalizeRest2() {		
		OperationResult or = new OperationResult(new Pound(), 2);
		final String resultExpected = " (2d)";
		assertEquals(resultExpected, or.normalizeRest());		
	}
	
	@Test
	void testToString() {
		OperationResult or = new OperationResult(new Pound(3,4,5), 2);
		final String resultExpected = "3p 4s 5d (2d)";
		assertEquals(resultExpected, or.toString());
	}

	@Test
	void testToStringNoRest() {
		OperationResult or = new OperationResult(new Pound(3,4,5), 0);
		final String resultExpected = "3p 4s 5d";
		assertEquals(resultExpected, or.toString());
	}

}
