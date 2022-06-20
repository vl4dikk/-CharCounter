package com.foxminded.count.processor;

import java.util.Map;

import com.foxminded.count.cache.Cache;

public interface CountProcessor {
	public Map<Character, Integer> count(Cache cache, String input);
}
