package com.foxminded.count.processor;

import java.util.HashMap;
import java.util.Map;

import com.foxminded.count.cache.Cache;

public class RealCountProcessor implements CountProcessor{

	@Override
	public Map<Character, Integer> count(Cache cache, String input) {
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        char[] strArray = input.toCharArray();
 
        for (int i = 0; i < strArray.length; i++) {
            if (charCountMap.containsKey(strArray[i])) {
                charCountMap.put(strArray[i], charCountMap.get(strArray[i]) + 1);
            }
            else {
                charCountMap.put(strArray[i], 1);
            }
        }
        cache.set(input, charCountMap);
		return charCountMap;
	}

}
