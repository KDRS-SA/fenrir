package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class DokLink {
	
	protected Integer DL_JPID;
	protected Integer DL_RNR;
	protected Integer DL_DOKID;
	protected String DL_TYPE;
	protected Date DL_TKDATO;
	protected Integer DL_TKAV;
	protected DokBesk dokBesk;
	
	public DokBesk getDokBesk() {
		return dokBesk;
	}

	public void setDokBesk(DokBesk dokBesk) {
		this.dokBesk = dokBesk;
	}

	public DokLink() {
		super();
	}

	public Integer getDL_JPID() {
		return DL_JPID;
	}

	public void setDL_JPID(Integer dL_JPID) {
		DL_JPID = dL_JPID;
	}

	public Integer getDL_RNR() {
		return DL_RNR;
	}

	public void setDL_RNR(Integer dL_RNR) {
		DL_RNR = dL_RNR;
	}

	public Integer getDL_DOKID() {
		return DL_DOKID;
	}

	public void setDL_DOKID(Integer dL_DOKID) {
		DL_DOKID = dL_DOKID;
	}

	public String getDL_TYPE() {
		return DL_TYPE;
	}

	public void setDL_TYPE(String dL_TYPE) {
		DL_TYPE = dL_TYPE;
	}

	public Date getDL_TKDATO() {
		return DL_TKDATO;
	}

	public void setDL_TKDATO(Date dL_TKDATO) {
		DL_TKDATO = dL_TKDATO;
	}

	public Integer getDL_TKAV() {
		return DL_TKAV;
	}

	public void setDL_TKAV(Integer dL_TKAV) {
		DL_TKAV = dL_TKAV;
	}

	@Override
	public String toString() {
		return "DokLink [DL_JPID=" + DL_JPID + ", DL_RNR=" + DL_RNR
				+ ", DL_DOKID=" + DL_DOKID + ", DL_TYPE=" + DL_TYPE
				+ ", DL_TKDATO=" + DL_TKDATO + ", DL_TKAV=" + DL_TKAV + "]";
	}
	
	
	
}