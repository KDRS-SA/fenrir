package no.arkivlab.n4ton5.conversion;

public class ColumnMapping {
	protected String fromCol;
	protected String fromColType;
	protected String toCol;
	protected String toColType;
	protected String conversion;
	

	public ColumnMapping() {
		super();
	}
	
	public ColumnMapping(String fromCol, String fromColType, String toCol,
			String toColType, String conversion) {
		super();
		this.fromCol = fromCol;
		this.fromColType = fromColType;
		this.toCol = toCol;
		this.toColType = toColType;
		this.conversion = conversion;
	}

	public String getFromCol() {
		return fromCol;
	}



	public void setFromCol(String fromCol) {
		this.fromCol = fromCol;
	}



	public String getFromColType() {
		return fromColType;
	}



	public void setFromColType(String fromColType) {
		this.fromColType = fromColType;
	}



	public String getToCol() {
		return toCol;
	}



	public void setToCol(String toCol) {
		this.toCol = toCol;
	}



	public String getToColType() {
		return toColType;
	}



	public void setToColType(String toColType) {
		this.toColType = toColType;
	}



	public String getConversion() {
		return conversion;
	}



	public void setConversion(String conversion) {
		this.conversion = conversion;
	}



	@Override
	public String toString() {
		return "Mapping [fromCol=" + fromCol + ", fromColType=" + fromColType
				+ ", toCol=" + toCol + ", toColType=" + toColType
				+ ", conversion=" + conversion + "]";
	}

	
}
