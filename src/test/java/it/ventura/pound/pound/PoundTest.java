package it.ventura.pound.pound;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PoundTest {

	@Test
	void testSetPrice() {
		Pound pound = new Pound();
		pound.setPrice("12p 6s 10d");
		assertEquals(12, pound.getValue());
		assertEquals(6, pound.getShilling());
		assertEquals(10, pound.getPence());
	}

	@Test
	void setPricePenceNotNormalized() {
		Pound pound = new Pound();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			pound.setPrice("12p 6s 15d");	
		});
		String expectedMessage = "Pence value is not normalized";
		assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void setPriceShillingNotNormalized() {
		Pound pound = new Pound();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			pound.setPrice("12p 21s 12d");	
		});
		String expectedMessage = "Shilling value is not normalized";
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	void testSum() {
		Pound p1 = new Pound(5,17,8);
		Pound p2 = new Pound(3,4,10);
		
		Pound sum = p1.sum(p2);

		assertEquals(6, sum.getPence());		
		assertEquals(2, sum.getShilling());
		assertEquals(9, sum.getValue());
	}
	
	@Test
	void testSub() {
		Pound p1 = new Pound(5,17,8);
		Pound p2 = new Pound(3,4,10);
		
		Pound sub = p1.sub(p2);
		
		assertEquals(10, sub.getPence());		
		assertEquals(12, sub.getShilling());
		assertEquals(2, sub.getValue());
	}
	
	@Test
	void testSubNegative() {
		Pound p1 = new Pound(4,12,6);
		Pound p2 = new Pound(4,19,11);
		
		Pound sum = p1.sub(p2);

		assertEquals(7, sum.getPence());		
		assertEquals(12, sum.getShilling());
		assertEquals(-1, sum.getValue());
	}

	@Test
	void testMultiply() {
		Pound p = new Pound(5,17,8);

		Pound result = p.multiply(2);
		
		assertEquals(4, result.getPence());		
		assertEquals(15, result.getShilling());
		assertEquals(11, result.getValue());
	}

	@Test
	void testMultiply2() {
		Pound p = new Pound(5,10,11);

		Pound result = p.multiply(2);
		
		assertEquals(10, result.getPence());		
		assertEquals(1, result.getShilling());
		assertEquals(11, result.getValue());
		//result.display();
	}
	
	@Test
	void testDivide() {
		Pound p = new Pound(5,17,8);
		
		OperationResult result = p.divide(3);
		Pound poundResult = result.getPound();
		assertEquals(1, poundResult.getValue());
		assertEquals(19, poundResult.getShilling());
		assertEquals(2, poundResult.getPence());
		assertEquals(2, result.getRest());
		System.out.println(result.toString());
	}
	
	@Test
	void testDivideComplexRest() {
		Pound p = new Pound(18,16,1);
		
		OperationResult result = p.divide(15);
		Pound poundResult = result.getPound();
		assertEquals(1, poundResult.getValue());
		assertEquals(5, poundResult.getShilling());
		assertEquals(0, poundResult.getPence());
		assertEquals(13, result.getRest());
		System.out.println(result.toString());
	}

	
	@Test
	void testToString() {
		Pound p = new Pound(5,10,11);
		String resultExpected = "5p 10s 11d";
		
		assertEquals(resultExpected, p.toString());
	}

}
