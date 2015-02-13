package no.arkivlab.n4ton5.utils;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class CommandLineHandler {

	private static final Logger logger = Logger.getLogger(CommandLineHandler.class);
	private String[] args = null;
	private Options options = new Options();

	protected String xmlFileDatabaseSettings = null;
	protected String xmlFileMapping = null;

	public CommandLineHandler(String[] args) {

		this.args = args;

		options.addOption("h", "help", false, "show help.");
		options.addOption("db", "database", true, "location of file containing database details.");
		options.addOption("map", "mapping", true, "location of file containing hibernate mapping details.");
		
	}

	public void parse() {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("h"))
				help();

			if (cmd.hasOption("db")) {
				logger.log(Level.INFO,	"Database file identified as db=" + cmd.getOptionValue("db"));
				xmlFileDatabaseSettings = cmd.getOptionValue("db");
			} else {
				logger.log(Level.ERROR, "Missing Database settings file ");
				help();
			}

			if (cmd.hasOption("map")) {
				logger.log(Level.INFO,	"Mapping file identified as map=" + cmd.getOptionValue("map"));
				xmlFileMapping = cmd.getOptionValue("map");

			} else {
				logger.log(Level.ERROR, "Missing hibernate mapping file ");
				help();
			}

			
		} catch (ParseException e) {
			logger.log(Level.ERROR, "Error could not to parse comand line options", e);
			help();
		}
	}

	private void help() {
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp(Constants.TOOL_NAME, options);
		System.exit(0);
	}

	public String getXmlFileDatabaseSettings() {
		return xmlFileDatabaseSettings;
	}

	public String getXmlFileMapping() {
		return xmlFileMapping;
	}

}
