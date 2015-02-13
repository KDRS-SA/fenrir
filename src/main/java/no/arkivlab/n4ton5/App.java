package no.arkivlab.n4ton5;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import no.arkivlab.n4ton5.conversion.ConversionControler;
import no.arkivlab.n4ton5.conversion.Mappings;
import no.arkivlab.n4ton5.database.Noark4Database;
import no.arkivlab.n4ton5.database.Noark5Database;
import no.arkivlab.n4ton5.utils.CommandLineHandler;
import no.arkivlab.n4ton5.utils.Constants;
import no.arkivlab.n4ton5.utils.XMLSettingsParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App 
{	
	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args ) throws Exception
    {
    	//TODO: Set logfile location via commandline, autoset if not set here
    	
    	SpringApplication app1 = new SpringApplication(App.class);
        app1.setShowBanner(true);
        app1.run(args);  
        
    	CommandLineHandler clh = new CommandLineHandler(args); 
    	clh.parse();
    	
    	String xmlFileDatabaseSettings = clh.getXmlFileDatabaseSettings();
    	String xmlFileMappingSettings = clh.getXmlFileMapping();
      
    	logger.info(Constants.TOOL_NAME + " : Copy a Noark 4 database to Noark 5 database" );
       
        XMLSettingsParser xmlSettingsParser = new XMLSettingsParser(xmlFileDatabaseSettings, xmlFileMappingSettings);            
    	
    	Noark5Database noark5Database = new Noark5Database(xmlSettingsParser.getDestinationDatabaseParameters());
    	noark5Database.init();
    	
    	Noark4Database noark4Database = new Noark4Database(xmlSettingsParser.getSourceDatabaseParameters(), xmlFileMappingSettings);
    	noark4Database.init();
    	
    	Mappings mappings = xmlSettingsParser.getMappings();
    	
    	ConversionControler conversionControler = new ConversionControler(noark5Database, noark4Database, mappings);
    	conversionControler.run();
    	
    	noark5Database.shutdown();
    	noark4Database.shutdown();
    	
    	String logFileLocation = "unknown";
    	
    	@SuppressWarnings("unchecked")
    	Enumeration <Logger> e = Logger.getRootLogger().getAllAppenders();
        
    	while ( e.hasMoreElements() ){
          Appender app = (Appender)e.nextElement();
          if ( app instanceof FileAppender ){
        	  logFileLocation = ((FileAppender)app).getFile();
          }
        }
    	
    	logger.info(Constants.TOOL_NAME + " : Finished running. Logfile located in " + logFileLocation);        
    }
}
