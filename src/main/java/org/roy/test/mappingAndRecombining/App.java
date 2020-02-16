package org.roy.test.mappingAndRecombining;

import java.util.ArrayList;
import java.util.logging.Logger;

public class App {
	Logger log = Logger.getLogger("App.class");
	public static void main(String[] args) {
        //initialize services
		MappingService mappingService = MappingService.getInstance();
        mappingService.init();
        
        int[] arr = {2, 3, 4, 5};//input
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i : arr) {
        	list.add(i);
        }
        System.out.println("result string: "+new LetterCombining().letterCombining(list));
	}
}
