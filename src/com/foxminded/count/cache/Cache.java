package com.foxminded.count.cache;

import java.util.LinkedHashMap;

public class Cache {

	private LinkedHashMap<String, LinkedHashMap<Character, Integer>> cache = new LinkedHashMap<String, LinkedHashMap<Character, Integer>>();

	public boolean exist(String input) {
		return cache.containsKey(input);
	}

	public LinkedHashMap<Character, Integer> get(String input) {
		return cache.get(input);
	}

	public LinkedHashMap<Character, Integer> set(String input, LinkedHashMap<Character, Integer> mapAfterProcessor) {
		return this.cache.put(input, mapAfterProcessor);
	}
}
