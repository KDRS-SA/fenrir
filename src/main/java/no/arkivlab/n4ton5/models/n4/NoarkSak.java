package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class NoarkSak {
	
	


	protected Integer SA_ID;
	protected Integer SA_SAAR;
	protected Integer SA_SEKNR;
	protected Boolean SA_PAPIR;
	protected Date SA_DATO;
	protected String SA_TITTEL;
	protected Boolean SA_U1;
	protected String SA_STATUS;
	protected String SA_ARKDEL;
	protected String SA_JENHET;
	protected String SA_TYPE;
	protected Integer SA_ADMID;
	protected Integer SA_ANSVID;
	protected String SA_TGKODE;
	protected String SA_UOFF;
	protected Integer SA_TGGRUPPE;

	
	public NoarkSak() {
		super();	
	}
	
	public NoarkSak(Integer sA_ID, Integer sA_SAAR, Integer sA_SEKNR,
			Boolean sA_PAPIR, Date sA_DATO, String sA_TITTEL, Boolean sA_U1,
			String sA_STATUS, String sA_ARKDEL, String sA_TYPE,
			Integer sA_ADMID, Integer sA_ANSVID, String sA_TGKODE,
			String sA_UOFF, Integer sA_TGGRUPPE) {
		super();
		SA_ID = sA_ID;
		SA_SAAR = sA_SAAR;
		SA_SEKNR = sA_SEKNR;
		SA_PAPIR = sA_PAPIR;
		SA_DATO = sA_DATO;
		SA_TITTEL = sA_TITTEL;
		SA_U1 = sA_U1;
		SA_STATUS = sA_STATUS;
		SA_ARKDEL = sA_ARKDEL;
		SA_TYPE = sA_TYPE;
		SA_ADMID = sA_ADMID;
		SA_ANSVID = sA_ANSVID;
		SA_TGKODE = sA_TGKODE;
		SA_UOFF = sA_UOFF;
		SA_TGGRUPPE = sA_TGGRUPPE;
	}

	public Integer getSA_ID() {
		return SA_ID;
	}

	public void setSA_ID(Integer sA_ID) {
		SA_ID = sA_ID;
	}

	public Integer getSA_SAAR() {
		return SA_SAAR;
	}

	public void setSA_SAAR(Integer sA_SAAR) {
		SA_SAAR = sA_SAAR;
	}

	public Integer getSA_SEKNR() {
		return SA_SEKNR;
	}

	public void setSA_SEKNR(Integer sA_SEKNR) {
		SA_SEKNR = sA_SEKNR;
	}

	public Boolean getSA_PAPIR() {
		return SA_PAPIR;
	}

	public void setSA_PAPIR(Boolean  sA_PAPIR) {
		SA_PAPIR = sA_PAPIR;
	}

	public Date getSA_DATO() {
		return SA_DATO;
	}

	public void setSA_DATO(Date sA_DATO) {
		SA_DATO = sA_DATO;
	}

	public String getSA_TITTEL() {
		return SA_TITTEL;
	}

	public void setSA_TITTEL(String sA_TITTEL) {
		SA_TITTEL = sA_TITTEL;
	}

	public Boolean getSA_U1() {
		return SA_U1;
	}

	public void setSA_U1(Boolean sA_U1) {
		SA_U1 = sA_U1;
	}

	public String getSA_STATUS() {
		return SA_STATUS;
	}

	public void setSA_STATUS(String sA_STATUS) {
		SA_STATUS = sA_STATUS;
	}

	public String getSA_ARKDEL() {
		return SA_ARKDEL;
	}

	public void setSA_ARKDEL(String sA_ARKDEL) {
		SA_ARKDEL = sA_ARKDEL;
	}

	public String getSA_TYPE() {
		return SA_TYPE;
	}

	public void setSA_TYPE(String sA_TYPE) {
		SA_TYPE = sA_TYPE;
	}

	public Integer getSA_ADMID() {
		return SA_ADMID;
	}

	public void setSA_ADMID(Integer sA_ADMID) {
		SA_ADMID = sA_ADMID;
	}

	public Integer getSA_ANSVID() {
		return SA_ANSVID;
	}

	public void setSA_ANSVID(Integer sA_ANSVID) {
		SA_ANSVID = sA_ANSVID;
	}

	public String getSA_TGKODE() {
		return SA_TGKODE;
	}

	public void setSA_TGKODE(String sA_TGKODE) {
		SA_TGKODE = sA_TGKODE;
	}

	public String getSA_UOFF() {
		return SA_UOFF;
	}

	public void setSA_UOFF(String sA_UOFF) {
		SA_UOFF = sA_UOFF;
	}

	public Integer getSA_TGGRUPPE() {
		return SA_TGGRUPPE;
	}

	public void setSA_TGGRUPPE(Integer sA_TGGRUPPE) {
		SA_TGGRUPPE = sA_TGGRUPPE;
	}

	public String getSA_JENHET() {
		return SA_JENHET;
	}

	public void setSA_JENHET(String sA_JENHET) {
		SA_JENHET = sA_JENHET;
	}

	@Override
	public String toString() {
		return "NoarkSak [SA_ID=" + SA_ID + ", SA_SAAR=" + SA_SAAR
				+ ", SA_SEKNR=" + SA_SEKNR + ", SA_PAPIR=" + SA_PAPIR
				+ ", SA_DATO=" + SA_DATO + ", SA_TITTEL=" + SA_TITTEL
				+ ", SA_U1=" + SA_U1 + ", SA_STATUS=" + SA_STATUS
				+ ", SA_ARKDEL=" + SA_ARKDEL + ", SA_JENHET=" + SA_JENHET
				+ ", SA_TYPE=" + SA_TYPE + ", SA_ADMID=" + SA_ADMID
				+ ", SA_ANSVID=" + SA_ANSVID + ", SA_TGKODE=" + SA_TGKODE
				+ ", SA_UOFF=" + SA_UOFF + ", SA_TGGRUPPE=" + SA_TGGRUPPE + "]";
	}
}
