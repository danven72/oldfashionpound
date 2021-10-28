package it.ventura.pound.pound;

public class Main {
	
	public static void division1Example() {
		Pound pound = new Pound("5p 17s 8d");
		OperationResult divisionResult = pound.divide(3);
		
		System.out.println(divisionResult.toString());		
	}

	public static void division2Example() {
		Pound pound = new Pound("18p 16s 1d");
		OperationResult divisionResult = pound.divide(15);
		
		System.out.println(divisionResult.toString());		
	}

	public static void main(String[] args) {
		division1Example();
		division2Example();
	}

}
