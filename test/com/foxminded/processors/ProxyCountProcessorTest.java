package com.foxminded.processors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.count.cache.Cache;
import com.foxminded.count.processors.ProxyCountProcessor;
import com.foxminded.count.processors.RealCountProcessor;

@ExtendWith(MockitoExtension.class)
class ProxyCountProcessorTest {

	@Mock
	private RealCountProcessor realCountProcessor;

	@Mock
	private Cache cache;

	@InjectMocks
	private ProxyCountProcessor processor;

	@Test
	void testCountingWithCache_ShouldNotUseRealCountProcessor_WhenAnswerIsInCache() {
		String input = "Hello World!";
		LinkedHashMap<Character, Integer> test = prepareTestMap();

		Mockito.when(cache.get(input)).thenReturn(test);
		Mockito.when(cache.exist(input)).thenReturn(false, true);
		Mockito.when(realCountProcessor.count(input)).thenReturn(test);

		assertEquals(test, processor.count(input));
		assertEquals(test, processor.count(input));

		Mockito.verify(cache, Mockito.times(1)).get(input);
		Mockito.verify(realCountProcessor, Mockito.times(1)).count(input);

	}

	private LinkedHashMap<Character, Integer> prepareTestMap() {
		LinkedHashMap<Character, Integer> test = new LinkedHashMap<>();
		test.put('H', 1);
		test.put('e', 1);
		test.put('l', 3);
		test.put('o', 2);
		test.put(' ', 1);
		test.put('W', 1);
		test.put('r', 1);
		test.put('d', 1);
		test.put('!', 1);

		return test;
	}

}
