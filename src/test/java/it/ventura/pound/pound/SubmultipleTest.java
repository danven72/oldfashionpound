package it.ventura.pound.pound;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubmultipleTest {

	@Test
	void testSetCurryOver() {
		Submultiple penny = new Submultiple("d", 12, 10);
		assertEquals(10 , penny.getValue());
		assertEquals(0, penny.getCarryOver());
	}

	@Test
	void testSetCurryOverWheOverLimit() {
		Submultiple penny = new Submultiple("d", 12, 15);
		assertEquals(3 , penny.getValue());
		assertEquals(1, penny.getCarryOver());
	}
	
	@Test
	void testSetCurryOverWheOverLimitByMultiple() {
		Submultiple penny = new Submultiple("d", 12, 38);
		assertEquals(2 , penny.getValue());
		assertEquals(3, penny.getCarryOver());
	}

	@Test
	void testGetSymbol() {
		final String SYMBOL = "d";
		Submultiple penny = new Submultiple(SYMBOL, 12, 15);
		assertEquals(SYMBOL, penny.getSymbol());
	}
	
	@Test
	void testAdd() {
		Submultiple penny = new Submultiple("d", 12, 8);
		penny.add(10);
		assertEquals(6 , penny.getValue());
		assertEquals(1, penny.getCarryOver());
		
	}
	
	@Test
	void testSubNumber() {
		Submultiple penny = new Submultiple("d", 12, 8);
		penny.subNumber(5);
		assertEquals(3 , penny.getValue());
	}
	
	@Test
	void testSubNumberWhenExceed() {
		Submultiple penny = new Submultiple("d", 12, 9);
		penny.subNumber(12);
		assertEquals(9 , penny.getValue());
	}

	@Test
	void testMultiply() {
		Submultiple penny = new Submultiple("d", 12, 8);
		penny.multiply(2);
		assertEquals(4 , penny.getValue());
		assertEquals(1, penny.getCarryOver());
	}

	@Test
	void testMultiplyNoCarryOver() {
		Submultiple penny = new Submultiple("d", 12, 6);
		penny.multiply(2);
		assertEquals(12 , penny.getValue());
		assertEquals(0, penny.getCarryOver());
	}

	@Test
	void testMultiplyWhenCarryOverUpperOne() {
		Submultiple penny = new Submultiple("d", 12, 11);
		penny.multiply(4);
		assertEquals(8 , penny.getValue());
		assertEquals(3, penny.getCarryOver());
	}
	
	@Test
	void testDivideWithoutOver() {
		Submultiple penny = new Submultiple("d", 12, 11);
		
		penny.divide(2, 0);
		
		assertEquals(5, penny.getValue());
		assertEquals(1, penny.getRest());
	}

	@Test
	void testDivideWithOver() {
		Submultiple penny = new Submultiple("d", 12, 11);
		
		penny.divide(2, 1);
		
		assertEquals(11, penny.getValue());
		assertEquals(1, penny.getRest());
	}

}
