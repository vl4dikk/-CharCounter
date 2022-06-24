package com.foxminded.count.processors;

import java.util.LinkedHashMap;

public interface CountProcessor {
	public LinkedHashMap<Character, Integer> count(String input);
}
