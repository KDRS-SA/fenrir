package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class DokVers {

	protected Integer VE_DOKID;
	protected Integer VE_VERSJON;
	protected String VE_VARIANT;
	protected Boolean VE_AKTIV;
	protected String VE_DOKFORMAT;
	protected Integer VE_REGAV;
	protected Date VE_OPPBEDATO;
	protected String VE_TGKODE;
	protected String VE_ARKMERK;
	protected String VE_LAGRENH;
	protected String VE_FILREF;
	protected DokBesk dokBesk;
	
	public DokBesk getDokBesk() {
		return dokBesk;
	}

	public void setDokBesk(DokBesk dokBesk) {
		this.dokBesk = dokBesk;
	}

	public DokVers() {

	}

	public Integer getVE_DOKID() {
		return VE_DOKID;
	}

	public void setVE_DOKID(Integer vE_DOKID) {
		VE_DOKID = vE_DOKID;
	}

	public Integer getVE_VERSJON() {
		return VE_VERSJON;
	}

	public void setVE_VERSJON(Integer vE_VERSJON) {
		VE_VERSJON = vE_VERSJON;
	}

	public String getVE_VARIANT() {
		return VE_VARIANT;
	}

	public void setVE_VARIANT(String vE_VARIANT) {
		VE_VARIANT = vE_VARIANT;
	}

	public Boolean getVE_AKTIV() {
		return VE_AKTIV;
	}

	public void setVE_AKTIV(Boolean vE_AKTIV) {
		VE_AKTIV = vE_AKTIV;
	}

	public String getVE_DOKFORMAT() {
		return VE_DOKFORMAT;
	}

	public void setVE_DOKFORMAT(String vE_DOKFORMAT) {
		VE_DOKFORMAT = vE_DOKFORMAT;
	}

	public Integer getVE_REGAV() {
		return VE_REGAV;
	}

	public void setVE_REGAV(Integer vE_REGAV) {
		VE_REGAV = vE_REGAV;
	}

	public Date getVE_OPPBEDATO() {
		return VE_OPPBEDATO;
	}

	public void setVE_OPPBEDATO(Date vE_OPPBEDATO) {
		VE_OPPBEDATO = vE_OPPBEDATO;
	}

	public String getVE_TGKODE() {
		return VE_TGKODE;
	}

	public void setVE_TGKODE(String vE_TGKODE) {
		VE_TGKODE = vE_TGKODE;
	}

	public String getVE_ARKMERK() {
		return VE_ARKMERK;
	}

	public void setVE_ARKMERK(String vE_ARKMERK) {
		VE_ARKMERK = vE_ARKMERK;
	}

	public String getVE_LAGRENH() {
		return VE_LAGRENH;
	}

	public void setVE_LAGRENH(String vE_LAGRENH) {
		VE_LAGRENH = vE_LAGRENH;
	}

	public String getVE_FILREF() {
		return VE_FILREF;
	}

	public void setVE_FILREF(String vE_FILREF) {
		VE_FILREF = vE_FILREF;
	}

	@Override
	public String toString() {
		return "DokVers [VE_DOKID=" + VE_DOKID + ", VE_VERSJON=" + VE_VERSJON
				+ ", VE_VARIANT=" + VE_VARIANT + ", VE_AKTIV=" + VE_AKTIV
				+ ", VE_DOKFORMAT=" + VE_DOKFORMAT + ", VE_REGAV=" + VE_REGAV
				+ ", VE_OPPBEDATO=" + VE_OPPBEDATO + ", VE_TGKODE=" + VE_TGKODE
				+ ", VE_ARKMERK=" + VE_ARKMERK + ", VE_LAGRENH=" + VE_LAGRENH
				+ ", VE_FILREF=" + VE_FILREF + "]";
	}
	
}
