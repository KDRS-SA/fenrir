package no.arkivlab.n4ton5.database;

import org.hibernate.cfg.Configuration;

import no.arkivlab.n4ton5.utils.Constants;

public class DatabaseParameters {
	
	protected String dbUsername;
	protected String dbPassword;
	protected String dbName;
	protected String dbType;
	protected String dbHost;
	protected String dbPort;
	protected String url;
	protected String urlNoDatabaseSelected;
	protected String schemaOptions;

	protected Configuration configuration;
	
	
	public DatabaseParameters(String connectionType, String dbUsername, String dbPassword,
			String dbName, String dbType, String dbHost, String dbPort, String schemaOptions) {
		super();
		
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		this.dbName = dbName;
		this.dbType = dbType;
		this.dbHost = dbHost;
		this.dbPort = dbPort;
		this.schemaOptions = schemaOptions;
		
		this.url = connectionType + Constants.CONNECTION_DELIMITER + 
				   dbType + Constants.CONNECTION_DELIMITER + "//" + 
				   dbHost + Constants.CONNECTION_DELIMITER + 
				   dbPort + "/" + dbName +  "?user=" + dbUsername
					+ "&password=" + dbPassword;
		
		this.urlNoDatabaseSelected = connectionType + Constants.CONNECTION_DELIMITER + 
				   dbType + Constants.CONNECTION_DELIMITER + "//" + 
				   dbHost + Constants.CONNECTION_DELIMITER + 
				   dbPort + "/?user=" + dbUsername
					+ "&password=" + dbPassword;
		
		configuration = new Configuration();
		
		if (dbType.equals(Constants.DB_TYPE_MYSQL)) {
		
			configuration .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			configuration .setProperty("hibernate.connection.driver_class",	"com.mysql.jdbc.Driver");
		}
		
		configuration .setProperty("hibernate.connection.url", connectionType + Constants.CONNECTION_DELIMITER + 
																dbType + Constants.CONNECTION_DELIMITER + "//" + 
															    dbHost + Constants.CONNECTION_DELIMITER + 
																dbPort + "/" + dbName);
		
		configuration .setProperty("hibernate.connection.username", dbUsername);
		configuration .setProperty("hibernate.connection.password", dbPassword);
		configuration .setProperty("hibernate.hbm2ddl.auto", schemaOptions);
		
	}
	
	
	
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public String getDbHost() {
		return dbHost;
	}
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public String getUrl() {
		return url;
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}

	public String getUrlNoDatabaseSelected() {
		return urlNoDatabaseSelected;
	}

	
	@Override
	public String toString() {
		return "DatabaseParameters [dbUsername=" + dbUsername + ", dbPassword=**not shown**"
				+ ", dbName=" + dbName + ", dbType=" + dbType
				+ ", dbHost=" + dbHost + ", dbPort=" + dbPort + ", url=" + url
				+ ", configuration=" + configuration + "]";
	}

}
