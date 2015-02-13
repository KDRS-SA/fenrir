package no.arkivlab.n4ton5.models.n5;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "case_file")
public class CaseFile extends File implements Serializable {

	private static final long serialVersionUID = 1L;

	/** M011 - saksaar (xs:integer) */
	@Column(name = "case_year")
	protected Integer caseYear;

	/** M012 - sakssekvensnummer (xs:integer) */
	@Column(name = "case_sequence_number")
	protected Integer caseSequenceNumber;

	/** M100 - saksdato (xs:date) */
	@Column(name = "case_date")
	@Temporal(TemporalType.DATE)
	protected Date caseDate;

	/** M305 - administrativEnhet (xs:string) */
	@Column(name = "administrative_unit")
	protected String administrativeUnit;

	/** M306 - saksansvarlig (xs:string) */
	@Column(name = "case_responsible")
	protected String caseResponsible;

	/** M308 - journalenhet (xs:string) */
	@Column(name = "records_management_unit")
	protected String recordsManagementUnit;

	/** M052 - saksstatus (xs:string) */
	@Column(name = "case_status")
	protected String caseStatus;

	/** M106 - utlaantDato (xs:date) */
	@Column(name = "loaned_date")
	@Temporal(TemporalType.DATE)
	protected Date loanedDate;

	/** M309 - utlaantTil (xs:string) */
	@Column(name = "loaned_to")
	protected String loanedTo;

	public Integer getCaseYear() {
		return caseYear;
	}

	public void setCaseYear(Integer caseYear) {
		this.caseYear = caseYear;
	}

	public Integer getCaseSequenceNumber() {
		return caseSequenceNumber;
	}

	public void setCaseSequenceNumber(Integer caseSequenceNumber) {
		this.caseSequenceNumber = caseSequenceNumber;
	}

	public Date getCaseDate() {
		return caseDate;
	}

	public void setCaseDate(Date caseDate) {
		this.caseDate = caseDate;
	}

	public String getAdministrativeUnit() {
		return administrativeUnit;
	}

	public void setAdministrativeUnit(String administrativeUnit) {
		this.administrativeUnit = administrativeUnit;
	}

	public String getCaseResponsible() {
		return caseResponsible;
	}

	public void setCaseResponsible(String caseResponsible) {
		this.caseResponsible = caseResponsible;
	}

	public String getRecordsManagementUnit() {
		return recordsManagementUnit;
	}

	public void setRecordsManagementUnit(String recordsManagementUnit) {
		this.recordsManagementUnit = recordsManagementUnit;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Date getLoanedDate() {
		return loanedDate;
	}

	public void setLoanedDate(Date loanedDate) {
		this.loanedDate = loanedDate;
	}

	public String getLoanedTo() {
		return loanedTo;
	}

	public void setLoanedTo(String loanedTo) {
		this.loanedTo = loanedTo;
	}

	@Override
	public String toString() {
		return "CaseFile [caseYear=" + caseYear + ", caseSequenceNumber="
				+ caseSequenceNumber + ", caseDate=" + caseDate
				+ ", administrativeUnit=" + administrativeUnit
				+ ", caseResponsible=" + caseResponsible
				+ ", recordsManagementUnit=" + recordsManagementUnit
				+ ", caseStatus=" + caseStatus + ", loanedDate=" + loanedDate
				+ ", loanedTo=" + loanedTo + "]";
	}

}
