package com.foxminded.count.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {

	private Map<String, LinkedHashMap<Character, Integer>> cache = new LinkedHashMap<String, LinkedHashMap<Character, Integer>>();

	public Map<String, LinkedHashMap<Character, Integer>> getCache() {
		return cache;
	}

	public LinkedHashMap<Character, Integer> set(String input, LinkedHashMap<Character, Integer> mapAfterProcessor) {
		return this.cache.put(input, mapAfterProcessor);
	}
}
