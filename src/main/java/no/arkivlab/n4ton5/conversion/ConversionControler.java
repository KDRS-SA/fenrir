package no.arkivlab.n4ton5.conversion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import no.arkivlab.n4ton5.database.Noark4Database;
import no.arkivlab.n4ton5.database.Noark5Database;
import no.arkivlab.n4ton5.models.n4.Arkiv;
import no.arkivlab.n4ton5.models.n4.Arkivdel;
import no.arkivlab.n4ton5.models.n4.DokBesk;
import no.arkivlab.n4ton5.models.n4.DokLink;
import no.arkivlab.n4ton5.models.n4.DokVers;
import no.arkivlab.n4ton5.models.n4.JournPst;
import no.arkivlab.n4ton5.models.n4.NoarkSak;
import no.arkivlab.n4ton5.models.n4.Ordnprins;
import no.arkivlab.n4ton5.models.n4.Ordnverdi;
import no.arkivlab.n4ton5.models.n5.CaseFile;
import no.arkivlab.n4ton5.models.n5.ClassificationSystem;
import no.arkivlab.n4ton5.models.n5.DocumentDescription;
import no.arkivlab.n4ton5.models.n5.DocumentObject;
import no.arkivlab.n4ton5.models.n5.Fonds;
import no.arkivlab.n4ton5.models.n5.Class;
import no.arkivlab.n4ton5.models.n5.RegistryEntry;
import no.arkivlab.n4ton5.models.n5.Series;
import no.arkivlab.n4ton5.utils.Constants;

public class ConversionControler {

	protected Noark5Database noark5Database;
	protected Noark4Database noark4Database;
	protected Mappings mappings;

	protected static final Logger logger = Logger.getLogger(ConversionControler.class);

	protected boolean handleArkiv = true;
	protected boolean handleArkivdel = true;
	protected boolean handleOrdningsprinsipp = true;
	protected boolean handleOrdningsverdi = true;
	protected boolean handleNoarksak = true;
	protected boolean handleJournalpost = true;
	protected boolean handleDokBesk = true;
	protected boolean handleDokVers = true;
	
	
	public ConversionControler(Noark5Database noark5Database,
			Noark4Database noark4Database, Mappings mappings) {
		this.noark5Database = noark5Database;
		this.noark4Database = noark4Database;
		this.mappings = mappings;
		
		// TODO: Get these values in from XML file
		this.handleArkiv = true;
		this.handleArkivdel = true;
		this.handleOrdningsprinsipp = true;
		this.handleOrdningsverdi = true;
		this.handleNoarksak = true;
		this.handleJournalpost = true;
	}

	public void run() throws Exception {

		if (mappings.contains(Constants.ELEMENT_ARKIV)) {
			handleArkivMappedSQL();
		} else if (handleArkiv == true) {
			handleArkivHibernate();
		}

		if (mappings.contains(Constants.ELEMENT_ARKIVDEL)) {
			handleArkivdelMappedSQL();
		} else if (handleArkivdel == true) {
			handleArkivdel();
		}

		if (mappings.contains(Constants.ELEMENT_ORDNPRINS)) {
			handleOrdnprinsMappedSQL();
		} else if (handleOrdningsprinsipp == true) {
			handleOrdnprins();
		}
		
		if (mappings.contains(Constants.ELEMENT_ORDNVERDI)) {
			handleOrndverdiMappedSQL();
		} else if (handleOrdningsverdi == true) {
			handleOrndverdi();
		}
		
		if (mappings.contains(Constants.ELEMENT_NOARKSAK)) {
			handleNoarksakMappedSQL();
		} else if (handleNoarksak == true) {
			handleNoarksak();
		}
		
		if (mappings.contains(Constants.ELEMENT_JOURNPST)) {
			handleJournPstMappedSQL();
		} else if (handleNoarksak == true) {
			handleJournPst();
		}
		
		if (mappings.contains(Constants.ELEMENT_DOKBESK)) {
//			handleDokBeskMappedSQL();
		} else if (handleDokBesk == true) {
			handleDokBesk();
		}
		

		if (mappings.contains(Constants.ELEMENT_DOKVERS)) {
//			handleDokBeskMappedSQL();
		} else if (handleDokVers == true) {
			handleDokVers();
		}
		
		
		
	}

