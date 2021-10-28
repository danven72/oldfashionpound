package it.ventura.pound.pound;

public class Main {
	
	public static void sumExample1() {
		Pound pound1 = new Pound("5p 17s 8d");
		Pound pound2 = new Pound("3p 4s 10d");
		OperationResult result = pound1.sum(pound2);

		System.out.println(pound1.toString()+" + " + pound2.toString()+"= " + result.toString());
	}

	public static void subExample1() {
		Pound pound1 = new Pound("5p 17s 8d");
		Pound pound2 = new Pound("3p 4s 10d");
		OperationResult result = pound1.sub(pound2);

		System.out.println(pound1.toString()+" - " + pound2.toString()+" = " + result.toString());
	}
	
	public static void subExampleNegativResult() {
		Pound pound1 = new Pound("5p 17s 8d");
		Pound pound2 = new Pound("5p 18s 10d");
		OperationResult result = pound1.sub(pound2);

		System.out.println(pound1.toString()+" - " + pound2.toString()+" = " + result.toString());
	}


	public static void multiExample1() {
		Pound pound1 = new Pound("5p 17s 8d");
		OperationResult result = pound1.multiply(2);

		System.out.println(pound1.toString()+" * 2 = " + result.toString());
	}

	public static void divisionExample1() {
		Pound pound = new Pound("5p 17s 8d");
		OperationResult divisionResult = pound.divide(3);
		
		System.out.println(pound.toString() + " / 3 = " + divisionResult.toString());		
	}

	public static void divisionExample2() {
		Pound pound = new Pound("18p 16s 1d");
		OperationResult divisionResult = pound.divide(15);
		
		System.out.println(pound.toString() + " / 15 = " + divisionResult.toString());		
	}
	
	

	public static void main(String[] args) {
		sumExample1();
		subExample1();
		subExampleNegativResult();
		multiExample1();
		divisionExample1();
		divisionExample2();
	}

}
