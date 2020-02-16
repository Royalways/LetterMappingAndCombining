package org.roy.test.mappingAndRecombining;

import java.util.ArrayList;

public class LetterCombining {
	private MappingService mappingService = MappingService.getInstance();
    private String result = "";
	public String letterCombining(ArrayList<Integer> inputList) {
		if (inputList.size() == 0) {
			System.out.println("Please input some numbers");
		}
		int temp = inputList.get(0);
		inputList.remove(0);
		combining(inputList, this.mappingService.numberMappingLetters.get(temp + ""), "");
		return this.result;
	}

	public void combining(ArrayList<Integer> numList, ArrayList<String> mappingList, String combinedLetter) {
		for (String s : mappingList) {
			String localCombinedLetters = combinedLetter;
			localCombinedLetters += s;
			if (numList.size() == 0) {
				this.result += localCombinedLetters+" ";
			}else {
				ArrayList<Integer> localNumberList = (ArrayList<Integer>) numList.clone();
				int temp = localNumberList.get(0);
				localNumberList.remove(0);
				combining(localNumberList, this.mappingService.numberMappingLetters.get(temp + ""), localCombinedLetters);
			}
		}
	}

}
