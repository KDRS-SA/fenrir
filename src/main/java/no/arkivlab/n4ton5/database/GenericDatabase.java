package no.arkivlab.n4ton5.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import no.arkivlab.n4ton5.App;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GenericDatabase {
	protected SessionFactory sessionFactory;
	protected DatabaseParameters databaseParameters;
	
	protected static final Logger logger = Logger.getLogger(App.class);
	
	public GenericDatabase(DatabaseParameters databaseParameters) {
		this.databaseParameters = databaseParameters;		
	}

	protected void createDatabase() throws SQLException, ClassNotFoundException {
		
		// I am not sure if this CREATE DATABASE syntax is the same on all DBHS.		
		logger.info("Creating database " + databaseParameters.getDbName() + " if it does not exist");
		
		
		logger.error("Currently there is a hardcoded line in GenericDatabase.java that loads com.mysql.jdbc.Driver in method createDatabase. This might cause a problem with other databases ");
		logger.error("Either we have to load the other class or only load this if it's mysql");
		
		//TODO: How should this really be handled!!!
		Class.forName("com.mysql.jdbc.Driver");
		
		logger.info("Will connect to " + databaseParameters.getUrlNoDatabaseSelected());
		Connection connection = DriverManager
				.getConnection(databaseParameters.getUrlNoDatabaseSelected());
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE SCHEMA IF NOT EXISTS "
				+ databaseParameters.getDbName());
	}

	public void init() throws Exception {
		createDatabase();
		buildSessionFactory();
	}
	
	
	protected void buildSessionFactory() throws Exception {

			sessionFactory = databaseParameters.getConfiguration()					
					.buildSessionFactory(
							new StandardServiceRegistryBuilder().applySettings(
									databaseParameters.getConfiguration()
											.getProperties()).build());
	}
	
	public void shutdown() {
		sessionFactory.close();
	}

	/*
	 * 
	 * 
	 * // Database has to have user that can create and update a new database,
	 * // but should not be allowed to delete a database // Database should be
	 * created based on configurable (organization/municipality) name // If
	 * destination DB is MySQL then you can use the following // // grant
	 * INSERT, UPDATE, CREATE on *.* to fenrir@localhost identified by 'odin';
	 * // // // Here I want the database user to be able to do everything to a
	 * database except deleting information // and droping it. Also currently no
	 * select
	 * 
	 * 
	 *
	 */
}
