package it.ventura.pound.oldfashion;

public class Pound {
	
	private int value;
	private String symbol;
	private Shilling shilling;
	private Pence pence;
	
	public Pound() {
		initialize();
	}
	
	public Pound(String aPrice) {
		initialize();
		setPrice(aPrice);
	}
	
	public Pound(int p, int s, int d) {
		initialize();		
		this.value = p;
		checkShilling(s);
		this.shilling = new Shilling(s);
		checkPence(d);
		this.pence = new Pence(d);
	}
	
	public void setPrice(String aPrice) {
		String poundStr = aPrice.substring(0, aPrice.indexOf(symbol));		
		value = Integer.parseInt(poundStr);
		
		String shillingStr = aPrice.substring(aPrice.indexOf(symbol) + 2, aPrice.indexOf(shilling.getSymbol()));
		int shillingValue = Integer.parseInt(shillingStr);
		checkShilling(shillingValue);
		shilling.setValue(shillingValue);
		
		String penceStr = aPrice.substring(aPrice.indexOf(shilling.getSymbol()) + 2, aPrice.indexOf(pence.getSymbol()));
		int penceValue = Integer.parseInt(penceStr);
		checkPence(penceValue);
		pence.setValue(penceValue);
	}
	
	public OperationResult sum(Pound otherPound) {
		Pound sum = new Pound();
		pence.add(otherPound.getPence());
		sum.setPence(pence);
				
		shilling.add(otherPound.getShilling() + pence.getCarryOver());		
		sum.setShilling(shilling);
		
		setValue(value + otherPound.getValue() + shilling.getCarryOver());
		sum.setValue(value);
		
		return new OperationResult(sum, 0);
	}
	
	public OperationResult sub(Pound otherPound) {
		Pound sub = new Pound();
		if (pence.getValue() < otherPound.getPence()) {
			shilling.setValue(shilling.getValue() -1);			
		}
		pence.subNumber(otherPound.getPence());
		sub.setPence(pence);
		
		if (shilling.getValue() < otherPound.getShilling()) {
			value = value -1;
		}
		shilling.subNumber(otherPound.getShilling());
		sub.setShilling(shilling);
		sub.setValue(value - otherPound.getValue());
		
		return new OperationResult(sub, 0);
	}
	
	public OperationResult multiply(int factor) {
		Pound mult = new Pound();
		pence.multiply(factor);
		mult.setPence(pence);
		
		shilling.multiply(factor);
		shilling.add(pence.getCarryOver());
		mult.setShilling(shilling);
		
		value = value*factor + shilling.getCarryOver();
		mult.setValue(value);
		
		return new OperationResult(mult, 0);
	}
	
	public OperationResult divide(int number) {
		Pound div = new Pound();
		int newValue = value/number;
		int over = value%number;
		
		value = newValue;
		div.setValue(value);

		shilling.divide(number, over);
		div.setShilling(shilling);
		
		pence.divide(number, shilling.getRest());
		div.setPence(pence);
		
		OperationResult or = new OperationResult(div, pence.getRest());
		
		return or;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(value)
		.append(getSymbol())
		.append(" ")
		.append(shilling.getValue())
		.append(shilling.getSymbol())
		.append(" ")
		.append(pence.getValue())
		.append(pence.getSymbol());
		
		return sb.toString();
	}

	public int getValue() {
		return value;
	}
	
	public int getShilling() {
		return shilling.getValue();
	}

	public int getPence() {
		return pence.getValue();
	}
	
	private void initialize() {
		this.value = 0;
		this.symbol = "p";
		this.shilling = new Shilling(0);
		this.pence = new Pence(0);		
	}
	
	private void checkShilling(int shillingValue) {
		if (shillingValue > shilling.getLimit()) throw new IllegalArgumentException("Shilling value is not normalized");
	}
	
	private void checkPence(int penceValue) {
		if (penceValue > pence.getLimit()) throw new IllegalArgumentException("Pence value is not normalized");
	}
	
	private String getSymbol() {
		return symbol;
	}
		
	private void setShilling(Shilling shilling) {
		this.shilling = shilling;
	}
	
	private void setPence(Pence pence) {
		this.pence = pence;
	}

	private void setValue(int value) {
		this.value = value;
	}
}
