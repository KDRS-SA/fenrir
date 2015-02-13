package no.arkivlab.n4ton5.conversion;

import java.util.ArrayList;


public class Mapping {
	
	

	protected String noark4Table;
	protected String fromTable;
	protected String toTable;
	protected String sql;
	
	protected ArrayList<ColumnMapping> colMappings = new ArrayList <ColumnMapping> () ;
	
	
	public String getNoark4Table() {
		return noark4Table;
	}

	public void setNoark4Table(String noark4Table) {
		this.noark4Table = noark4Table;
	}

	public String getFromTable() {
		return fromTable;
	}

	public void setFromTable(String fromTable) {
		this.fromTable = fromTable;
	}

	public String getToTable() {
		return toTable;
	}

	public void setToTable(String toTable) {
		this.toTable = toTable;
	}


	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public ArrayList<ColumnMapping> getMappings() {
		return colMappings;
	}

	public void addMappings(ColumnMapping columnMapping) {
		colMappings.add(columnMapping);
	}
	
	@Override
	public String toString() {
		return "Mapping [noark4Table=" + noark4Table + ", fromTable="
				+ fromTable + ", toTable=" + toTable + ", sql=" + sql + "]";
	}
	
}
