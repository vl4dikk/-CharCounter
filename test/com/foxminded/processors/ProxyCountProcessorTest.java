package com.foxminded.processors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.io.ObjectOutputStream.PutField;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.foxminded.count.cache.Cache;
import com.foxminded.count.processors.ProxyCountProcessor;
import com.foxminded.count.processors.RealCountProcessor;

@RunWith(MockitoJUnitRunner.class)
class ProxyCountProcessorTest {

	@InjectMocks
	private ProxyCountProcessor processor = new ProxyCountProcessor();

	private Cache cache = mock(Cache.class);
	private RealCountProcessor realProcessor = mock(RealCountProcessor.class);

	@Test
	void testCountingWithCache_ShouldNotUseRealCountProcessor_WhenAnswerIsInCache() {
		LinkedHashMap<Character, Integer> test = new LinkedHashMap<Character, Integer>();
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
		when(cache.getCache().get("Hello World!")).thenReturn(test);
		Mockito.verify(realProcessor.count("Hello World!"), never());
		assertEquals(test, processor.count("Hello World!"));
	}

}
