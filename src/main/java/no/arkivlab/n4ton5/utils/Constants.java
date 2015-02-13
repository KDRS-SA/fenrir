package no.arkivlab.n4ton5.utils;

public final class Constants {


		public static final String CONNECTION_DELIMITER = ":";
		public static final String DB_TYPE_MYSQL = "mysql";
		public static final String TOOL_NAME = "KDRS-toolbox-uttrekk";
		
		public static final String MAPPING_DATABASE_XSD_FILE = "kdrs-toolbox-uttrekk.xsd";		
		public static final String MAPPING_PROJECT_TYPE = "/kdrs-toolbox-uttrekk/projectType";
		
		/*
		 * Details of the source database 
		 */
		
		public static final String MAPPING_DATABASE_FROM_USERNAME = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/username";
		public static final String MAPPING_DATABASE_FROM_PASSWORD = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/password";
		// Database name or e.g SID for oracle		
		public static final String MAPPING_DATABASE_FROM_DATABASE_NAME = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/database";
		// connector could be e.g mysql or oracle
		public static final String MAPPING_DATABASE_FROM_CONNECTOR = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/connector";
		// IP-addess or hostname		
		public static final String MAPPING_DATABASE_FROM_HOST = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/host";
		// Port number of the database, no autodetection
		public static final String MAPPING_DATABASE_FROM_PORT = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/port";
		// connection type  could be e.g jdbc
		public static final String MAPPING_DATABASE_FROM_CONNECTION_TYPE = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/connectionType";
		// schema options that hibernate uses
		public static final String MAPPING_DATABASE_FROM_SCHEMA_OPTIONS = "/kdrs-toolbox-uttrekk/databases/sourceDatabase/schemaOptions";

		/*
		 * Details of the destination database 
		 */

		public static final String MAPPING_DATABASE_TO_USERNAME = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/username";
		public static final String MAPPING_DATABASE_TO_PASSWORD = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/password";
		// Database name or e.g SID for oracle
		public static final String MAPPING_DATABASE_TO_DATABASE_NAME = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/database";
		// connector could be e.g mysql or oracle
		public static final String MAPPING_DATABASE_TO_CONNECTOR = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/connector";
		// IP-addess or hostname
		public static final String MAPPING_DATABASE_TO_HOST = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/host";
		// Port number of the database, no autodetection
		public static final String MAPPING_DATABASE_TO_PORT = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/port";
		// connection type  could be e.g jdbc
		public static final String MAPPING_DATABASE_TO_CONNECTION_TYPE = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/connectionType";
		// schema options that hibernate uses
		public static final String MAPPING_DATABASE_TO_SCHEMA_OPTIONS = "/kdrs-toolbox-uttrekk/databases/destinationDatabase/schemaOptions";
		
		
		public static final String MAPPING_MAPPING_NODE = "/kdrs-toolbox-uttrekk/mappings/mapping";
		public static final String MAPPING_COLUMN_NODE = "columns/column";
		
		/*
		 * Per table mapping details 
		 */
		
		public static final String MAPPING_SQL = "sql";
		public static final String MAPPING_FROM_TABLE = "fromTable";
		public static final String MAPPING_TO_TABLE = "toTable";
		public static final String MAPPING_NOARK4_TABLE = "noark4Table";
		
		/*
		 * Individual columns in each table
		 */
		
		public static final String MAPPING_COL_FROM_COL = "fromCol";
		public static final String MAPPING_COL_FROM_COL_TYPE = "fromColType";
		public static final String MAPPING_COL_TO_COL = "toCol";
		public static final String MAPPING_COL_TO_COL_TYPE = "toColType";
		public static final String MAPPING_COL_CONVERSION = "";

		public static final String ELEMENT_ARKIV = "arkiv";
		public static final String ELEMENT_ARKIVDEL = "arkiv";
		public static final String ELEMENT_ORDNPRINS = "ordnprins";
		public static final String ELEMENT_ORDNVERDI = "ordnverdi";
		public static final String ELEMENT_NOARKSAK = "noarksak";
		public static final String ELEMENT_JOURNPST = "journpst";
		public static final String ELEMENT_DOKBESK = "dokbesk";
		public static final String ELEMENT_DOKVERS = "dokvers";				

		public static final String ELEMENT_SYSTEMID = "systemId";
		public static final String ELEMENT_TITLE = "title";
		public static final String ELEMENT_DESCRIPTION = "description";
		public static final String ELEMENT_CREATEDDATE = "createdDate";
		public static final String ELEMENT_CREATEDBY = "createdBy";
		public static final String ELEMENT_FINALISEDDATE = "finalisedDate";
		public static final String ELEMENT_FINALISEDBY = "finalisedBy";	
		public static final String NOARK_5_ELEKTRONISK = "Elektronisk arkiv"; 
		public static final String NOARK_5_FYSISK = "Fysisk arkiv"; 
}
