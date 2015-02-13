package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class Arkiv implements java.io.Serializable {

	private static final long serialVersionUID = -5367128066455495781L;
	private int id;
	private String AR_ARKIV;
	private String AR_BETEGN;
	private Date AR_FRADATO;
	private Date AR_TILDATO;
	private String AR_MERKNAD;
	
	public Arkiv() {
		
	}
	
	public Arkiv(String aR_ARKIV, String aR_BETEGN, Date aR_FRADATO,
			Date aR_TILDATO, String aR_MERKNAD) {
		super();
		AR_ARKIV = aR_ARKIV;
		AR_BETEGN = aR_BETEGN;
		AR_FRADATO = aR_FRADATO;
		AR_TILDATO = aR_TILDATO;
		AR_MERKNAD = aR_MERKNAD;
	}

	public int getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAR_ARKIV() {
		return AR_ARKIV;
	}

	public void setAR_ARKIV(String aR_ARKIV) {
		AR_ARKIV = aR_ARKIV;
	}

	public String getAR_BETEGN() {
		return AR_BETEGN;
	}

	public void setAR_BETEGN(String aR_BETEGN) {
		AR_BETEGN = aR_BETEGN;
	}
	
	public Date getAR_FRADATO() {
		return AR_FRADATO;
	}
	
	public void setAR_FRADATO(Date aR_FRADATO) {
		AR_FRADATO = aR_FRADATO;
	}
	
	public Date getAR_TILDATO() {
		return AR_TILDATO;
	}
	
	public void setAR_TILDATO(Date aR_TILDATO) {
		AR_TILDATO = aR_TILDATO;
	}
	
	public String getAR_MERKNAD() {
		return AR_MERKNAD;
	}
	
	public void setAR_MERKNAD(String aR_MERKNAD) {
		AR_MERKNAD = aR_MERKNAD;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Arkiv [id=" + id + ", AR_ARKIV=" + AR_ARKIV + ", AR_BETEGN="
				+ AR_BETEGN + ", AR_FRADATO=" + AR_FRADATO + ", AR_TILDATO="
				+ AR_TILDATO + ", AR_MERKNAD=" + AR_MERKNAD + "]";
	}

}