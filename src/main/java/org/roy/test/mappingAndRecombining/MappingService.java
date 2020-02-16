package org.roy.test.mappingAndRecombining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * singleton pattern design
 * @author C
 *
 */
public class MappingService {
	Logger log = Logger.getLogger("MappingService.class");
    HashMap<String, ArrayList<String>> numberMappingLetters = new HashMap<String, ArrayList<String>>();
    private MappingService() {
    	
    }
    private static class MappingServiceHolder{
    	private static MappingService mappingService = new MappingService();
    }
    public static MappingService getInstance() {
    	return MappingServiceHolder.mappingService;
    }
    
    public void init(){
    	log.info("initializing Mapping Service");
    	try {
    		reload();
    	}catch (Exception e) {
			log.info("mapping service initializing error ");
			e.printStackTrace();
		}
	}
    @SuppressWarnings("unchecked")
    public void reload() throws Exception{
    	Properties properties = new Properties();
        
    	BufferedReader reader = new BufferedReader(new FileReader(".\\src\\mapping.conf"));
    	properties.load(reader);
    	Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
    	while(enumeration.hasMoreElements()) {
    		numberMappingLetters.put(enumeration.nextElement(), new ArrayList<String>());
    	}
    	Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
    	while (iterator.hasNext()) {
			Entry<Object, Object> entry = iterator.next();
			String[] letters = ((String) entry.getValue()).replaceAll(" ", "").split("\\|");
			if (numberMappingLetters.containsKey(entry.getKey())) {
				for(String letter : letters) {
						numberMappingLetters.get(entry.getKey()).add(letter);
				}
			}
		}
    	log.info(numberMappingLetters.size() + " numbers loaded for mapping");
    }
}
