package no.arkivlab.n4ton5.database;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import no.arkivlab.n4ton5.conversion.ColumnMapping;
import no.arkivlab.n4ton5.models.n4.Arkiv;
import no.arkivlab.n4ton5.models.n4.Arkivdel;
import no.arkivlab.n4ton5.models.n4.DokBesk;
import no.arkivlab.n4ton5.models.n4.DokVers;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Noark4Database extends GenericDatabase {

	protected String arkivHql = "FROM Arkiv";
	protected String arkivdelHql = "FROM Arkivdel";
	protected String ordnprinsHql = "FROM Ordnprins";
	protected String ordnverdiHql = "FROM Ordnverdi";
	protected String noarksakHql = "FROM NoarkSak";
	protected String journpstHql = "FROM JournPst";
	protected String dokBeskHql = "FROM DokBesk";
	protected String dokVerskHql = "FROM DokVers";
	
	protected String hibernateMappingFile;
	
	Session currentSession = null;

	public Noark4Database(DatabaseParameters databaseParameters, String hibernateMappingFile) {
		super(databaseParameters);
		this.hibernateMappingFile = hibernateMappingFile;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void createDatabase() throws SQLException, ClassNotFoundException {
		
		// I am not sure if this CREATE DATABASE syntax is the same on all DBHS.		
		logger.info("Creating database " + databaseParameters.getDbName() + " if it does not exist");
		
		
		logger.error("Currently there is a hardcoded line in GenericDatabase.java that loads com.mysql.jdbc.Driver in method createDatabase. This might cause a problem with other databases ");
		logger.error("Either we have to load the other class or only load this if it's mysql");
		
		
		logger.info("Will connect to " + databaseParameters.getUrlNoDatabaseSelected());
	
	}


	@SuppressWarnings("rawtypes")
	// Run a native SQL query without mapping, providing column identifiers and types
	public List getResultsFromNativeQuery(String sql, ArrayList <ColumnMapping> mappings) throws Exception {

		if (currentSession != null && currentSession.isOpen() == true) {
			currentSession.close();
		}
		currentSession = sessionFactory.openSession();
		SQLQuery query = (SQLQuery) currentSession.createSQLQuery(sql);		

		for (ColumnMapping mapping: mappings) {
			query.addScalar(mapping.getFromCol(), getHibernateType(mapping.getFromColType()));		
		}
		
	
		return query.list();		
	}
	
	
	protected Type getHibernateType(String originalType) throws Exception {
		
		if (originalType.equalsIgnoreCase("date")) {
			return StandardBasicTypes.DATE;
		}
		else if (originalType.equalsIgnoreCase("string")) {
			return StandardBasicTypes.STRING;
		}
		else if (originalType.equalsIgnoreCase("integer")) {
			return StandardBasicTypes.INTEGER;
		}
		else
			throw new Exception ("Unable to handle database type (" + originalType + ") in Noark4Database.java ... bailing");
	}
	
	@SuppressWarnings("rawtypes")
	public List getAllArkiv() {

		if (currentSession != null) {
			currentSession.close();
		}
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(arkivHql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getAllArkivdel() {

		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(arkivdelHql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getAllOrdnprins() {

		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(ordnprinsHql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getAllOrdnverdi() {
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(ordnverdiHql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getAllNoarksak() {
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(noarksakHql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	public List getAllJournPst() {
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(journpstHql);
		return query.list();
	}

	
	public void addArkiv(Arkiv arkiv) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(arkiv);
		session.getTransaction().commit();
	}
	
	public void addArkivdel(Arkivdel arkivdel) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(arkivdel);
		session.getTransaction().commit();
	}
	
	protected void buildSessionFactory() throws Exception {

		sessionFactory = databaseParameters
				.getConfiguration()
				.addResource(hibernateMappingFile)
				.buildSessionFactory(
						new StandardServiceRegistryBuilder().applySettings(
								databaseParameters.getConfiguration()
										.getProperties()).build());
	}

	public void closeSession() {
		if (currentSession != null) {
			currentSession.close();
		}
	}


	@SuppressWarnings("unchecked")
	public List<DokBesk> getAllDokBesk() {
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(dokBeskHql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<DokVers> getAllDokVers() {
		currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery(dokVerskHql);
		return query.list();
	}
	
	
}