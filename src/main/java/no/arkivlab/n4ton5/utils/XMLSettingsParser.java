package no.arkivlab.n4ton5.utils;

import java.util.Collections;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import no.arkivlab.n4ton5.conversion.ColumnMapping;
import no.arkivlab.n4ton5.conversion.Mapping;
import no.arkivlab.n4ton5.conversion.Mappings;
import no.arkivlab.n4ton5.database.DatabaseParameters;

public final class XMLSettingsParser {

	protected DatabaseParameters sourceDatabaseParameters;
	protected DatabaseParameters destinationDatabaseParameters;
	protected Mappings mappings;
	protected String xmlFileDatabaseSettings;
	protected String xmlFileMappingSettings;
	
	private static final Logger logger = Logger.getLogger(XMLSettingsParser.class);

	public XMLSettingsParser(String xmlFileDatabaseSettings, String xmlFileMappingSettings) throws Exception {

		this.xmlFileDatabaseSettings = xmlFileDatabaseSettings;
		this.xmlFileMappingSettings = xmlFileMappingSettings;
		
		logger.info("Checking database settings file (" + xmlFileDatabaseSettings + " for validity");

		// This will check for xml validity against project included xsd file
		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new StreamSource(Constants.MAPPING_DATABASE_XSD_FILE));
		Validator validator = schema.newValidator();
		
		// TODO: throw exception if not valid?????
		validator.validate(new StreamSource(xmlFileDatabaseSettings));

		logger.info("Database settings file (" + xmlFileDatabaseSettings + ") is valid");

		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFileDatabaseSettings);
		
		
		if (document == null) {
			logger.error("Could not instaniate document object in XMLSettingsParser");
		}
		
			String projectType = document.selectSingleNode(
				Constants.MAPPING_PROJECT_TYPE).getStringValue();
		
		logger.info("Project type is: " + projectType);

		String dbUsername = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_USERNAME).getStringValue();
		String dbPassword = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_PASSWORD).getStringValue();
		String dbName = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_DATABASE_NAME).getStringValue();
		String dbType = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_CONNECTOR).getStringValue();
		String dbHost = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_HOST).getStringValue();
		String dbPort = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_PORT).getStringValue();
		String connectionType = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_CONNECTION_TYPE)
				.getStringValue();
		String schemaOptions = document.selectSingleNode(
				Constants.MAPPING_DATABASE_FROM_SCHEMA_OPTIONS)
				.getStringValue();

		sourceDatabaseParameters = new DatabaseParameters(connectionType,
				dbUsername, dbPassword, dbName, dbType, dbHost, dbPort,
				schemaOptions);

		logger.info("Created parameters for source database ... "
				+ sourceDatabaseParameters);
		dbUsername = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_USERNAME).getStringValue();
		dbPassword = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_PASSWORD).getStringValue();
		dbName = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_DATABASE_NAME).getStringValue();
		dbType = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_CONNECTOR).getStringValue();
		dbHost = document.selectSingleNode(Constants.MAPPING_DATABASE_TO_HOST)
				.getStringValue();
		dbPort = document.selectSingleNode(Constants.MAPPING_DATABASE_TO_PORT)
				.getStringValue();
		connectionType = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_CONNECTION_TYPE).getStringValue();
		schemaOptions = document.selectSingleNode(
				Constants.MAPPING_DATABASE_TO_SCHEMA_OPTIONS).getStringValue();

		destinationDatabaseParameters = new DatabaseParameters(connectionType,
				dbUsername, dbPassword, dbName, dbType, dbHost, dbPort,
				schemaOptions);

		logger.info("Created parameters for destination database ... "
				+ destinationDatabaseParameters);

		@SuppressWarnings("unchecked")
		List<Node> mappingNodes = Collections.checkedList(
				document.selectNodes(Constants.MAPPING_MAPPING_NODE),
				Node.class);
		mappings = new Mappings();

		if (mappingNodes.size() > 0) {
			logger.info("Identified " + mappingNodes.size()
					+ " mapping elements to be processed");
		} else {
			logger.info("No mapping nodes found, assuming further configuration via a hibernate mapping file");
		}

		for (Node mappingNode : mappingNodes) {
			Mapping currentMapping = new Mapping();

			currentMapping.setSql(mappingNode.selectSingleNode(
					Constants.MAPPING_SQL).getText());
			currentMapping.setFromTable(mappingNode.selectSingleNode(
					Constants.MAPPING_FROM_TABLE).getText());
			currentMapping.setToTable(mappingNode.selectSingleNode(
					Constants.MAPPING_TO_TABLE).getText());
			currentMapping.setNoark4Table(mappingNode.selectSingleNode(
					Constants.MAPPING_NOARK4_TABLE).getText());

			
			logger.info("currentMapping details " + currentMapping.toString());
			
			
			// TODO: Something is wrong here. Picking up, but take a look at what should be null!!
			@SuppressWarnings("unchecked")
			List<Node> columnNodes = Collections.checkedList(
					mappingNode.selectNodes(Constants.MAPPING_COLUMN_NODE),
					Node.class);

			for (Node columnNode : columnNodes) {
				ColumnMapping columnMapping = new ColumnMapping();

				columnMapping.setFromCol(columnNode.selectSingleNode(
						Constants.MAPPING_COL_FROM_COL).getText());
				columnMapping.setFromColType(columnNode.selectSingleNode(
						Constants.MAPPING_COL_FROM_COL_TYPE).getText());
				columnMapping.setToCol(columnNode.selectSingleNode(
						Constants.MAPPING_COL_TO_COL).getText());
				columnMapping.setToColType(columnNode.selectSingleNode(
						Constants.MAPPING_COL_TO_COL_TYPE).getText());
				

//				columnMapping.setConversion(columnNode.selectSingleNode(
	//					Constants.MAPPING_COL_CONVERSION).getText());

				logger.info("Adding a columnMapping " + columnMapping.toString());

				currentMapping.addMappings(columnMapping);
			}
			mappings.addMapping(mappingNode.selectSingleNode(
					Constants.MAPPING_NOARK4_TABLE).getText(), currentMapping);
		}
	}

	public Mappings getMappings() {
		return mappings;
	}

	public DatabaseParameters getSourceDatabaseParameters() {
		return sourceDatabaseParameters;
	}

	public DatabaseParameters getDestinationDatabaseParameters() {
		return destinationDatabaseParameters;
	}

}
