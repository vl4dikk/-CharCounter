package com.foxminded.count.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
	
	private Map <String, Map<Character, Integer>> cache;
	
	

	public Cache(int size) {
		this.cache = new LinkedHashMap<String, Map<Character,Integer>>(size);
	}

	public Map<String, Map<Character, Integer>> getCache() {
		return cache;
	}

	public  Map<Character, Integer> set (String input, Map<Character, Integer> mapAfterProcessor){
		return this.cache.put(input, mapAfterProcessor);
	}		
}
