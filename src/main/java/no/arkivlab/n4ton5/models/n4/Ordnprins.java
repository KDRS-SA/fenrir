package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class Ordnprins {

	protected String OP_ORDNPRI;
	protected String OP_BETEGN;
	protected String OP_LTEKST;
	protected String OP_TYPE;
	protected Boolean OP_OVBESK;
	protected Boolean OP_KLFLAGG;
	protected Boolean OP_SIFLAGG;
	protected Boolean OP_EVOK;
	protected Boolean OP_EVAUTO;
	protected Boolean OP_SEKFLAGG;
	protected Date OP_FRADATO;
	protected Date  OP_TILDATO;
	protected String OP_TGKODE;

	public Ordnprins() {
		
	}
	
	public Ordnprins(String oP_ORDNPRI, String oP_BETEGN,
			String oP_LTEKST, String oP_TYPE, Boolean oP_OVBESK,
			Boolean oP_KLFLAGG, Boolean oP_SIFLAGG, Boolean oP_EVOK,
			Boolean oP_EVAUTO, Boolean oP_SEKFLAGG, Date oP_FRADATO,
			Date oP_TILDATO, String oP_TGKODE) {
		super();
		OP_ORDNPRI = oP_ORDNPRI;
		OP_BETEGN = oP_BETEGN;
		OP_LTEKST = oP_LTEKST;
		OP_TYPE = oP_TYPE;
		OP_OVBESK = oP_OVBESK;
		OP_KLFLAGG = oP_KLFLAGG;
		OP_SIFLAGG = oP_SIFLAGG;
		OP_EVOK = oP_EVOK;
		OP_EVAUTO = oP_EVAUTO;
		OP_SEKFLAGG = oP_SEKFLAGG;
		OP_FRADATO = oP_FRADATO;
		OP_TILDATO = oP_TILDATO;
		OP_TGKODE = oP_TGKODE;		
	}

	public String getOP_ORDNPRI() {
		return OP_ORDNPRI;
	}

	public void setOP_ORDNPRI(String oP_ORDNPRI) {
		OP_ORDNPRI = oP_ORDNPRI;
	}

	public String getOP_BETEGN() {
		return OP_BETEGN;
	}

	public void setOP_BETEGN(String oP_BETEGN) {
		OP_BETEGN = oP_BETEGN;
	}

	public String getOP_LTEKST() {
		return OP_LTEKST;
	}

	public void setOP_LTEKST(String oP_LTEKST) {
		OP_LTEKST = oP_LTEKST;
	}

	public String getOP_TYPE() {
		return OP_TYPE;
	}

	public void setOP_TYPE(String oP_TYPE) {
		OP_TYPE = oP_TYPE;
	}

	public Boolean getOP_OVBESK() {
		return OP_OVBESK;
	}

	public void setOP_OVBESK(Boolean oP_OVBESK) {
		OP_OVBESK = oP_OVBESK;
	}

	public Boolean getOP_KLFLAGG() {
		return OP_KLFLAGG;
	}

	public void setOP_KLFLAGG(Boolean oP_KLFLAGG) {
		OP_KLFLAGG = oP_KLFLAGG;
	}

	public Boolean getOP_SIFLAGG() {
		return OP_SIFLAGG;
	}

	public void setOP_SIFLAGG(Boolean oP_SIFLAGG) {
		OP_SIFLAGG = oP_SIFLAGG;
	}

	public Boolean getOP_EVOK() {
		return OP_EVOK;
	}

	public void setOP_EVOK(Boolean oP_EVOK) {
		OP_EVOK = oP_EVOK;
	}

	public Boolean getOP_EVAUTO() {
		return OP_EVAUTO;
	}

	public void setOP_EVAUTO(Boolean oP_EVAUTO) {
		OP_EVAUTO = oP_EVAUTO;
	}

	public Boolean getOP_SEKFLAGG() {
		return OP_SEKFLAGG;
	}

	public void setOP_SEKFLAGG(Boolean oP_SEKFLAGG) {
		OP_SEKFLAGG = oP_SEKFLAGG;
	}

	public Date getOP_FRADATO() {
		return OP_FRADATO;
	}

	public void setOP_FRADATO(Date oP_FRADATO) {
		OP_FRADATO = oP_FRADATO;
	}

	public Date getOP_TILDATO() {
		return OP_TILDATO;
	}

	public void setOP_TILDATO(Date oP_TILDATO) {
		OP_TILDATO = oP_TILDATO;
	}

	public String getOP_TGKODE() {
		return OP_TGKODE;
	}

	public void setOP_TGKODE(String oP_TGKODE) {
		OP_TGKODE = oP_TGKODE;
	}

	@Override
	public String toString() {
		return "Ordnprins [OP_ORDNPRI=" + OP_ORDNPRI
				+ ", OP_BETEGN=" + OP_BETEGN + ", OP_LTEKST=" + OP_LTEKST
				+ ", OP_TYPE=" + OP_TYPE + ", OP_OVBESK=" + OP_OVBESK
				+ ", OP_KLFLAGG=" + OP_KLFLAGG + ", OP_SIFLAGG=" + OP_SIFLAGG
				+ ", OP_EVOK=" + OP_EVOK + ", OP_EVAUTO=" + OP_EVAUTO
				+ ", OP_SEKFLAGG=" + OP_SEKFLAGG + ", OP_FRADATO=" + OP_FRADATO
				+ ", OP_TILDATO=" + OP_TILDATO + ", OP_TGKODE=" + OP_TGKODE
				+ "]";
	}

}
