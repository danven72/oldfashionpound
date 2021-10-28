package it.ventura.pound.pound;

public class Submultiple {
	
	private String symbol;
	private int carryOver;
	private int limit;
	private int value;
	private int rest;
	
	public Submultiple(String symbol, int limit, int value) {
		this.symbol = symbol;
		this.limit = limit;
		this.value = value;
		this.rest = 0;
		setCarryOver();
	}
	
	public final void setCarryOver() {
		if (value > limit) {
			int newValue = value % limit;
			carryOver = value / limit;
			value = newValue;
		}
	}
		
	public void add(int valueToAdd) {
		value = value + valueToAdd;
		setCarryOver();
	}
	
	public void subNumber(int number) {
		 if (number > value) {
			 value = value + limit;			 
		 }
		 value = value - number;
	}

	public void multiply(int number) {
		value = value*number;
		setCarryOver();
	}
	
	public int getCarryOver() {
		return carryOver;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	protected int getLimit() {
		return limit;
	}
	
	public void setValue(int aValue) {
		value = aValue;
		setCarryOver();
	}
	
	public void divide(int number, int over) {
		int newValue = value + over*limit;
		rest = newValue%number;
		value = newValue/number;
	}
	
	public int getRest() {
		return rest;
	}
	
}
