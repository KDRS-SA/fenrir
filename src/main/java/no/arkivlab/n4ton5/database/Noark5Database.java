package no.arkivlab.n4ton5.database;

import no.arkivlab.n4ton5.models.n5.Author;
import no.arkivlab.n4ton5.models.n5.BasicRecord;
import no.arkivlab.n4ton5.models.n5.CaseFile;
import no.arkivlab.n4ton5.models.n5.Class;
import no.arkivlab.n4ton5.models.n5.ClassificationSystem;
import no.arkivlab.n4ton5.models.n5.DocumentDescription;
import no.arkivlab.n4ton5.models.n5.DocumentObject;
import no.arkivlab.n4ton5.models.n5.File;
import no.arkivlab.n4ton5.models.n5.Fonds;
import no.arkivlab.n4ton5.models.n5.FondsCreator;
import no.arkivlab.n4ton5.models.n5.Keyword;
import no.arkivlab.n4ton5.models.n5.Record;
import no.arkivlab.n4ton5.models.n5.RegistryEntry;
import no.arkivlab.n4ton5.models.n5.Series;
import no.arkivlab.n4ton5.models.n5.StorageLocation;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Noark5Database extends GenericDatabase {

	
	
	public Noark5Database(DatabaseParameters databaseParameters) {

		super(databaseParameters);
	}

	@Override
	protected void buildSessionFactory() throws Exception {

		sessionFactory = databaseParameters
				.getConfiguration()
				.addAnnotatedClass(Fonds.class)
				.addAnnotatedClass(Series.class)
				.addAnnotatedClass(ClassificationSystem.class)
				.addAnnotatedClass(Class.class)
				.addAnnotatedClass(File.class)
				.addAnnotatedClass(CaseFile.class)
				.addAnnotatedClass(Record.class)
				.addAnnotatedClass(BasicRecord.class)
				.addAnnotatedClass(RegistryEntry.class)
				.addAnnotatedClass(DocumentDescription.class)
				.addAnnotatedClass(DocumentObject.class)
				.addAnnotatedClass(StorageLocation.class)
				.addAnnotatedClass(Keyword.class)
				.addAnnotatedClass(FondsCreator.class)
				.addAnnotatedClass(Author.class)
				.buildSessionFactory(
						new StandardServiceRegistryBuilder().applySettings(
								databaseParameters.getConfiguration()
										.getProperties()).build());
	}

	public void addFonds(Fonds fonds) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(fonds);
		session.getTransaction().commit();
		session.close();
	}

	public void addSeries(Series series) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(series);
		session.getTransaction().commit();
		session.close();
	}

	public void addClassificationSystem(
			ClassificationSystem classificationSystem) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(classificationSystem);
		session.getTransaction().commit();
		session.close();
	}

	public void addClass(Class klass) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(klass);
		session.getTransaction().commit();
		session.close();
	}

	public void addCaseFile(CaseFile caseFile) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(caseFile);
		session.getTransaction().commit();
		session.close();
	}

	public void addRegistryEntry(RegistryEntry registryEntry) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(registryEntry);
		session.getTransaction().commit();
		session.close();
	}

	public void addDocumentDescription(DocumentDescription documentDescription) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(documentDescription);
		session.getTransaction().commit();
		session.close();
	}

	public void addDocumentObject(DocumentObject documentObject) throws Exception {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(documentObject);
		session.getTransaction().commit();
		session.close();
	}
	
}
