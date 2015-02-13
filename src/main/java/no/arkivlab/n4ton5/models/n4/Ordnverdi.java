package no.arkivlab.n4ton5.models.n4;

import java.io.Serializable;

public class Ordnverdi implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2500514898477747234L;
	

	protected String OV_ORDNPRI;
	protected String OV_ORDNVER;
	protected String OV_FAR;
	
	protected String OV_BESKR;
	protected Boolean OV_REGFLAGG;
	protected Boolean OV_SEKFLAGG;

	public Ordnverdi() {
		super();
	}

	public String getOV_ORDNPRI() {
		return OV_ORDNPRI;
	}

	public void setOV_ORDNPRI(String oV_ORDNPRI) {
		OV_ORDNPRI = oV_ORDNPRI;
	}

	public String getOV_ORDNVER() {
		return OV_ORDNVER;
	}

	public void setOV_ORDNVER(String oV_ORDNVER) {
		OV_ORDNVER = oV_ORDNVER;
	}

	public String getOV_FAR() {
		return OV_FAR;
	}

	public void setOV_FAR(String oV_FAR) {
		OV_FAR = oV_FAR;
	}

	public String getOV_BESKR() {
		return OV_BESKR;
	}

	public void setOV_BESKR(String oV_BESKR) {
		OV_BESKR = oV_BESKR;
	}

	public Boolean getOV_REGFLAGG() {
		return OV_REGFLAGG;
	}

	public void setOV_REGFLAGG(Boolean oV_REGFLAGG) {
		OV_REGFLAGG = oV_REGFLAGG;
	}

	public Boolean getOV_SEKFLAGG() {
		return OV_SEKFLAGG;
	}

	public void setOV_SEKFLAGG(Boolean oV_SEKFLAGG) {
		OV_SEKFLAGG = oV_SEKFLAGG;
	}

	@Override
	public String toString() {
		return "Ordnverdi [OV_ORDNPRI=" + OV_ORDNPRI + ", OV_ORDNVER="
				+ OV_ORDNVER + ", OV_FAR=" + OV_FAR + ", OV_BESKR=" + OV_BESKR
				+ ", OV_REGFLAGG=" + OV_REGFLAGG + ", OV_SEKFLAGG="
				+ OV_SEKFLAGG + "]";
	}

}
