package com.foxminded.count.processor;

import java.util.Map;

import com.foxminded.count.cache.Cache;

public class ProxyCountProcessor implements CountProcessor {
	
	RealCountProcessor processor = new RealCountProcessor();

	@Override
	public Map<Character, Integer> count(Cache cache, String input) {
		if(cache.getCache() == null) {
			return processor.count(cache, input);
		}
	else if(cache.getCache().containsKey(input)) {
			return cache.getCache().get(input);
		}else 
			return processor.count(cache, input);
	}

}