	public void handleArkivHibernate() throws Exception {

		@SuppressWarnings("unchecked")
		List<Arkiv> allArkiv = noark4Database.getAllArkiv();

		for (Iterator<Arkiv> iter = allArkiv.iterator(); iter.hasNext();) {
			Arkiv arkiv = (Arkiv) iter.next();
			logger.info("Copying Hibernate mapped (N4 Arkiv) " + arkiv);

			Fonds fonds = new Fonds();
			fonds.setSystemId(UUID.randomUUID().toString());
			fonds.setTitle(arkiv.getAR_BETEGN());
			fonds.setDescription(arkiv.getAR_MERKNAD());
			fonds.setCreatedDate(arkiv.getAR_FRADATO());
			fonds.setFinalisedDate(arkiv.getAR_TILDATO());

			noark5Database.addFonds(fonds);
		}

		noark4Database.closeSession();
	}

	public void handleArkivMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_ARKIV);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User (SQL) mapped (N4 Arkiv) ");
			Object[] objs = (Object[]) iter.next();

			Fonds fonds = new Fonds();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					fonds.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					fonds.setTitle((objs[i] == null ? null : objs[i].toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					fonds.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					fonds.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					fonds.setFinalisedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addFonds(fonds);
		}// for (Iterator iter
		noark4Database.closeSession();
	}

	@SuppressWarnings("unchecked")
	public void handleArkivdel() throws Exception {
		List<Arkivdel> allArkivdel = noark4Database.getAllArkivdel();

		for (Iterator<Arkivdel> iter = allArkivdel.iterator(); iter.hasNext();) {
			Arkivdel arkivdel = (Arkivdel) iter.next();
			logger.info("Copying Hibernate mapped (N4 Arkivdel) " + arkivdel);

			Series series = new Series();
			series.setSystemId(UUID.randomUUID().toString());
			series.setTitle(arkivdel.getAD_BETEGN());
			series.setDescription(arkivdel.getAD_MERKNAD());
			series.setCreatedDate(arkivdel.getAD_FRADATO());
			series.setFinalisedDate(arkivdel.getAD_TILDATO());

			noark5Database.addSeries(series);
		}

		noark4Database.closeSession();
	}

	public void handleArkivdelMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_ARKIVDEL);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User(SQL) mapped (N4 Arkivdel) ");
			Object[] objs = (Object[]) iter.next();

			Series series = new Series();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					series.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					series.setTitle((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					series.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					series.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					series.setFinalisedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addSeries(series);
		}// for (Iterator iter
		noark4Database.closeSession();
	}

	public void handleOrdnprins() throws Exception {

		// TODO: Should this be configurable?
		String createdBy = System.getProperty("user.name");

		@SuppressWarnings("unchecked")
		List<Ordnprins> allOrdnprins = noark4Database.getAllOrdnprins();

		for (Iterator<Ordnprins> iter = allOrdnprins.iterator(); iter.hasNext();) {
			Ordnprins ordnprins = (Ordnprins) iter.next();
			logger.info("Copying Hibernate mapped (N4 Ordnprins) " + ordnprins);

			ClassificationSystem classificationSystem = new ClassificationSystem();
			classificationSystem.setSystemId(UUID.randomUUID().toString());
			classificationSystem.setTitle(ordnprins.getOP_BETEGN());
			classificationSystem.setCreatedDate(ordnprins.getOP_FRADATO());
			classificationSystem.setCreatedBy(createdBy);
			classificationSystem.setFinalisedDate(ordnprins.getOP_TILDATO());

			noark5Database.addClassificationSystem(classificationSystem);
		}

		noark4Database.closeSession();
	}

	public void handleOrdnprinsMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_ORDNPRINS);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User(SQL) mapped (N4 Ordnprins) ");
			Object[] objs = (Object[]) iter.next();

			ClassificationSystem classificationSystem = new ClassificationSystem();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					classificationSystem.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					classificationSystem.setTitle((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					classificationSystem.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					classificationSystem.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					classificationSystem.setFinalisedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addClassificationSystem(classificationSystem);
		}// for (Iterator iter
		noark4Database.closeSession();
	}

	
	public void handleOrndverdi() throws Exception {
		// TODO: Should this be configurable?
		String createdBy = System.getProperty("user.name");
		@SuppressWarnings("unchecked")
		List<Ordnverdi> allOrdnverdi = noark4Database.getAllOrdnverdi();

		for (Iterator<Ordnverdi> iter = allOrdnverdi.iterator(); iter.hasNext();) {
			Ordnverdi ordnverdi = (Ordnverdi) iter.next();
			logger.info("Copying Hibernate mapped (N4 Ordnverdi) " + ordnverdi);

			Class klass = new Class();
			klass.setSystemId(UUID.randomUUID().toString());
			klass.setClassId(ordnverdi.getOV_ORDNVER());
			klass.setTitle(ordnverdi.getOV_BESKR());
			klass.setCreatedDate(new Date());
			klass.setCreatedBy(createdBy);

			noark5Database.addClass(klass);
		}

		noark4Database.closeSession();
	}

	
	
	public void handleOrndverdiMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_ORDNVERDI);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User(SQL) mapped (N4 Orndverdi) ");
			Object[] objs = (Object[]) iter.next();

			Class klass = new Class();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					klass.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					klass.setTitle((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					klass.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					klass.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					klass.setFinalisedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addClass(klass);
		}// for (Iterator iter
		noark4Database.closeSession();
	}
	
	
	// TODO: NoarkSak currently does not handle reference to secondary classification system.
	// TODO: Finish adding all required calls to casefile
	public void handleNoarksak() throws Exception {
		@SuppressWarnings("unchecked")
		List<NoarkSak> allNoarksak = noark4Database.getAllNoarksak();

		for (Iterator<NoarkSak> iter = allNoarksak.iterator(); iter.hasNext();) {
			NoarkSak noarkSak = (NoarkSak) iter.next();
			logger.info("Copying Hibernate mapped (N4 NoarkSak) " + noarkSak);

			CaseFile caseFile = new CaseFile();
			caseFile.setSystemId(UUID.randomUUID().toString());
			caseFile.setFileId(noarkSak.getSA_SAAR().toString()
					+ noarkSak.getSA_SEKNR().toString());
			caseFile.setTitle(noarkSak.getSA_TITTEL());
			// TODO: caseFile.setOfficialTitle(noarkSak.);

			Boolean paperOrNot = noarkSak.getSA_PAPIR();
			
			if (paperOrNot != null) {			
				caseFile.setDocumentMedium((noarkSak.getSA_PAPIR() == true  ? Constants.NOARK_5_ELEKTRONISK : Constants.NOARK_5_FYSISK));
			}
		
			caseFile.setCaseYear(noarkSak.getSA_SAAR());
			caseFile.setCaseSequenceNumber(noarkSak.getSA_SEKNR());
			caseFile.setCaseDate(noarkSak.getSA_DATO());
			caseFile.setAdministrativeUnit(Integer.toString(noarkSak.getSA_ADMID()));
			caseFile.setCaseResponsible(Integer.toString(noarkSak.getSA_ANSVID()));
			caseFile.setRecordsManagementUnit(noarkSak.getSA_JENHET());
			caseFile.setCaseStatus(noarkSak.getSA_STATUS());
			// caseFile.setLoanedDate(noarkSak.);
			// caseFile

			noark5Database.addCaseFile(caseFile);
		}

		noark4Database.closeSession();

	}

	public void handleNoarksakMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_NOARKSAK);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User(SQL) mapped (N4 Noarksak) ");
			Object[] objs = (Object[]) iter.next();

			CaseFile caseFile = new CaseFile();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					caseFile.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					caseFile.setTitle((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					caseFile.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					caseFile.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					caseFile.setFinalisedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addCaseFile(caseFile);
		}// for (Iterator iter
		noark4Database.closeSession();
	}

	
	
	
	public void handleJournPst() throws Exception {
		@SuppressWarnings("unchecked")
		List<JournPst> allJournPst = noark4Database.getAllJournPst();

		for (Iterator<JournPst> iter = allJournPst.iterator(); iter.hasNext();) {
			JournPst journPst = (JournPst) iter.next();
			logger.info("Copying Hibernate mapped (N4 JournPst) " + journPst);

			RegistryEntry registryEntry = new RegistryEntry();

			registryEntry.setSystemId(UUID.randomUUID().toString());
			// registryEntry.setCreatedBy();
			// registreringsID SA.SAAR+SA.SEKNR+JP.POSTNR
			registryEntry.setTitle(journPst.getJP_INNHOLD());
			// registryEntry.setOfficialTitle();
			registryEntry.setRecordYear(journPst.getJP_JAAR());
			registryEntry.setRecordSequenceNumber(journPst.getJP_SEKNR());
			registryEntry.setRegistryEntryNumber(journPst.getJP_JPOSTNR());
			registryEntry.setRegistryEntryType(journPst.getJP_NDOKTYPE());
			registryEntry.setRecordStatus(journPst.getJP_STATUS());
			registryEntry.setRecordDate(journPst.getJP_JDATO());
			registryEntry.setDocumentDate(journPst.getJP_DOKDATO());
			registryEntry.setSentDate(journPst.getJP_EKSPDATO());
			registryEntry.setNumberOfAttachments(journPst.getJP_ANTVED());
			// registryEntry.setRecordsManagementUnit(journPst.getJP_J);

			noark5Database.addRegistryEntry(registryEntry);
		}

		noark4Database.closeSession();
	}

	
	public void handleJournPstMappedSQL() throws Exception {

		Mapping mapping = mappings.getMapping(Constants.ELEMENT_JOURNPST);
		String sql = mapping.getSql();
		ArrayList<ColumnMapping> colMappings = mapping.getMappings();

		@SuppressWarnings({ "rawtypes" })
		List results = noark4Database.getResultsFromNativeQuery(sql,
				colMappings);

		for (@SuppressWarnings("rawtypes")
		Iterator iter = results.iterator(); iter.hasNext();) {
			logger.info("Copying User(SQL) mapped (N4 JournPst) ");
			Object[] objs = (Object[]) iter.next();

			RegistryEntry registryEntry = new RegistryEntry();

			for (int i = 0; i < objs.length; i++) {
				if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_SYSTEMID) == true) {
					registryEntry.setSystemId((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol.equalsIgnoreCase(Constants.ELEMENT_TITLE) == true) {
					registryEntry.setTitle((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_DESCRIPTION) == true) {
					registryEntry.setDescription((objs[i] == null ? null : objs[i]
							.toString()));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_CREATEDDATE) == true) {
					registryEntry.setCreatedDate((objs[i] == null ? null
							: (Date) objs[i]));
				} else if (colMappings.get(i).toCol
						.equalsIgnoreCase(Constants.ELEMENT_FINALISEDDATE) == true) {
					
				} else {
					throw new Exception("Unknown Noark 5 field ("
							+ colMappings.get(i).toCol.toString() + ")");
				}
			} // for (int i = 0;
			noark5Database.addRegistryEntry(registryEntry);
		}// for (Iterator iter
		noark4Database.closeSession();
	}

	
	public void handleDokBesk() throws Exception {

		List<DokBesk> allDokBesk = noark4Database.getAllDokBesk();

		for (Iterator<DokBesk> iter = allDokBesk.iterator(); iter.hasNext();) {
			DokBesk dokBesk = (DokBesk) iter.next();
			DokLink dokLink = dokBesk.getDokLink(); 
			
			logger.info("Copying Hibernate mapped (N4 DokBesk) " + dokBesk);
			logger.info("Copying Hibernate mapped (N4 DokBesk-DokLink) " + dokLink);
			
			DocumentDescription documentDescription = new DocumentDescription();

			documentDescription.setSystemId(dokBesk.getDB_DOKID().toString());
			documentDescription.setAssociatedWithRecordAs(dokLink.getDL_TYPE());
			//documentDescription.setCreatedDate();
			//documentDescription.setDescription();
			
			Boolean isDB_PAPIR = dokBesk.isDB_PAPIR();
			if (isDB_PAPIR != null) {
				documentDescription.setDocumentMedium((dokBesk.isDB_PAPIR() == true  ? Constants.NOARK_5_ELEKTRONISK : Constants.NOARK_5_FYSISK));
			}
			
			documentDescription.setDocumentNumber(dokLink.getDL_RNR());
			documentDescription.setDocumentStatus(dokBesk.getDB_STATUS());
			documentDescription.setDocumentType(dokBesk.getDB_KATEGORI());
			documentDescription.setTitle(dokBesk.getDB_TITTEL());
			//documentDescription.setAssociatedBy(dokLink.getDL_TKAV());
			documentDescription.setAssociationDate(dokLink.getDL_TKDATO());
			//documentDescription.setCreatedBy(dokBesk.getDB_UTARBAV());
			
			noark5Database.addDocumentDescription(documentDescription);
		}

		noark4Database.closeSession();
	}
	
	public void handleDokVers() throws Exception {

		List<DokVers> allDokVers = noark4Database.getAllDokVers();

		for (Iterator<DokVers> iter = allDokVers.iterator(); iter.hasNext();) {
			DokVers dokVers = (DokVers) iter.next();
			logger.info("Copying Hibernate mapped (N4 DokVers) " + dokVers);
		
			
			DocumentObject documentObject = new DocumentObject();

			documentObject.setVersionNumber(dokVers.getVE_VERSJON());
			documentObject.setVariantFormat(dokVers.getVE_VARIANT());
			documentObject.setFormat(dokVers.getVE_DOKFORMAT());
			// This has to be handled by a constant
			// documentObject.setFormatDetails(dokVers);
			documentObject.setReferenceDocumentFile(dokVers.getVE_FILREF());
			
			noark5Database.addDocumentObject(documentObject);
		}

		noark4Database.closeSession();
	}
}
