package com.foxminded.count.processors;

import java.util.LinkedHashMap;

public class RealCountProcessor implements CountProcessor {

	@Override
	public LinkedHashMap<Character, Integer> count(String input) {
		LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
		char[] strArray = input.toCharArray();

		for (int i = 0; i < strArray.length; i++) {
			if (charCountMap.containsKey(strArray[i])) {
				charCountMap.put(strArray[i], charCountMap.get(strArray[i]) + 1);
			} else {
				charCountMap.put(strArray[i], 1);
			}
		}
		return charCountMap;
	}

}
