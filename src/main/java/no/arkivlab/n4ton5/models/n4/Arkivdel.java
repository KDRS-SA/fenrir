package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class Arkivdel {

	private String AD_ARKDEL;
	private String AD_BETEGN;
	private String AD_ARKIV;
	private String AD_ASTATUS;
	private Integer AD_PERIODE;
	private String AD_PRIMNOK;
	private String AD_BSKODE;
	private String AD_FORTS;
	private Boolean AD_PAPIR;
	private Boolean AD_ELDOK;
	private String AD_NUMSER;
	private Date AD_FRADATO;
	private Date AD_TILDATO;
	private String AD_MERKNAD;
	private String AD_KONTRAV;

	public Arkivdel() {
		super();
	}
	
	public Arkivdel(String aD_ARKDEL, String aD_BETEGN, String aD_ARKIV,
			String aD_ASTATUS, Integer aD_PERIODE, String aD_PRIMNOK,
			String aD_BSKODE, String aD_FORTS, Boolean aD_PAPIR,
			Boolean aD_ELDOK, String aD_NUMSER, Date aD_FRADATO,
			Date aD_TILDATO, String aD_MERKNAD, String aD_KONTRAV) {
		super();
		AD_ARKDEL = aD_ARKDEL;
		AD_BETEGN = aD_BETEGN;
		AD_ARKIV = aD_ARKIV;
		AD_ASTATUS = aD_ASTATUS;
		AD_PERIODE = aD_PERIODE;
		AD_PRIMNOK = aD_PRIMNOK;
		AD_BSKODE = aD_BSKODE;
		AD_FORTS = aD_FORTS;
		AD_PAPIR = aD_PAPIR;
		AD_ELDOK = aD_ELDOK;
		AD_NUMSER = aD_NUMSER;
		AD_FRADATO = aD_FRADATO;
		AD_TILDATO = aD_TILDATO;
		AD_MERKNAD = aD_MERKNAD;
		AD_KONTRAV = aD_KONTRAV;
	}


	public String getAD_ARKDEL() {
		return AD_ARKDEL;
	}

	public void setAD_ARKDEL(String aD_ARKDEL) {
		AD_ARKDEL = aD_ARKDEL;
	}

	public String getAD_BETEGN() {
		return AD_BETEGN;
	}

	public void setAD_BETEGN(String aD_BETEGN) {
		AD_BETEGN = aD_BETEGN;
	}

	public String getAD_ARKIV() {
		return AD_ARKIV;
	}

	public void setAD_ARKIV(String aD_ARKIV) {
		AD_ARKIV = aD_ARKIV;
	}

	public String getAD_ASTATUS() {
		return AD_ASTATUS;
	}

	public void setAD_ASTATUS(String aD_ASTATUS) {
		AD_ASTATUS = aD_ASTATUS;
	}

	public Integer getAD_PERIODE() {
		return AD_PERIODE;
	}

	public void setAD_PERIODE(Integer aD_PERIODE) {
		AD_PERIODE = aD_PERIODE;
	}

	public String getAD_PRIMNOK() {
		return AD_PRIMNOK;
	}

	public void setAD_PRIMNOK(String aD_PRIMNOK) {
		AD_PRIMNOK = aD_PRIMNOK;
	}

	public String getAD_BSKODE() {
		return AD_BSKODE;
	}

	public void setAD_BSKODE(String aD_BSKODE) {
		AD_BSKODE = aD_BSKODE;
	}

	public String getAD_FORTS() {
		return AD_FORTS;
	}

	public void setAD_FORTS(String aD_FORTS) {
		AD_FORTS = aD_FORTS;
	}

	public Boolean getAD_PAPIR() {
		return AD_PAPIR;
	}

	public void setAD_PAPIR(Boolean aD_PAPIR) {
		AD_PAPIR = aD_PAPIR;
	}

	public Boolean getAD_ELDOK() {
		return AD_ELDOK;
	}

	public void setAD_ELDOK(Boolean aD_ELDOK) {
		AD_ELDOK = aD_ELDOK;
	}

	public String getAD_NUMSER() {
		return AD_NUMSER;
	}

	public void setAD_NUMSER(String aD_NUMSER) {
		AD_NUMSER = aD_NUMSER;
	}

	public Date getAD_FRADATO() {
		return AD_FRADATO;
	}

	public void setAD_FRADATO(Date aD_FRADATO) {
		AD_FRADATO = aD_FRADATO;
	}

	public Date getAD_TILDATO() {
		return AD_TILDATO;
	}

	public void setAD_TILDATO(Date aD_TILDATO) {
		AD_TILDATO = aD_TILDATO;
	}

	public String getAD_MERKNAD() {
		return AD_MERKNAD;
	}

	public void setAD_MERKNAD(String aD_MERKNAD) {
		AD_MERKNAD = aD_MERKNAD;
	}

	public String getAD_KONTRAV() {
		return AD_KONTRAV;
	}

	public void setAD_KONTRAV(String aD_KONTRAV) {
		AD_KONTRAV = aD_KONTRAV;
	}

	@Override
	public String toString() {
		return "Arkivdel [AD_ARKDEL=" + AD_ARKDEL
				+ ", AD_BETEGN=" + AD_BETEGN + ", AD_ARKIV=" + AD_ARKIV
				+ ", AD_ASTATUS=" + AD_ASTATUS + ", AD_PERIODE=" + AD_PERIODE
				+ ", AD_PRIMNOK=" + AD_PRIMNOK + ", AD_BSKODE=" + AD_BSKODE
				+ ", AD_FORTS=" + AD_FORTS + ", AD_PAPIR=" + AD_PAPIR
				+ ", AD_ELDOK=" + AD_ELDOK + ", AD_NUMSER=" + AD_NUMSER
				+ ", AD_FRADATO=" + AD_FRADATO + ", AD_TILDATO=" + AD_TILDATO
				+ ", AD_MERKNAD=" + AD_MERKNAD + ", AD_KONTRAV=" + AD_KONTRAV
				+ "]";
	}
	
}
