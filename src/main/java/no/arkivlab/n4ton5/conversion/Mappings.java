package no.arkivlab.n4ton5.conversion;


import java.util.HashMap;

public class Mappings {

	HashMap <String, Mapping> mappings = new HashMap <String, Mapping> ();

	public HashMap <String, Mapping> getMappings() {
		return mappings;
	}

	public void addMapping(String key, Mapping mappings) {
		this.mappings.put(key, mappings);
	}
	
	public boolean contains (String key) {		
		return mappings.containsKey(key);
	}
	
	public Mapping getMapping(String key) {		
		return (Mapping) mappings.get(key);
	}
}
