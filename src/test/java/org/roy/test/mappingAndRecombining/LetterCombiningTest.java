package org.roy.test.mappingAndRecombining;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class LetterCombiningTest {

	@Test
	public void letterCombiningTest() {
        //initialize services
		MappingService mappingService = MappingService.getInstance();
        mappingService.init();
        
        String[] expecteds = new String[2];
        String[] actuals = new String[2];
        
        //case 1
        int[] arr1 = {2};//input
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int i : arr1) {
        	list1.add(i);
        }
        actuals[0] = new LetterCombining().letterCombining(list1);
        expecteds[0] = "a b c ";
        
        //case 2
        int[] arr2 = {2, 3};//input
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for(int i : arr2) {
        	list2.add(i);
        }
        actuals[1] = new LetterCombining().letterCombining(list2);
        expecteds[1] = "ad ae af bd be bf cd ce cf ";
        assertArrayEquals("failed", expecteds, actuals);
	}
}
