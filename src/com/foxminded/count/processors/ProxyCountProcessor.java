package com.foxminded.count.processors;

import java.util.LinkedHashMap;

import com.foxminded.count.cache.Cache;

public class ProxyCountProcessor implements CountProcessor {

	private RealCountProcessor processor = new RealCountProcessor();
	private Cache cache = new Cache();

	@Override
	public LinkedHashMap<Character, Integer> count(String input) {
		if (input == null) {
			throw new NullPointerException();
		} else if (cache.exist(input)) {
			return cache.get(input);
		} else
			return getRealProcessor(input);
	}

	private LinkedHashMap<Character, Integer> getRealProcessor(String input) {
		cache.set(input, processor.count(input));
		return processor.count(input);
	}

}
