package com.foxminded.processors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.foxminded.count.cache.Cache;
import com.foxminded.count.processors.ProxyCountProcessor;
import com.foxminded.count.processors.RealCountProcessor;

class ProxyCountProcessorTest {
	
	ProxyCountProcessor processor = new ProxyCountProcessor();
	LinkedHashMap<Character, Integer> test = new LinkedHashMap<Character, Integer>();	
	
	@Mock
	Cache cache = new Cache();
	RealCountProcessor realProcessor = mock(RealCountProcessor.class);
	
	@Test
	void testCountingWithCache_ShouldNotUseRealCountProcessor_WhenAnswerIsInCache() {
		test.put('H', 1);
		test.put('e', 1);
		test.put('l', 3);
		test.put('o', 2);
		test.put(' ', 1);
		test.put('W', 1);
		test.put('r', 1);
		test.put('d', 1);
		test.put('!', 1);
		cache.set("Hello World", test);
		assertEquals(test, processor.count(cache, "Hello World!"));
		Mockito.verify(realProcessor, times(0));
	}

}
