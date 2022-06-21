package com.foxminded.count.processors;

import java.util.LinkedHashMap;

import com.foxminded.count.cache.Cache;

public interface CountProcessor {
	public LinkedHashMap<Character, Integer> count(Cache cache, String input);
}
