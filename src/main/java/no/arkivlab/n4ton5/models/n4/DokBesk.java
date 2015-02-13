package no.arkivlab.n4ton5.models.n4;

import java.util.Date;

public class DokBesk {

    protected Integer DB_DOKID;
    protected String DB_KATEGORI;
    protected String DB_TITTEL;
    protected boolean DB_PAPIR;
    protected String DB_LOKPAPIR;
    protected String DB_STATUS;
    protected Integer DB_UTARBAV;
    protected String DB_TGKODE;
    protected String DB_UOFF;
    protected Date DB_AGDATO;
    protected String DB_AGKODE;
    protected Integer DB_TGGRUPPE;
    protected DokLink dokLink;
    
    
    public DokLink getDokLink() {
		return dokLink;
	}

	public void setDokLink(DokLink dokLink) {
		this.dokLink = dokLink;
	}

	public DokBesk() {
        super();
    }
   
    public Integer getDB_DOKID() {
        return DB_DOKID;
    }
    public void setDB_DOKID(Integer dB_DOKID) {
        DB_DOKID = dB_DOKID;
    }
    public String getDB_KATEGORI() {
        return DB_KATEGORI;
    }
    public void setDB_KATEGORI(String dB_KATEGORI) {
        DB_KATEGORI = dB_KATEGORI;
    }
    public String getDB_TITTEL() {
        return DB_TITTEL;
    }
    public void setDB_TITTEL(String dB_TITTEL) {
        DB_TITTEL = dB_TITTEL;
    }
    public boolean isDB_PAPIR() {
        return DB_PAPIR;
    }
    public void setDB_PAPIR(boolean dB_PAPIR) {
        DB_PAPIR = dB_PAPIR;
    }
    public String getDB_LOKPAPIR() {
        return DB_LOKPAPIR;
    }
    public void setDB_LOKPAPIR(String dB_LOKPAPIR) {
        DB_LOKPAPIR = dB_LOKPAPIR;
    }
    public String getDB_STATUS() {
        return DB_STATUS;
    }
    public void setDB_STATUS(String dB_STATUS) {
        DB_STATUS = dB_STATUS;
    }
    public Integer getDB_UTARBAV() {
        return DB_UTARBAV;
    }
    public void setDB_UTARBAV(Integer dB_UTARBAV) {
        DB_UTARBAV = dB_UTARBAV;
    }
    public String getDB_TGKODE() {
        return DB_TGKODE;
    }
    public void setDB_TGKODE(String dB_TGKODE) {
        DB_TGKODE = dB_TGKODE;
    }
    public String getDB_UOFF() {
        return DB_UOFF;
    }
    public void setDB_UOFF(String dB_UOFF) {
        DB_UOFF = dB_UOFF;
    }
    public Date getDB_AGDATO() {
        return DB_AGDATO;
    }
    public void setDB_AGDATO(Date dB_AGDATO) {
        DB_AGDATO = dB_AGDATO;
    }
    public String getDB_AGKODE() {
        return DB_AGKODE;
    }
    public void setDB_AGKODE(String dB_AGKODE) {
        DB_AGKODE = dB_AGKODE;
    }
    public Integer getDB_TGGRUPPE() {
        return DB_TGGRUPPE;
    }
    public void setDB_TGGRUPPE(Integer dB_TGGRUPPE) {
        DB_TGGRUPPE = dB_TGGRUPPE;
    }

    @Override
    public String toString() {
        return "DokLink [DB_DOKID=" + DB_DOKID + ", DB_KATEGORI=" + DB_KATEGORI
                + ", DB_TITTEL=" + DB_TITTEL + ", DB_PAPIR=" + DB_PAPIR
                + ", DB_LOKPAPIR=" + DB_LOKPAPIR + ", DB_STATUS=" + DB_STATUS
                + ", DB_UTARBAV=" + DB_UTARBAV + ", DB_TGKODE=" + DB_TGKODE
                + ", DB_UOFF=" + DB_UOFF + ", DB_AGDATO=" + DB_AGDATO
                + ", DB_AGKODE=" + DB_AGKODE + ", DB_TGGRUPPE=" + DB_TGGRUPPE
                + "]";
    }


}
