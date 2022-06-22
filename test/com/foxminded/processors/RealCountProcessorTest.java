package com.foxminded.processors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import com.foxminded.count.processors.RealCountProcessor;

class RealCountProcessorTest {

	private RealCountProcessor processor = new RealCountProcessor();

	@Test
	void testCounting_ShouldReturnLinkedHashMap_WhenStringIsNotNull() {
		LinkedHashMap<Character, Integer> expected = new LinkedHashMap<Character, Integer>();
		expected.put('H', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('W', 1);
		expected.put('r', 1);
		expected.put('d', 1);
		expected.put('!', 1);
		assertEquals(expected, processor.count("Hello World!"));
		;
	}

}
