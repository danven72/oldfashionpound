package it.ventura.pound.oldfashion;

public class OperationResult {
	private Pound pound;
	private int rest;

	public OperationResult(Pound pound, int rest) {
		this.pound = pound;
		this.rest = rest;
	}

	public Pound getPound() {
		return pound;
	}

	public int getRest() {
		return rest;
	}
	
	public String normalizeRest() {
		StringBuilder sb = new StringBuilder();
		Pence p;
		Shilling s;
		if (rest != 0) {
			sb.append(" (");
			p = new Pence(rest);
			if (p.getCarryOver() > 0) {
				s = new Shilling(p.getCarryOver());
				sb.append(s.getValue())
				.append(s.getSymbol());
			}
			if (sb.length() > 2) {
				sb.append(" ");
			}
			sb.append(p.getValue());
			sb.append(p.getSymbol());
			sb.append(")");
		}
		return sb.toString();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(pound.toString());
		sb.append(normalizeRest());
		
		return sb.toString();
	}
	
}
