package com.foxminded.count.processors;

import java.util.LinkedHashMap;

import com.foxminded.count.cache.Cache;

public class ProxyCountProcessor implements CountProcessor {

	private RealCountProcessor processor = new RealCountProcessor();
	private Cache cache = new Cache();

	@Override
	public LinkedHashMap<Character, Integer> count(String input) {
		if(input == null) {
			throw new NullPointerException();
		} else if (cache.getCache().containsKey(input)) {
			return cache.getCache().get(input);
		} else
			cache.set(input, processor.count(input));
			return processor.count(input);
	}

}
